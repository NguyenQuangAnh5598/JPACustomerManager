package com.repo.provinceRepo;

import com.model.Provinces;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepo extends PagingAndSortingRepository<Provinces,Long> {
}
