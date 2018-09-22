package pl.mpas.homebudget.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.mpas.homebudget.domain.Income;
import pl.mpas.homebudget.service.IncomeService;

import java.util.Collections;
import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {

    private static final Logger logger = LoggerFactory.getLogger(IncomeServiceImpl.class);

    @Override
    public List<Income> readAllIncomes() {
        return Collections.emptyList();
    }
}
