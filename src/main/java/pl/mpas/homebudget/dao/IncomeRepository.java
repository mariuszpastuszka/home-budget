package pl.mpas.homebudget.dao;

import org.springframework.data.repository.CrudRepository;
import pl.mpas.homebudget.domain.Income;

public interface IncomeRepository extends CrudRepository<Income, Long> {
}
