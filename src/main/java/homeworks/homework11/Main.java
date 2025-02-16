package main.java.homeworks.homework11;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File inputPath = new File("src\\main\\java\\homeworks\\homework11\\input.txt");
        File outputPath = new File("src\\main\\java\\homeworks\\homework11\\output.txt");
        List<Car> carList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath))) {
            bufferedReader.readLine(); // Пропуск первой строки (Заголовка)
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                Car car = new Car(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                carList.add(car);
                bufferedWriter.write(car + "\n");
            }

            bufferedWriter.write("\n");

            // 1) Номера всех автомобилей, имеющих заданный в переменной цвет colorToFind или нулевой пробег mileageToFind.
            String colorToFind = "Black";
            Integer mileageToFind = 0;
            String numbers = carList.stream()
                    .filter(car -> car.getCarColor().equals(colorToFind) || car.getCarMileage().equals(mileageToFind))
                    .map(Car::getCarNumber)
                    .collect(Collectors.joining(", "));
            bufferedWriter.write("Номера автомобилей по цвету или пробегу: " + numbers + "\n");

            // 2) Количество уникальных моделей в ценовом диапазоне от n до m тыс.
            Integer minPrice = 700000;
            Integer maxPrice = 800000;
            long countModel = carList.stream()
                    .filter(car -> car.getCarPrice() > minPrice && car.getCarPrice() < maxPrice)
                    .count();
            bufferedWriter.write("Уникальные автомобили: " + countModel + "\n");

            // 3) Вывести цвет автомобиля с минимальной стоимостью.
            Optional<Car> lowCarPrice = carList.stream()
                    .min(Comparator.comparingInt(Car::getCarPrice));
            String colorCarWithLowPrice = lowCarPrice.get().getCarColor();
            bufferedWriter.write("Цвет автомобиля с минимальной стоимостью: " + colorCarWithLowPrice + "\n");

            // 4) Среднюю стоимость искомой модели modelToFind. (Для моделей: Toyota, Volvo)
            String modelToFindFirst = "Toyota";
            OptionalDouble averagePriceFirstCar = carList.stream()
                    .filter(car -> car.getCarModel().equals(modelToFindFirst))
                    .mapToDouble(Car::getCarPrice)
                    .average();
            bufferedWriter.write("Средняя стоимость модели " + modelToFindFirst + " : " + averagePriceFirstCar.orElse(0) + "\n");

            String modelToFindSecond = "Volvo";
            OptionalDouble averagePriceSecondCar = carList.stream()
                    .filter(car -> car.getCarModel().equals(modelToFindSecond))
                    .mapToDouble(Car::getCarPrice)
                    .average();
            bufferedWriter.write("Средняя стоимость модели " + modelToFindSecond + " : " + averagePriceSecondCar.orElse(0) +"\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}