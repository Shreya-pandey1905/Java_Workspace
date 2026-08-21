package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class IdempotencyService {

    private final Map<String, Long> processedRequests= new ConcurrentHashMap<>();

    public boolean isProcessed(String key){
        return processedRequests.containsKey(key);
    }

    public Long getFlightsId(String key){
        return processedRequests.get(key);
    }

    public void save(String key, Long productId){
        processedRequests.put(key, productId);
    }
}
