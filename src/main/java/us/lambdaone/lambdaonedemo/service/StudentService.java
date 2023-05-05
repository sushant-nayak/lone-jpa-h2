package us.lambdaone.lambdaonedemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.lambdaone.lambdaonedemo.model.Student;
import us.lambdaone.lambdaonedemo.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //getting all student records
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(student -> students.add(student));
        return students;
    }

    //getting a specific record
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public Student saveOrUpdate(Student student) {
        return studentRepository.save(student);
    }

    //deleting a specific record
    public void delete(int id) {
        studentRepository.deleteById(id);
    }
}
