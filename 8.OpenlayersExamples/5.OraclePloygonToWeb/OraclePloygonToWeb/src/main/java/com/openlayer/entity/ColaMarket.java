package com.openlayer.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ColaMarket {

    private int mk_id;
    private String name;
    private List<List<Double>> lonlatList;

    public ColaMarket() {
    }

    public ColaMarket(int mk_id, String name, List<List<Double>> lonlatList) {
        this.mk_id = mk_id;
        this.name = name;
        this.lonlatList = lonlatList;
    }

    public int getMk_id() {
        return mk_id;
    }

    public void setMk_id(int mk_id) {
        this.mk_id = mk_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<Double>> getLonlatList() {
        return lonlatList;
    }

    public void setLonlatList(List<List<Double>> lonlatList) {
        this.lonlatList = lonlatList;
    }

    @Override
    public String toString() {
        return "ColaMarket{" +
                "mk_id=" + mk_id +
                ", name='" + name + '\'' +
                ", lonlatList=" + lonlatList +
                '}';
    }
}
