package ru.innopolis.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.entity.TV;
import ru.innopolis.service.impl.TvServiceImpl;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tv")
@RequiredArgsConstructor
public class TvController {

    private final TvServiceImpl tvServiceImpl;

    @PostMapping("/tv")
    @Operation(summary = "Создание")
    public ResponseEntity<TV> createTv (@RequestBody TV tv) {
        TV createTv = tvServiceImpl.createTV(tv);
        return new ResponseEntity<>(createTv, HttpStatus.CREATED);
    }

    @GetMapping("/tv/{id}")
    @Operation(summary = "Получение по Айди")
    public ResponseEntity<TV> getTvId(@PathVariable Long id) {
        return tvServiceImpl.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tvs")
    @Operation(summary = "Получение всех")
    public ResponseEntity<List<TV>> getAllUsers() {
        List<TV> tvs = tvServiceImpl.findAll();
        return ResponseEntity.ok(tvs);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновление")
    public ResponseEntity<TV> updateTv(@PathVariable Long id, @RequestBody TV tvData) {
        TV updatedTv = tvServiceImpl.updateTv(id, tvData);
        return updatedTv != null ? ResponseEntity.ok(updatedTv) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/tv/{id}")
    @Operation(summary = "Удаление")
    public ResponseEntity<Void> deleteTv(@PathVariable Long id) {
        tvServiceImpl.deleteTv(id);
        return ResponseEntity.noContent().build();
    }
}
