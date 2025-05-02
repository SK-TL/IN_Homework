package ru.innopolis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.TV;
import ru.innopolis.repository.TvRepository;
import ru.innopolis.service.TvService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TvServiceImpl implements TvService {

    private final TvRepository tvRepository;

    @Override
    public TV createTV(TV tv) {
        return tvRepository.save(tv);
    }

    @Override
    public Optional<TV> findById(Long id) {
        return tvRepository.findById(id);
    }

    @Override
    public List<TV> findAll() {
        return tvRepository.findAll();
    }

    @Override
    public TV updateTv(Long id, TV data) {
        Optional<TV> tvOptional = tvRepository.findById(id);

        if (tvOptional.isPresent()) {
            TV tv = tvOptional.get();

            if (data.getModel() != null) {
                tv.setModel(data.getModel());
            }
            if (data.getPrice() != null) {
                tv.setPrice(data.getPrice());
            }
            return tvRepository.save(tv);
        } else {
            return null;
        }
    }

    @Override
    public void deleteTv(Long id) {
        tvRepository.deleteById(id);
    }
}
