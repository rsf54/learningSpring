package com.ryanfah.ec.explorecali.repo;

import com.ryanfah.ec.explorecali.domain.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/*
URL sort codes:
size - num of elements, defaults 20
page - which page, defaults 0
sort - category, type (asc or desc), defaults by id
.../tours?size=3&page=1&sort=title,asc
(by method) .../tours/search/findByTourPackageCode?code=CC&size=2&sort=title,asc
 */

public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {
    List<Tour> findByTourPackageCode(String code);
    //Page<Tour> findByTourPackageCode(String code, Pageable pageable); --Makes method pageable
}
