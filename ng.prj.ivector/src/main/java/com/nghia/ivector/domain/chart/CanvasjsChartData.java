package com.nghia.ivector.domain.chart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanvasjsChartData {

//    static Map<Object, Object> map = null;
//    static List<List<Map<Object, Object>>> list = new ArrayList<List<Map<Object, Object>>>();
//    static List<Map<Object, Object>> dataPoints1 = new ArrayList<Map<Object, Object>>();
    static List<DataChart> dataCharts = new ArrayList<>(10);
    static {
//        map = new HashMap<Object, Object>();
//        map.put("x", 1167589800000L);
//        map.put("y", 188);
//        dataPoints1.add(map);
        dataCharts.add(DataChart.builder().x(1167589800000L).y(188).build());
//        map = new HashMap<Object, Object>();
//        map.put("x", 1199125800000L);
//        map.put("y", 213);
//        dataPoints1.add(map);
        dataCharts.add(DataChart.builder().x(1199125800000L).y(213).build());

//        map = new HashMap<Object, Object>();
//        map.put("x", 1230748200000L);
//        map.put("y", 213);
//        dataPoints1.add(map);
        dataCharts.add(DataChart.builder().x(1230748200000L).y(213).build());
//        map = new HashMap<Object, Object>();
//        map.put("x", 1262284200000L);
//        map.put("y", 219);
//        dataPoints1.add(map);
dataCharts.add(DataChart.builder().x(1262284200000L).y(219).build());
//        map = new HashMap<Object, Object>();
//        map.put("x", 1293820200000L);
//        map.put("y", 207);
//        dataPoints1.add(map);
        dataCharts.add(DataChart.builder().x(1293820200000L).y(207).build());

//        map = new HashMap<Object, Object>();
//        map.put("x", 1325356200000L);
//        map.put("y", 167);
//        dataPoints1.add(map);
        dataCharts.add(DataChart.builder().x(1325356200000L).y(167).build());

//        map = new HashMap<Object, Object>();
//        map.put("x", 1356978600000L);
//        map.put("y", 136);
//        dataPoints1.add(map);
        dataCharts.add(DataChart.builder().x(1356978600000L).y(136).build());

//        map = new HashMap<Object, Object>();
//        map.put("x", 1388514600000L);
//        map.put("y", 152);
//        dataPoints1.add(map);
        dataCharts.add(DataChart.builder().x(1388514600000L).y(152).build());

//        map = new HashMap<Object, Object>();
//        map.put("x", 1420050600000L);
//        map.put("y", 129);
//        dataPoints1.add(map);
        dataCharts.add(DataChart.builder().x(1420050600000L).y(129).build());


//        map = new HashMap<Object, Object>();
//        map.put("x", 1451586600000L);
//        map.put("y", 155);
//        dataPoints1.add(map);
        dataCharts.add(DataChart.builder().x(1451586600000L).y(155).build());

//        list.add(dataPoints1);
    }

//    public static List<List<Map<Object, Object>>> getCanvasjsDataList() {
//        return list;
//    }

    public static List<DataChart> getCanvasjsDataList() {
        return dataCharts;
    }
}                        