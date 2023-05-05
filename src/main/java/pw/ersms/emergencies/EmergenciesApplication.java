package pw.ersms.emergencies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import pw.ersms.emergencies.classification.Classification;
import pw.ersms.emergencies.emergency.Emergency;

import java.time.LocalDateTime;

@SpringBootApplication
public class EmergenciesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmergenciesApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Emergency> kafkaTemplate) {
        return args -> {
            kafkaTemplate.send("emergencies", new Emergency(
                            1,
                            1,
                            "department",
                            new Classification(1, "classification", "description"),
                            1,
                            1,
                            LocalDateTime.now(),
                            LocalDateTime.now(),
                            "addressLine1",
                            "addressLine2",
                            "city",
                            "country",
                            "description",
                            1,
                            "captainFullName"
                    )
            );

        };
    }


}
