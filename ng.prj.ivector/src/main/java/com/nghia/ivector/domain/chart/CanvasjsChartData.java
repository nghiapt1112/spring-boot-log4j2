package com.nghia.ivector.domain.chart;

import java.util.ArrayList;
import java.util.List;

public class CanvasjsChartData {

    static List<DataChart> dataCharts = new ArrayList<>(10);

    static {
        dataCharts.add(DataChart.builder().x(1167589800000L).y(188).build());

        dataCharts.add(DataChart.builder().x(1199125800000L).y(213).build());

        dataCharts.add(DataChart.builder().x(1230748200000L).y(213).build());

        dataCharts.add(DataChart.builder().x(1262284200000L).y(219).build());

        dataCharts.add(DataChart.builder().x(1293820200000L).y(207).build());

        dataCharts.add(DataChart.builder().x(1325356200000L).y(167).build());

        dataCharts.add(DataChart.builder().x(1356978600000L).y(136).build());

        dataCharts.add(DataChart.builder().x(1388514600000L).y(152).build());

        dataCharts.add(DataChart.builder().x(1420050600000L).y(129).build());

        dataCharts.add(DataChart.builder().x(1451586600000L).y(155).build());

    }

    public static List<DataChart> getCanvasjsDataList() {
        return dataCharts;
    }
}                        