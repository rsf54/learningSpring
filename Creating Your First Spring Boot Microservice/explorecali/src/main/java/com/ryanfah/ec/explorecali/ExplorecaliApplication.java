package com.ryanfah.ec.explorecali;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanfah.ec.explorecali.service.TourPackageService;
import com.ryanfah.ec.explorecali.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

@SpringBootApplication
public class ExplorecaliApplication implements CommandLineRunner {

    @Autowired
    private TourPackageService tourPackageService;

    @Autowired
    private TourService tourService;

    public static void main(String[] args) {
        SpringApplication.run(ExplorecaliApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createTourPackages();
        long numOfPackages = tourPackageService.total();

        createTours("ExploreCalifornia.json");
        long numOfTours = tourService.total();
    }

    private void createTourPackages(){
        tourPackageService.createTourPackage("BC", "Backpack Cal");
        tourPackageService.createTourPackage("CC", "California Calm");
        tourPackageService.createTourPackage("CH", "California Hot springs");
        tourPackageService.createTourPackage("CY", "Cycle California");
        tourPackageService.createTourPackage("DS", "From Desert to Sea");
        tourPackageService.createTourPackage("KC", "Kids California");
        tourPackageService.createTourPackage("NW", "Nature Watch");
        tourPackageService.createTourPackage("SC", "Snowboard Cali");
        tourPackageService.createTourPackage("TC", "Taste of California");
    }

    private void createTours(String fileToImport) throws IOException {
        TourFromFile.read(fileToImport).forEach(tourFromFile -> tourService.createTour(tourFromFile.getTitle(),tourFromFile.getPackageName(),tourFromFile.getDetails()));
    }

    private static class TourFromFile {
        String title;
        String packageName;
        Map<String, String> details;

        TourFromFile(Map<String, String> record){
            this.title = record.get("title");
            this.packageName = record.get("packageType");
            this.details = record;
            this.details.remove("title");
            this.details.remove("packageType");
        }
        static List<TourFromFile> read(String fileToImport) throws IOException {
            List<Map<String,String>> records = new ObjectMapper().setVisibility(FIELD, ANY).readValue(new FileInputStream(fileToImport), new TypeReference<List<Map<String, String>>>() {});
            return records.stream().map(TourFromFile::new).collect(Collectors.toList());
        }
        protected TourFromFile(){}


        String getTitle() { return title; }

        String getPackageName(){
            return packageName;
        }

        public Map<String, String> getDetails() {
            return details;
        }
    }


}
