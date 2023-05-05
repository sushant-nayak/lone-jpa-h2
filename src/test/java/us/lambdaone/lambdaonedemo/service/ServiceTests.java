package us.lambdaone.lambdaonedemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import us.lambdaone.lambdaonedemo.model.Student;
import us.lambdaone.lambdaonedemo.repository.StudentRepository;
@ExtendWith(MockitoExtension.class)
public class ServiceTests {
    @InjectMocks
    StudentService service;

    @Mock
    StudentRepository dao;

    @Test
    public void testFindAllEmployees()
    {
        List<Student> list = new ArrayList<Student>();
        Student empOne = new Student(1, "John", 44, "John@yahoo.co.in");
        Student empTwo = new Student(2, "Alex", 29, "Alex@yahoo.co.in");
        Student empThree = new Student(3, "Steve", 38, "Steve@yahoo.co.in");

        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);

        when(dao.findAll()).thenReturn(list);

        //test
        List<Student> empList = service.getAllStudent();

        assertEquals(3, empList.size());
        verify(dao, times(1)).findAll();
    }

    @Test
    public void testCreateOrSaveEmployee()
    {
        Student student = new Student(3, "Ravi", 44, "Swarit@yahoo.co.in");

        service.saveOrUpdate(student);

        verify(dao, times(1)).save(student);
    }

}
