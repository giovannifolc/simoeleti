package it.matrimonio.simoeleti;

import it.matrimonio.simoeleti.repositories.RSVPRepository;
import it.matrimonio.simoeleti.services.MainServiceImpl;
import it.matrimonio.simoeleti.services.NotificationService;
import it.matrimonio.simoeleti.services.NotificationServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SimoeletiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimoeletiApplication.class, args);
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    MainServiceImpl mainService() {return new MainServiceImpl();}

    @Bean
    NotificationServiceImpl notificationService() {return new NotificationServiceImpl();}
}
