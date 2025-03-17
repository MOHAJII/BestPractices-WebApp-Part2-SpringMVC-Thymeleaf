package net.haji.springmvcthymeleaf.web;

import lombok.AllArgsConstructor;
import net.haji.springmvcthymeleaf.dao.entities.Patient;
import net.haji.springmvcthymeleaf.dao.repositories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller @AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patientsList", patients);
        return "patients";
    }
}
