package com.darian.springbootcacheredis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CacheController {
    private final CacheManager simpleCacheManager;

    @GetMapping("/save")
    public Object save(@RequestParam String key, @RequestParam String value) {
        Cache cache = simpleCacheManager.getCache("cache-1");
        cache.put(key, value);

        Map<String, Object> result = new HashMap<>();
        result.put(key, value);
        return result;
    }


}
