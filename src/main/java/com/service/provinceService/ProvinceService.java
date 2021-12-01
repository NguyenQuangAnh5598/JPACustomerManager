package com.service.provinceService;

import com.model.Provinces;
import com.repo.provinceRepo.IProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    IProvinceRepo provinceRepo;

    @Override
    public Iterable<Provinces> findAll() {
        return provinceRepo.findAll();
    }

    @Override
    public Optional<Provinces> findById(Long id) {
        return provinceRepo.findById(id);
    }

    @Override
    public void save(Provinces provinces) {
        provinceRepo.save(provinces);
    }

    @Override
    public void remove(Long id) {
        provinceRepo.deleteById(id);
    }
}
