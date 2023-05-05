package us.lambdaone.lambdaonedemo.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import us.lambdaone.lambdaonedemo.model.Student;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTests {
    @Autowired
    StudentRepository repository;

    @Test
    public void testCreateReadDelete() {
        Student student = new Student(3, "Steve", 68, "Steve@yahoo.co.in");

        repository.save(student);

        Iterable<Student> students = repository.findAll();
        Assertions.assertThat(students).extracting(Student::getName).containsOnly("Steve");

        repository.deleteAll();
        Assertions.assertThat(repository.findAll()).isEmpty();
    }
}
