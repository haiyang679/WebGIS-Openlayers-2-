package com.openlayers.action.entity;

import org.springframework.stereotype.Repository;

@Repository
public class YuliangStatisticInfo {

    private String rank;
    private int count;

    public YuliangStatisticInfo() {
    }

    public YuliangStatisticInfo(String rank, int count) {
        this.rank = rank;
        this.count = count;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "YuliangStatisticInfo{" +
                "rank='" + rank + '\'' +
                ", count=" + count +
                '}';
    }
}
