package org.gruppe3nskeskyfullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Gruppe3NskeskyFullstackApplication {

    public static void main(String[] args) {
        System.out.println(System.getenv("DB_URL"));
        SpringApplication.run(Gruppe3NskeskyFullstackApplication.class, args);
    }

}
