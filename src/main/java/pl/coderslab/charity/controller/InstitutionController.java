package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.services.InstitutionService;

import java.util.List;

@Controller
@RequestMapping("/adminPanel/institution")
public class InstitutionController {

    private InstitutionService institutionService;

    @Autowired
    public InstitutionController(InstitutionService institutionService){
        this.institutionService = institutionService;
    }

    @GetMapping
    public String displayInstitution() {

        return "admin_institution";
    }

    @ModelAttribute("institutions")
    public List<Institution> showAllInstitution(){
        return institutionService.findAllInstitution();
    }

    @GetMapping(path = "/add")
    public String addInstitution(Model model) {
        model.addAttribute("institution", new Institution());
        return "admin_institutionAddForm";
    }

    @PostMapping(path = "/save")
    public String updateInstitution(@ModelAttribute("institution") Institution institution) {
        institutionService.addInstitution(institution);
        return "redirect:/adminPanel/institution";
    }

    @GetMapping(path = "/edit/{id}")
    public String editInstitution(@PathVariable("id") Long id, Model model) {
        model.addAttribute("institution", institutionService.findInstitutionById(id));
        return "admin_institutionAddForm";
    }
    @GetMapping(path = "/delete/{id}")
    public String deleteInstitution(@ModelAttribute Institution institution) {
        institutionService.deleteInstitution(institution);
        return "redirect:/adminPanel/institution";
    }
}
