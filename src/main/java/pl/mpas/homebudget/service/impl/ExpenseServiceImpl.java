package pl.mpas.homebudget.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mpas.homebudget.dao.ExpenseRepository;
import pl.mpas.homebudget.domain.Expense;
import pl.mpas.homebudget.domain.ExpenseCategory;
import pl.mpas.homebudget.domain.PaymentMethod;
import pl.mpas.homebudget.service.ExpenseService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseServiceImpl.class);

    private ExpenseRepository expenseDao;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseDao) {
        this.expenseDao = expenseDao;
    }

    @Override
    public List<Expense> readAllExpenses() {
        logger.info("readAllExpenses()");
//        Iterable<Expense> expenses = expenseDao.findAll();
//        return (List<Expense>) expenses;
        // FIXME - remove this test source
        ExpenseCategory category = new ExpenseCategory(LocalDateTime.now(), "Biedronka", false);
        List<Expense> testList = new ArrayList<>();
        testList.add(new Expense("Skarpetki", PaymentMethod.CASH, "Rzeszów", BigDecimal.ONE, category, LocalDate.now(),
                LocalDateTime.now(), false));
        testList.add(new Expense("Bluza", PaymentMethod.CREDIT, "Rzeszów", BigDecimal.valueOf(100_000), category, LocalDate.now(),
                LocalDateTime.now(), false));
        return testList;
    }
}
