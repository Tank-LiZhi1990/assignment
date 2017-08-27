package com.netease.assignment.service;

import com.netease.assignment.domain.ChartItem;

import java.util.Map;

public interface ChartService {

    void addChartItem(ChartItem chart);

    Map<Integer, ChartItem> getChartItems(Integer userId);

    void clearChart(Integer userId);

    void updateChartItem(ChartItem chart);

    void buyAll(Integer userId);
}
