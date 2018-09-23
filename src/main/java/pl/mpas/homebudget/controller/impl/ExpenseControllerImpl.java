package pl.mpas.homebudget.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mpas.homebudget.controller.ExpenseController;
import pl.mpas.homebudget.service.ExpenseService;

@Controller
public class ExpenseControllerImpl implements ExpenseController {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseControllerImpl.class);

    private ExpenseService expenseService;

    @Autowired
    public ExpenseControllerImpl(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expense/all")
    @Override
    public String showAllExpenses(Model model) {

        logger.info("showAllExpenses()");
        model.addAttribute("expenses", expenseService.readAllExpenses());
        return "expense/expenses-all";
    }
}
