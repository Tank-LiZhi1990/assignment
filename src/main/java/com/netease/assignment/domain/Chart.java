package com.netease.assignment.domain;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Chart {

    private Map<Integer, ChartItem> chartItems;

    public Chart() {

        chartItems = new HashMap<>();
    }

    public void addChartItem(ChartItem chartItem) {

        chartItems.put(chartItem.getItemId(), chartItem);
    }

    public ChartItem getChartItem(Integer itemId) {

        return chartItems.get(itemId);
    }

    public void deleteChartItem(Integer itemId) {

        chartItems.remove(itemId);
    }

    public void updateChartItem(ChartItem chartItem) {

        chartItems.put(chartItem.getItemId(), chartItem);
    }

    public void clearChart() {

        chartItems.clear();
    }

    public Map<Integer, ChartItem> getChartItems() {

        return chartItems;
    }

}
