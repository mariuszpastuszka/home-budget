package pl.mpas.homebudget.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mpas.homebudget.dao.ExpenseCategoryRepository;
import pl.mpas.homebudget.domain.ExpenseCategory;
import pl.mpas.homebudget.service.ExpenseCategoryService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseCategoryServiceImpl.class);

    private ExpenseCategoryRepository dataRepository;

    @Autowired
    public ExpenseCategoryServiceImpl(ExpenseCategoryRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public List<ExpenseCategory> readAllExpenseCategories() {

        // TODO:MP fix casting
        List<ExpenseCategory> result = (List<ExpenseCategory>) dataRepository.findAll();

        logger.info("Expense categories read from dao: {}", result);
        return result;
    }

    @Override
    public boolean saveCategory(ExpenseCategory expenseCategory) {
        ExpenseCategory savedCategory = dataRepository.save(expenseCategory);
        return null != savedCategory.getId();
    }

    @Override
    public Optional<ExpenseCategory> findCategoryById(Long id) {
        return dataRepository.findById(id);
    }

    @Override
    public void deleteCategoryById(Long id) {
        dataRepository.deleteById(id);
    }
}
