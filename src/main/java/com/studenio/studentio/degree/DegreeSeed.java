package com.studenio.studentio.degree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DegreeSeed implements CommandLineRunner {

    @Autowired
    private DegreeRepository degreeRepository;

    @Override
    public void run(String... args) {
        Degree degree1 = new Degree();
        degree1.setName("Bachelor");
        degree1.setLevel("Undergraduate");

        Degree degree2 = new Degree();
        degree2.setName("Master");
        degree2.setLevel("Graduate");

        degreeRepository.save(degree1);
        degreeRepository.save(degree2);
    }
}
