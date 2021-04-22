package com.ryanfah.ec.explorecali.repo;

import com.ryanfah.ec.explorecali.domain.Tour;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour, Integer> {
    List<Tour> findByTourPackageCode(String code);
}
