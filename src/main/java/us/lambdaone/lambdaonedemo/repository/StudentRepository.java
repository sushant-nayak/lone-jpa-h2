package us.lambdaone.lambdaonedemo.repository;

import org.springframework.data.repository.CrudRepository;
import us.lambdaone.lambdaonedemo.model.Student;


public interface StudentRepository extends CrudRepository<Student, Integer> {
}