package com.ryanfah.ec.explorecali.repo;

import com.ryanfah.ec.explorecali.domain.Tour;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<Tour, Integer> {
}
