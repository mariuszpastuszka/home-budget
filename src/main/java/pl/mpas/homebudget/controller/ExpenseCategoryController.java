package pl.mpas.homebudget.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.mpas.homebudget.domain.ExpenseCategory;

import java.util.Collections;
import java.util.List;

@Controller
public class ExpenseCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseCategoryController.class);

    @GetMapping("/category/all")
    public String allCategories(Model categories) {
        logger.info("allCategories()");

        List<ExpenseCategory> expenseCategories = Collections.emptyList();
        categories.addAttribute("categories", expenseCategories);

        return "category/categories-all";
    }

    @GetMapping("/category/add")
    public String addCategory(@ModelAttribute ExpenseCategory expenseCategory) {
        logger.info("addCategory()");
        // TODO:MP save category
        return "redirect:/category/all";
    }

}
