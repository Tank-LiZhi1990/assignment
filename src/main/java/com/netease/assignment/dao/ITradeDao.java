package com.netease.assignment.dao;

import com.netease.assignment.domain.TradeItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITradeDao {

    // 账务
    // 获取所有的交易记录
    List<TradeItem> getTrades(Integer userId);

    // 从购物车购买，转换为交易
    void addTradeItems(List<TradeItem> trades);

    TradeItem getTrade(Integer userId, Integer itemId);
}
