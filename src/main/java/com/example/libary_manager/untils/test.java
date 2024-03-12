package com.example.libary_manager.untils;

import java.time.LocalDateTime;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        LocalDateTime y = LocalDateTime.now();
        Date x = Date.from(y.atZone(java.time.ZoneId.systemDefault()).toInstant());

        System.out.println(x);
    }
}
