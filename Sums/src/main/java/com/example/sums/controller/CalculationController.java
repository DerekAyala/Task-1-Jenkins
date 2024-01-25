package com.example.sums.controller;

import com.example.sums.model.Calculation;
import com.example.sums.repository.CalculationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalculationController {

    private final CalculationRepository calculationRepository;

    public CalculationController(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("calculation", new Calculation());
        model.addAttribute("allCalculations", calculationRepository.findAll());
        return "index";
    }

    @PostMapping("/")
    public String submitForm(Calculation calculation) {
        calculation.setSum(calculation.getNum1() + calculation.getNum2());
        calculationRepository.save(calculation);
        return "redirect:/";
    }
}
