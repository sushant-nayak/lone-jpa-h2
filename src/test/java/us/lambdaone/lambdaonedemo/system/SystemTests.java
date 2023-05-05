package us.lambdaone.lambdaonedemo.system;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import us.lambdaone.lambdaonedemo.model.Student;
public class SystemTests {
    @Test
    public void testCreateReadDelete() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/student";

        Student student = new Student(3, "Steve", 38, "Steve@yahoo.co.in");
        Student entity = restTemplate.postForObject(url, student, Student.class);

        Student[] students = restTemplate.getForObject(url, Student[].class);
        Assertions.assertThat(students).extracting(Student::getName).containsOnly("Steve");

        restTemplate.delete(url + "/" + entity.getId());
        Assertions.assertThat(restTemplate.getForObject(url, Student[].class)).isEmpty();
    }

    @Test
    public void testErrorHandlingReturnsBadRequest() {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/wrong";

        try {
            restTemplate.getForEntity(url, String.class);
        } catch (HttpClientErrorException e) {
            Assertions.assertThat(e.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        }
    }
}
