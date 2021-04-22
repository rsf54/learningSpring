package com.ryanfah.ec.explorecali.service;


import com.ryanfah.ec.explorecali.domain.Tour;
import com.ryanfah.ec.explorecali.domain.TourPackage;
import com.ryanfah.ec.explorecali.repo.TourPackageRepository;
import com.ryanfah.ec.explorecali.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String tourPackageName, Map<String, String> details){
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName).orElseThrow( () -> new RuntimeException("Tour package does not exist"));
        return tourRepository.save( new Tour(title, tourPackage, details));
    }

    public long total() { return tourRepository.count(); }
}
