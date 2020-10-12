package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DonationRepository donationRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homeAction(Model model) {

        List<Institution> institutions = institutionRepository.findAll();
        model.addAttribute("institutions", institutions);

        Integer bagsQuantity = donationRepository.findSumOfBags();
        model.addAttribute("bagsQuantity", bagsQuantity);

        Integer donationsQuantity = donationRepository.findSumOfDonation();
        model.addAttribute("donationsQuantity", donationsQuantity );
        return "index";


    }
}
