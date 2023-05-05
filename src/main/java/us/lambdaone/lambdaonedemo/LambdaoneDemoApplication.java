package us.lambdaone.lambdaonedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@ComponentScan({"us.lambdaone.lambdaonedemo"})
@EntityScan("us.lambdaone.lambdaonedemo.model")
@EnableJpaRepositories("us.lambdaone.lambdaonedemo.repository")
public class LambdaoneDemoApplication {
    @GetMapping("/")
    public String callMe() {
        return "Working prototype...";
    }

    public static void main(String[] args) {
        SpringApplication.run(LambdaoneDemoApplication.class, args);
    }

}
