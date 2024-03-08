package com.example.libary_manager.services;

import com.example.libary_manager.models.Book;
import com.example.libary_manager.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheBookSevice {
    private Map<Integer, List<Book>> cache = new HashMap<>();

    public List<Book> getCache(int libaryId){
        return cache.get(libaryId);
    }

    public void createCache(int libaryId, List<Book> books){
        cache.put(libaryId, books);
    }

    public void addCache(int libaryId, Book book){
        List<Book> books = new ArrayList<Book>();
        books = cache.get(libaryId);

        if(books.size() > 10){
            books.remove(books.size() - 1);
        }
        books.add(0, book);

        cache.put(libaryId, books);
    }
}
