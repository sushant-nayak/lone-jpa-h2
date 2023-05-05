package us.lambdaone.lambdaonedemo.integration;

import jakarta.validation.ValidationException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import us.lambdaone.lambdaonedemo.controller.StudentController;
import us.lambdaone.lambdaonedemo.model.Student;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IntegrationTests {
    @Autowired
    StudentController controller;

    @Test
    public void testCreateReadDelete() {
        Student student = new Student(3, "Steve", 38, "Steve@yahoo.co.in");

        int studentResult = controller.saveStudent(student);

        Iterable<Student> employees = controller.getAllStudent();
        Assertions.assertThat(employees).first().hasFieldOrPropertyWithValue("name", "Steve");

        controller.deleteStudent(studentResult);
        Assertions.assertThat(controller.getAllStudent()).isEmpty();
    }

//    @Test
//    public void errorHandlingValidationExceptionThrown() {
//
//        Assertions.assertThatExceptionOfType(ValidationException.class)
//                .isThrownBy(() -> controller.somethingIsWrong());
//    }
}
