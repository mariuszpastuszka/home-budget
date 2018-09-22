package pl.mpas.homebudget.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mpas.homebudget.controller.IncomeController;
import pl.mpas.homebudget.service.IncomeService;

@Controller
public class IncomeControllerImpl implements IncomeController {

    private static final Logger logger = LoggerFactory.getLogger(IncomeControllerImpl.class);

    private IncomeService incomeService;

    @Autowired
    public IncomeControllerImpl(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/incomes/all")
    @Override
    public String allIncomes(Model model) {

        logger.info("allIncomes()");

        model.addAttribute("incomes", incomeService.readAllIncomes());
        return "income/incomes-all";
    }

    @Override
    public String addIncome() {
        return null;
    }

    @Override
    public String editIncome() {
        return null;
    }

    @Override
    public String deleteIncome() {
        return null;
    }

    @Override
    public String saveIncome() {
        return null;
    }

    @Override
    public String incomeDeleteConfirmation() {
        return null;
    }
}
