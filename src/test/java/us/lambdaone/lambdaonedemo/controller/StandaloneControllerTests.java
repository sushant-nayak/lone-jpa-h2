package us.lambdaone.lambdaonedemo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import us.lambdaone.lambdaonedemo.model.Student;
import us.lambdaone.lambdaonedemo.service.StudentService;
import lombok.Builder;
@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
public class StandaloneControllerTests {

    @MockBean
    StudentService studentService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testfindAll() throws Exception {
        Student student = new Student(3, "Ravi", 44, "Swarit@yahoo.co.in");
        List<Student> students = Arrays.asList(student);

        Mockito.when(studentService.getAllStudent()).thenReturn(students);

        mockMvc.perform(get("/student"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Ravi")));
    }
}
