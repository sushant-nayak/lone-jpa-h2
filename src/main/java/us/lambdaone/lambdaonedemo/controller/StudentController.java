package us.lambdaone.lambdaonedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;
import us.lambdaone.lambdaonedemo.model.Student;
import us.lambdaone.lambdaonedemo.service.StudentService;

import java.util.List;

@RestController
public class StudentController {
    //autowired the StudentService class
    @Autowired
    StudentService studentService;

    //creating a get mapping that retrieves all the students detail from the database
    @GetMapping("/student")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentService.delete(id);
    }

    //creating post mapping that post the student detail in the database
    @PostMapping("/student")
    public int saveStudent(@RequestBody Student student) {
        Student resp =studentService.saveOrUpdate(student);
        return resp.getId();
    }
}
