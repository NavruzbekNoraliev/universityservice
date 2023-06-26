package com.studenio.studentio.degree;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DegreeEntityTest {
    @Autowired
    private DegreeRepository degreeRepository;

    @Test
    public void saveDegreeTest() {
        Degree degree = new Degree();
        degree.setName("Bachelor");
        degree.setLevel("Undergraduate");

        Degree savedDegree = degreeRepository.save(degree);

        assertThat(savedDegree.getId()).isNotNull();
        assertThat(savedDegree.getName()).isEqualTo("Bachelor");
        assertThat(savedDegree.getLevel()).isEqualTo("Undergraduate");
    }
}
