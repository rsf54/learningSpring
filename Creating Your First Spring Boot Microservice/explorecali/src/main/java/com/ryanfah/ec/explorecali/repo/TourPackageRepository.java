package com.ryanfah.ec.explorecali.repo;

import com.ryanfah.ec.explorecali.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    /*
    Signature<return type> findBy"EntityAttributeName(camelcase)"(Parameter w/ Datatype of EAN)
    Valid Signatures == List, Optional, Collection
    Queries can have intermediate syntax
    Examples:
    List<Tour> findByTourPackageCodeAndRegion(String code, Region region); returns Tour from given code and region
    List<Tour> findByRegionIn(List<Region> regions); returns Tours in region or many regions
    List<Tour> findByPriceLessThan(Integer maxPrice); returns Tours with a price less than maxPrice
    List<Tour> findByKeywordsContains(String keyword); returns Tours that have the specified keyword
    List<Tour> findByTourPackageCodeAndBulletsLike(String code, String searchString); returns Tours with the specified code and with the specified bullet
    List<Tour> findByTourPackageCodeAndDifficultyAndRegionAndPriceLessThan(String code, Difficulty difficulty, Region region, Integer maxPrice;
        Returns Tours based on Code, Difficulty, and Region all under maxPrice
    **SpringDataJPA has all combinations**

    @Query annotation:

    @Query("Select t from Tour t where t.tourPackage.code = ?1 and t.difficulty  ?2 and t.region = ?3 and t.price <= ?4")
    List<Tour> lookupTour(String code, Difficulty difficulty, Region region, Integer maxPrice)
     -- is the same as --
    List<Tour> findByTourPackageCodeAndDifficultyAndRegionAndPriceLessThan(String code, Difficulty difficulty, Region region, Integer maxPrice;
    */

    Optional<TourPackage> findByName(String name);
}
