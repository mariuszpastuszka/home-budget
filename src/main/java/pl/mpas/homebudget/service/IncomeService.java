package pl.mpas.homebudget.service;

import pl.mpas.homebudget.domain.Income;

import java.util.List;

public interface IncomeService {
    List<Income> readAllIncomes();
}
