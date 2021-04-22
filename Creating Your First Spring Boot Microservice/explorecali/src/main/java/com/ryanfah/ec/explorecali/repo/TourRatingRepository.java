package com.ryanfah.ec.explorecali.repo;

import com.ryanfah.ec.explorecali.domain.TourRating;
import com.ryanfah.ec.explorecali.domain.TourRatingPk;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {
    List<TourRating> findByPkTourId(Integer tourId);
    Optional<TourRating> findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);
    Page<TourRating> findByPkTourId(Integer tourId, Pageable pageable);
}
