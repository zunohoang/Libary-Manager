package com.example.libary_manager.services;

import com.example.libary_manager.models.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheLengthTableService {
    private Map<Integer, Integer> cache = new HashMap<>();

    public Integer getCache(int libaryId){
        return cache.get(libaryId);
    }

    public void createCache(int libaryId, int lengthTable){
        cache.put(libaryId, lengthTable);
    }
}
