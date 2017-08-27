package com.netease.assignment.dao;

import com.github.abel533.mapper.Mapper;
import com.netease.assignment.domain.ChartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChartDao extends Mapper<ChartItem> {

    void addChartItem(ChartItem chart);

    List<ChartItem> getChartItems(Integer userId);

    void deleteChartItem(Integer itemId);

    void updateChartItem(ChartItem chartItem);
}
