package homeworks.homework03;

public class Television {
    private int DisplaySize;
    private String DisplayResolution;
    private int Price;
    private String Manufacturer;
    private String Model;


    @Override
    public String toString() {
        return "Television{" +
                "DisplaySize=" + DisplaySize +
                ", DisplayResolution='" + DisplayResolution + '\'' +
                ", Price=" + Price +
                ", Manufacturer='" + Manufacturer + '\'' +
                ", Model='" + Model + '\'' +
                '}';
    }

    public Television() {
        this.DisplaySize = 55;
        this.DisplayResolution = "4k";
        this.Price = 50595;
        this.Manufacturer = "SAMSUNG";
        this.Model = "Samsung UE55DU8000UXRU";
        System.out.println("Мы советуем Вам прибрести самый ходовой вариант телевизора!");
        System.out.println("Модель данного телевизора: " + Model);
        System.out.println("Также, телевизор имеет следующие характеристики: ");
        System.out.println("Диагональ экрана: " + DisplaySize + " дюймов");
        System.out.println("Разрешение экрана: " + DisplayResolution);
        System.out.println("Цена : " + Price + " рублей");
        System.out.println("Производитель: " + Manufacturer);
    }

    public Television (int DisplaySize, String DisplayResolution, int Price, String Manufacturer) {
        ChoosingTelevision(DisplaySize, DisplayResolution, Price, Manufacturer );
    }


    public int getDisplaySize () {
        return DisplaySize;
    }

    public void setDisplaySize (int displaySize) {
        switch (displaySize) {
            case 1: {
                DisplaySize = displaySize=43;
                System.out.println("43 Дюйма телек");
                break;
            }
            case 2: {
                DisplaySize = displaySize=50;
                System.out.println("50 Дюймов телек");
                break;
            }
            case 3: {
                DisplaySize = displaySize=55;
                System.out.println("55 Дюймов телек");
                break;
            }
        }
    }

    public String getDisplayResolution() {
        return DisplayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        if (displayResolution.equalsIgnoreCase("FHD")) {
            DisplayResolution = displayResolution;
            System.out.println("Разрешение Вашего телевизора = " + DisplayResolution);
        } else if (displayResolution.equalsIgnoreCase("4k")) {
            DisplayResolution = displayResolution;
            System.out.println("Разрешение Вашего Телевизора = " + DisplayResolution);
        } else if (displayResolution.equalsIgnoreCase("8k")) {
            DisplayResolution = displayResolution;
            System.out.println("Разрешение Вашего Телевизора = " + DisplayResolution);
        }
    }

    public int getPrice () {
        return Price;
    }

    public void setPrice (int price) {
        switch (price) {
            case 1: {
                Price = price = 30000;
                System.out.println("price 30k");
                break;
            }
            case 2: {
                Price = price = 50000;
                System.out.println("price 50k");
                break;
            }
            case 3: {
                Price = price = 100000;
                System.out.println("price 100k");
                break;
            }
            case 4: {
                Price = price = 300000;
                System.out.println("price 300k");
                break;
            }
        }
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer (String manufacturer) {
        if (manufacturer.equalsIgnoreCase("SAMSUNG")) {
            Manufacturer = manufacturer;
            System.out.println("Производитель Вашего телевизора = " + Manufacturer);
        } else if (manufacturer.equalsIgnoreCase("HISENCE")) {
            Manufacturer = manufacturer;
            System.out.println("Производитель Вашего Телевизора = " + Manufacturer);
        } else if (manufacturer.equalsIgnoreCase("LG")) {
            Manufacturer = manufacturer;
            System.out.println("Производитель Вашего Телевизора = " + Manufacturer);
        }
    }

    public void ChoosingTelevision (int DisplaySize, String DisplayResolution, int Price, String Manufacturer) {
        if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 1 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 1 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "HISENCE 40A5KQ";
            Price = 21595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 1 && Manufacturer.equalsIgnoreCase("LG")) {
            Model = "LG 43LM5762PLD";
            Price = 25595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 2 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 2 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "Hisense 40A4N";
            Price = 22499;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 2 && Manufacturer.equalsIgnoreCase("LG")) {
            Model = "LG 43LM5762PLD";
            Price = 25595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 3 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 3 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "Hisense 40A5NQ";
            Price = 26991;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 3 && Manufacturer.equalsIgnoreCase("LG")) {
            Model = "LG 43LM5772PLA";
            Price = 30059;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 4 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 3 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "Hisense 40A5NQ";
            Price = 28595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 3 && Manufacturer.equalsIgnoreCase("LG")) {
            Model = "LG 43LM5772PLA";
            Price = 30059;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else  if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 1 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 1 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 1 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 2 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 2 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 2 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 3 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 3 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 3 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 4 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 4 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 4 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 1 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 1 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 1 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 2 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 2 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 2 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 3 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 3 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 3 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 4 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 4 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else  if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("FHD") && Price == 4 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("4K") && Price == 1 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("4K") && Price == 1 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "Hisense 43A6N";
            Price = 27595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("4K") && Price == 1 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("4K") && Price == 2 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            Model = "Samsung UE43DU8000UXRU";
            Price = 31595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("4K") && Price == 2 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "Hisense 43E7NQ";
            Price = 30595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("4K") && Price == 2 && Manufacturer.equalsIgnoreCase("LG")) {
            Model = "LG 43UR81009LK";
            Price = 41586;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("4K") && Price == 3 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            Model = "Samsung UE43DU7100UXRU";
            Price = 40595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("4K") && Price == 3 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "Hisense 43A6N";
            Price = 31999;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("4K") && Price == 3 && Manufacturer.equalsIgnoreCase("LG")) {
            Model = "LG 43QNED80T6A";
            Price = 55586;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("4K") && Price == 4 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            Model = "Samsung QA43Q65CAKXXT";
            Price = 58486;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("4K") && Price == 4 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "Hisense 43E7NQ";
            Price = 34999;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("4K") && Price == 4 && Manufacturer.equalsIgnoreCase("LG")) {
            Model = "LG 43UT81006LA";
            Price = 41586;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("4K") && Price == 1 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("4K") && Price == 1 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "Hisense 50A6K";
            Price = 29999;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("4K") && Price == 1 && Manufacturer.equalsIgnoreCase("LG")) {
            Model = "LG 50NANO806QA";
            Price = 27796;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("4K") && Price == 2 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            Model = "Samsung UE50DU7100UXRU";
            Price = 33595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("4K") && Price == 2 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "Hisense 50A6N";
            Price = 33595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("4K") && Price == 2 && Manufacturer.equalsIgnoreCase("LG")) {
            Model = "LG 50UT80006LA.ARUB";
            Price = 49999;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("4K") && Price == 3 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            Model = "Samsung QE50Q60DAUXRU";
            Price = 73990;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("4K") && Price == 3 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "Hisense 50E7NQ";
            Price = 40595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("4K") && Price == 3 && Manufacturer.equalsIgnoreCase("LG")) {
            Model = "LG 50QNED80T6A";
            Price = 69586;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("4K") && Price == 4 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            Model = "Samsung QE50QN90DAUXRU";
            Price = 190595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("4K") && Price == 4 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "Hisense 50E7KQ";
            Price = 33595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("4K") && Price == 4 && Manufacturer.equalsIgnoreCase("LG")) {
            Model = "Телевизор LG 50QNED86T6A";
            Price = 83586;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("4K") && Price == 1 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("4K") && Price == 1 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("4K") && Price == 1 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("4K") && Price == 2 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            Model = "Samsung UE58AU7500U";
            Price = 45196;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("4K") && Price == 2 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "Hisense 55E7HQ";
            Price = 31596;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("4K") && Price == 2 && Manufacturer.equalsIgnoreCase("LG")) {
            Model = "LG 55UR78001LJ";
            Price = 39596;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("4K") && Price == 3 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            Model = "Samsung UE55DU8000UXRU";
            Price = 50595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("4K") && Price == 3 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "Hisense 55E7KQ PRO";
            Price = 55595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("4K") && Price == 3 && Manufacturer.equalsIgnoreCase("LG")) {
            Model = "LG 55UQ7050PSA";
            Price = 58486;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("4K") && Price == 4 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            Model = "Samsung QE55S95CAU";
            Price = 285595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("4K") && Price == 4 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            Model = "Hisense 55A85K";
            Price = 145595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("4K") && Price == 4 && Manufacturer.equalsIgnoreCase("LG")) {
            Model = "LG OLED55G4RLA.ARUB";
            Price = 226586;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("8K") && Price == 1 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("8K") && Price == 1 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("8K") && Price == 1 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("8K") && Price == 2 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("8K") && Price == 2 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("8K") && Price == 2 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("8K") && Price == 3 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("8K") && Price == 3 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("8K") && Price == 3 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("8K") && Price == 4 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("8K") && Price == 4 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 1 && DisplayResolution.equalsIgnoreCase("8K") && Price == 4 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("8K") && Price == 1 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("8K") && Price == 1 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("8K") && Price == 1 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("8K") && Price == 2 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("8K") && Price == 2 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("8K") && Price == 2 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("8K") && Price == 3 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("8K") && Price == 3 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("8K") && Price == 3 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("8K") && Price == 4 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("8K") && Price == 4 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 2 && DisplayResolution.equalsIgnoreCase("8K") && Price == 4 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("8K") && Price == 1 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("8K") && Price == 1 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("8K") && Price == 1 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("8K") && Price == 2 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("8K") && Price == 2 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("8K") && Price == 2 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("8K") && Price == 3 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("8K") && Price == 3 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("8K") && Price == 3 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("8K") && Price == 4 && Manufacturer.equalsIgnoreCase("SAMSUNG")) {
            Model = "Samsung QE55QN700CUX";
            Price = 211595;
            System.out.println("По выбранным параметрам можем предложить Вам следующую модель телевизора: " + Model + " c ценой " + Price + " рублей!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("8K") && Price == 4 && Manufacturer.equalsIgnoreCase("HISENCE")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        } else if (DisplaySize == 3 && DisplayResolution.equalsIgnoreCase("8K") && Price == 4 && Manufacturer.equalsIgnoreCase("LG")) {
            System.out.println("К сожалению, у данного производителя нет подходящей модели! Попробуйте снова!");
        }
    }
}
