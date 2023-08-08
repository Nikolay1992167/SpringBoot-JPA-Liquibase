package by.digital.chief.musicHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MusicHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicHubApplication.class, args);
    }

}
