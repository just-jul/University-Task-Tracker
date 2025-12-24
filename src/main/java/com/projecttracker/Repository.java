package com.projecttracker;

import java.util.ArrayList;

public class Repository<T> {
    private ArrayList<T> list;
    public Repository(){
        this.list = new ArrayList<>();
    }
    public ArrayList<T> getList(){
        return this.list;
    }

}
