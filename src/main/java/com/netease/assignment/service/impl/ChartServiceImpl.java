package com.netease.assignment.service.impl;

import com.netease.assignment.dao.IChartDao;
import com.netease.assignment.dao.ITradeDao;
import com.netease.assignment.domain.Chart;
import com.netease.assignment.domain.ChartItem;
import com.netease.assignment.domain.TradeItem;
import com.netease.assignment.service.ChartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * @author Tank 需要同步chart
 */
@Service("chartService")
public class ChartServiceImpl implements ChartService {

	@Resource
	private IChartDao chartDao;

	@Resource
	private ITradeDao tradeDao;

	@Resource
	private Chart chart;

	@Override
	public void addChartItem(ChartItem chartItem) {

		chartDao.addChartItem(chartItem);
		chart.addChartItem(chartItem);
	}

	@Override
	public Map<Integer, ChartItem> getChartItems(Integer userId) {

		if (chart.getChartItems().size() == 0) {
			List<ChartItem> list = chartDao.getChartItems(userId);
			for (ChartItem chartItem : list) {
				chart.addChartItem(chartItem);
			}
		}

		return chart.getChartItems();
	}

	@Override
	public void clearChart(Integer userId) {

		Iterator<ChartItem> it = chart.getChartItems().values().iterator();
		ChartItem chartItem;
		// 从数据库清空
		while (it.hasNext()) {
			chartItem = it.next();
			chartDao.deleteChartItem(chartItem.getItemId());
		}
		// 从购物车清空
		chart.clearChart();
	}

	@Override
	public void updateChartItem(ChartItem chartItem) {

		chartDao.updateChartItem(chartItem);
		chart.updateChartItem(chartItem);
	}

	@Transactional(propagation = Propagation.REQUIRED,
			isolation = Isolation.DEFAULT)
	@Override
	public void buyAll(Integer userId) {

		// 购物车为空
		if (chart.getChartItems().size() == 0) {
			return;
		}

		// 添加物品到trade
		List<TradeItem> tis = new ArrayList<>();
		// 下单时间
		String dateTime =
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		TradeItem ti;
		for (ChartItem chartItem : chart.getChartItems().values()) {
			ti = new TradeItem();
			ti.setUserId(userId);
			ti.setItemId(chartItem.getItemId());
			ti.setPrice(chartItem.getPrice());
			ti.setCount(chartItem.getCount());
			ti.setTime(dateTime);

			tis.add(ti);
		}

		// 添加到交易历史数据库中
		tradeDao.addTradeItems(tis);

		// 从购物车中删除
		clearChart(userId);

	}

}
