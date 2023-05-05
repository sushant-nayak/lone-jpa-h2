package us.lambdaone.lambdaonedemo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import us.lambdaone.lambdaonedemo.controller.StudentController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class LambdaoneDemoApplicationTests {

    @Autowired
    LambdaoneDemoApplication lambdaoneDemoApplication;
    @Test
    void contextLoads() {
        Assertions.assertThat(lambdaoneDemoApplication).isNot(null);
    }

}
