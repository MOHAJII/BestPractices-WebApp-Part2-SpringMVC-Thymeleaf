package net.haji.springmvcthymeleaf;

import net.haji.springmvcthymeleaf.dao.entities.Patient;
import net.haji.springmvcthymeleaf.dao.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringMvcThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcThymeleafApplication.class, args);
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(Patient.builder().name("Ahmad").sick(false).score(20).build());
            patientRepository.save(Patient.builder().name("Mohammed").sick(false).score(20).build());
            patientRepository.save(Patient.builder().name("Hamid").sick(true).score(20).build());
            patientRepository.save(Patient.builder().name("Moustafa").sick(true).score(20).build());
            patientRepository.save(Patient.builder().name("Yasser").sick(true).score(20).build());
            patientRepository.save(Patient.builder().name("Omar").sick(false).score(20).build());
            patientRepository.save(Patient.builder().name("Zakaria").sick(false).score(20).build());
            patientRepository.save(Patient.builder().name("Mourad").sick(false).score(20).build());

            patientRepository.findAll().forEach(System.out::println);

            System.out.println("**************************************\n\n\n");
            System.out.println("Testing the find by name contains : ");
            List<Patient> patients = patientRepository.findByNameContainsIgnoreCase("y");
            patients.forEach(System.out::println);
        };
    }
}
