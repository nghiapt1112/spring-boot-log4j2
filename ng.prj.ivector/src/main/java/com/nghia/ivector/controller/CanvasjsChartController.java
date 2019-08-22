package com.nghia.ivector.controller;

import com.nghia.ivector.domain.chart.CanvasjsChartData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/canvasjschart")
public class CanvasjsChartController {

    @GetMapping
    public String springMVC(Model modelMap) {
        modelMap.addAttribute("dataPointsList", CanvasjsChartData.getCanvasjsDataList());
        return "chart";
    }

}          