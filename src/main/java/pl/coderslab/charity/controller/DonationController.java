package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.time.LocalDate;
import java.util.List;

@Controller
public class DonationController {

    @Autowired
    DonationRepository donationRepository;

    @Autowired
    InstitutionRepository institutionRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(path = "/donation", method = RequestMethod.GET)
    public String addDonationForm(Model model){
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        model.addAttribute("donation", new Donation());

        List<Institution> institutions = institutionRepository.findAll();
        model.addAttribute("institutions", institutions);
        return "form";
    }

    @RequestMapping(path = "/donation", method = RequestMethod.POST)
    public String saveDonation(@ModelAttribute("donation") Donation donation){

        donationRepository.save(donation);
        return "redirect:/";
    }

}
