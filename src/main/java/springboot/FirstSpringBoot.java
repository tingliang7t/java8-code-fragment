package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class FirstSpringBoot {

    @GetMapping("/")
    public String home(){
        return "hello world";
    }

    public static void main(String[] args){
        SpringApplication.run(FirstSpringBoot.class, args);
    }
}
