package com.netease.assignment.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "trade")
public class TradeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    // 物品
    private Integer itemId;
    private String itemTitle;
    private String imageLocation;
    private String locationType;

    // new DateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())

    // 购买时间
    private String time;
    // 购买时价格
    private double price;
    // 购买数量
    private int count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {

        return userId;
    }

    public void setUserId(Integer userId) {

        this.userId = userId;
    }

    public Integer getItemId() {

        return itemId;
    }

    public void setItemId(Integer itemId) {

        this.itemId = itemId;
    }

    public String getItemTitle() {

        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {

        this.itemTitle = itemTitle;
    }

    public String getImageLocation() {

        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {

        this.imageLocation = imageLocation;
    }

    public String getLocationType() {

        return locationType;
    }

    public void setLocationType(String locationType) {

        this.locationType = locationType;
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {

        this.time = time;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public int getCount() {

        return count;
    }

    public void setCount(int count) {

        this.count = count;
    }

}
