package net.haji.springmvcthymeleaf;

import net.haji.springmvcthymeleaf.dao.entities.Patient;
import net.haji.springmvcthymeleaf.dao.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMvcThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcThymeleafApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(Patient.builder().nom("Ahmad").malade(false).score(20).build());
            patientRepository.save(Patient.builder().nom("Mohammed").malade(false).score(20).build());
            patientRepository.save(Patient.builder().nom("Hamid").malade(true).score(20).build());
            patientRepository.save(Patient.builder().nom("Moustafa").malade(true).score(20).build());
            patientRepository.save(Patient.builder().nom("Yasser").malade(true).score(20).build());
            patientRepository.save(Patient.builder().nom("Omar").malade(false).score(20).build());
            patientRepository.save(Patient.builder().nom("Zakaria").malade(false).score(20).build());
            patientRepository.save(Patient.builder().nom("Mourad").malade(false).score(20).build());

            patientRepository.findAll().forEach(System.out::println);
        };
    }
}
