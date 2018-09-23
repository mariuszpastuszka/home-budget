package pl.mpas.homebudget.dao;

import org.springframework.data.repository.CrudRepository;
import pl.mpas.homebudget.domain.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
}
