package com.example.productcatalog1throughVersion.service;

import org.springframework.stereotype.Service;
import tools.jackson.databind.node.StringNode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class IdempotencyService {

    private final Map<String, Long> processedRequests= new ConcurrentHashMap<>();

    public boolean isProcessed(String key){
        return processedRequests.containsKey(key);
    }

    public Long getProductsId(String key){
        return processedRequests.get(key);
    }

    public void save(String key, Long productId){
        processedRequests.put(key, productId);
    }
}
