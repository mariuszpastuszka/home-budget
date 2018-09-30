package pl.mpas.homebudget.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mpas.homebudget.domain.Expense;
import pl.mpas.homebudget.service.ChartsService;
import pl.mpas.homebudget.service.ExpenseService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ChartsServiceImpl implements ChartsService {

    private static final Logger logger = LoggerFactory.getLogger(ChartsServiceImpl.class);

    private ExpenseService expenseService;

    @Autowired
    public ChartsServiceImpl(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public Map<String, BigDecimal> readCategoriesOverAmounts() {
        List<Expense> allExpenses = expenseService.readAllExpenses();



        return Collections.emptyMap();
    }
}
