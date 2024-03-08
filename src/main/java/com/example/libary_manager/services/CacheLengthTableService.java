package com.example.libary_manager.services;

import com.example.libary_manager.models.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheLengthTableService {

    private Map<String, Integer> cache = new HashMap<>();

    public Integer getCache(String nameTable){
        return cache.get(nameTable);
    }

    public void createCache(String nameTable, int lengthTable){
        cache.put(nameTable, lengthTable);
    }
}
