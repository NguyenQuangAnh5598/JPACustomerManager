package com.service.provinceService;

import com.model.Provinces;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProvinceService {
    Iterable<Provinces> findAll();

    Optional<Provinces> findById(Long id);

    void save(Provinces provinces);

    void remove(Long id);
}
