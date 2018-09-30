package pl.mpas.homebudget.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mpas.homebudget.controller.ChartsController;
import pl.mpas.homebudget.service.ChartsService;

@Controller
public class ChartsControllerImpl implements ChartsController {

    private static final Logger logger = LoggerFactory.getLogger(ChartsControllerImpl.class);

    private ChartsService chartsService;

    @Autowired
    public ChartsControllerImpl(ChartsService chartsService) {
        this.chartsService = chartsService;
    }

    @GetMapping("/charts/category")
    @Override
    public String showCategoryChart(Model data) {
        logger.info("showCategoryChart()");
        data.addAttribute("data", chartsService.readCategoriesOverAmounts());

        return "charts/category-charts";
    }

    @Override
    public String showCategoryChartFromGivenPerion() {
        return "";
    }
}
