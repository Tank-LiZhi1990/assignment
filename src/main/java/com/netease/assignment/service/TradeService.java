package com.netease.assignment.service;

import com.netease.assignment.domain.TradeItem;

import java.util.List;

public interface TradeService {

    List<TradeItem> getTrades(Integer userId);

    void addTradeItems(List<TradeItem> trades);

    TradeItem getTrade(Integer userId, Integer itemId);
}
