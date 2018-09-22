package pl.mpas.homebudget.controller;

import org.springframework.ui.Model;

public interface IncomeController {

    String allIncomes(Model model);

    String addIncome();

    String editIncome();

    String deleteIncome();

    String saveIncome();

    String incomeDeleteConfirmation();
}
