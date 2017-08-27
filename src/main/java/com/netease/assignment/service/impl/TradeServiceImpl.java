package com.netease.assignment.service.impl;

import com.netease.assignment.dao.ITradeDao;
import com.netease.assignment.domain.TradeItem;
import com.netease.assignment.service.TradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("tradeService")
public class TradeServiceImpl implements TradeService {

	@Resource
	private ITradeDao tradeDao;

	@Override
	public List<TradeItem> getTrades(Integer userId) {

		return tradeDao.getTrades(userId);
	}

	@Override
	public void addTradeItems(List<TradeItem> trades) {

		tradeDao.addTradeItems(trades);
	}

	@Override
	public TradeItem getTrade(Integer userId, Integer itemId) {

		return tradeDao.getTrade(userId, itemId);
	}

}
