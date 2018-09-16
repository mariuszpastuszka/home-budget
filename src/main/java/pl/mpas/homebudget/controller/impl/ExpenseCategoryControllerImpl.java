package pl.mpas.homebudget.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mpas.homebudget.controller.ExpenseCategoryController;
import pl.mpas.homebudget.domain.ExpenseCategory;
import pl.mpas.homebudget.service.ExpenseCategoryService;

import java.util.List;
import java.util.Optional;

@Controller
public class ExpenseCategoryControllerImpl implements ExpenseCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseCategoryControllerImpl.class);

    private ExpenseCategoryService categoryService;

    @Autowired
    public ExpenseCategoryControllerImpl(ExpenseCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/all")
    @Override
    public String allCategories(Model categories) {
        logger.info("allCategories()");

        List<ExpenseCategory> expenseCategories = categoryService.readAllExpenseCategories();
        categories.addAttribute("categories", expenseCategories);

        return "category/categories-all";
    }

    @PostMapping("/category/save")
    // TODO:MP deal with empty and duplicated values
    // add bean validation
    public String saveCategory(@ModelAttribute ExpenseCategory expenseCategory,
                               @RequestParam(name = "pressed-button") String pushedButton) {

        logger.info("saveCategory(), expenseCategory: {}, pushedButton: {}",
                expenseCategory, pushedButton);

        if ("save".equalsIgnoreCase(pushedButton)) {
            categoryService.saveCategory(expenseCategory);
        }

        return "redirect:/category/all";
    }

    @GetMapping("/category/add")
    @Override
    public String addCategory(Model category) {
        logger.info("addCategory()");

        category.addAttribute("operationTitle", "New");
        category.addAttribute("mainParagraph", "Add new");
        category.addAttribute("category", new ExpenseCategory());

        return "category/new-edit-category";
    }

    @GetMapping("/category/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model) {
        logger.info("editCategory(), id: {}", id);

        model.addAttribute("operationTitle", "Edit");
        model.addAttribute("mainParagraph", "Edit");

        Optional<ExpenseCategory> foundCategory = categoryService.findCategoryById(id);
        foundCategory.ifPresent(expenseCategory -> model.addAttribute("category", expenseCategory));

        return "category/new-edit-category";
    }

    @GetMapping("/category/delete-confirmation/{id}")
    public String deleteConfirmation(@PathVariable Long id, Model model) {
        logger.info("deleteConfirmation(), id: {}", id);

        Optional<ExpenseCategory> categoryToAsk = categoryService.findCategoryById(id);
        categoryToAsk.ifPresent(expenseCategory -> model.addAttribute("categoryToAsk", expenseCategory));

        return "category/delete-confirmation";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        logger.info("deleteCategory(), id: {}", id);

        categoryService.deleteCategoryById(id);

        return "redirect:/category/all";
    }

}
