package pl.mpas.homebudget.controller;

import pl.mpas.homebudget.domain.ExpenseCategory;

public interface ExpenseController {

    String allExpenses();

    String showExpensesFromCategory(ExpenseCategory category);

//    String showExpensesUnderConditions(...);
}
