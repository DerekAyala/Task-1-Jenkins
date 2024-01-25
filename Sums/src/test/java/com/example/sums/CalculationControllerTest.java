package com.example.sums;

import com.example.sums.controller.CalculationController;
import com.example.sums.model.Calculation;
import com.example.sums.repository.CalculationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class CalculationControllerTest {

    @Test
    public void testShowForm() {
        CalculationRepository calculationRepository = Mockito.mock(CalculationRepository.class);
        Mockito.when(calculationRepository.findAll()).thenReturn(Collections.emptyList());
        CalculationController controller = new CalculationController(calculationRepository);

        Model model = new ConcurrentModel();
        String viewName = controller.showForm(model);

        assertEquals("index", viewName);
        Calculation expected = new Calculation();
        Calculation actual = (Calculation) model.getAttribute("calculation");

        assertEquals(expected.getNum1(), actual.getNum1());
        assertEquals(expected.getNum2(), actual.getNum2());
        assertEquals(expected.getSum(), actual.getSum());

        assertEquals(Collections.emptyList(), model.getAttribute("allCalculations"));
    }

    @Test
    public void testSubmitForm() {
        CalculationRepository calculationRepository = Mockito.mock(CalculationRepository.class);
        Mockito.when(calculationRepository.save(any(Calculation.class))).thenAnswer(i -> i.getArguments()[0]);

        CalculationController controller = new CalculationController(calculationRepository);
        Calculation calculation = new Calculation();
        calculation.setNum1(2);
        calculation.setNum2(3);

        String viewName = controller.submitForm(calculation);
        assertEquals("redirect:/", viewName);
        assertEquals(5, calculation.getSum());
    }
}
