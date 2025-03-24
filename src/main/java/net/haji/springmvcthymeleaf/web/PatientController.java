package net.haji.springmvcthymeleaf.web;

import lombok.AllArgsConstructor;
import net.haji.springmvcthymeleaf.dao.entities.Patient;
import net.haji.springmvcthymeleaf.dao.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "4") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword
                        ) {
        Page<Patient> pagePatients = patientRepository.findByNameContainsIgnoreCase(keyword, PageRequest.of(page, size));
        model.addAttribute("patientsList", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "size", defaultValue = "4") int size,
                         @RequestParam(name = "keyword", defaultValue = "") String keyword) {
       patientRepository.deleteById(id);
       return "redirect:/index?page="+page+"&size="+size+"&keyword="+keyword;
    }

    @GetMapping("/formPatients")
    public String formPatients(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }

    @PostMapping("/save")
    public String save(Model model, Patient patient) {
        patientRepository.save(patient);
        System.out.println(patient);
        return "formPatients";
    }
}
