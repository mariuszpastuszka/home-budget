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

        // TODO:MP replace with dataRepository
        List<ExpenseCategory> result = new ArrayList<>();
        result.add(new ExpenseCategory(LocalDateTime.now(), "Słodycze", false));
        result.add(new ExpenseCategory(LocalDateTime.now(), "Biedronka", false));

        logger.info("Expense categories read from dao: {}", result);
        return result;
    }
}
