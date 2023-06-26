package com.studenio.studentio.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UniversitySeed  implements CommandLineRunner {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public void run(String... args) throws Exception {
        University university1 = new University();
        university1.setName("Inha University in Tashkent");
        university1.setEstablishedYear(2014);
        university1.setWebsite("www.inha.uz");
        Location location1 = new Location();
        location1.setCountry("Uzbekistan");
        location1.setCity("Tashkent");
        location1.setPostalCode("100170");
        location1.setStreetAddress("Ziyolilar 9A");
        university1.setLocation(location1);
//        University university2 = new University();
//        university2.setName("Master");

        universityRepository.save(university1);
//        universityService.createUniversity(university2);
    }
}
