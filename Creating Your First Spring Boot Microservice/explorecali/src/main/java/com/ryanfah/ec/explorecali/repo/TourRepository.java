package com.ryanfah.ec.explorecali.repo;

import com.ryanfah.ec.explorecali.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/*
URL sort codes:
size - num of elements, defaults 20
page - which page, defaults 0
sort - category, type (asc or desc), defaults by id
.../tours?size=3&page=1&sort=title,asc
(by method) .../tours/search/findByTourPackageCode?code=CC&size=2&sort=title,asc
 */

public interface TourRepository extends PagingAndSortingRepository<Tour, String> {
    //List<Tour> findByTourPackageCode(String code);
    //Page<Tour> findByTourPackageCode(String code, Pageable pageable); --Makes method pageable
    @Query(value= "{'tourPackageCode' : 70 }", fields = "{ 'id':1, 'title':1, 'tourPackageCode':1, 'tourPackageName':1}")
    Page<Tour> findSummaryByTourPackageCode(@Param("code")String code, Pageable pageable);


    @Override
    @RestResource(exported = false)
    <S extends Tour> S save(S s);

    @Override
    @RestResource(exported = false)
    <S extends Tour> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    @RestResource(exported = false)
    void deleteById(String String);

    @Override
    @RestResource(exported = false)
    void delete(Tour tour);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Tour> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
