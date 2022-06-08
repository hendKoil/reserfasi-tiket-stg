//package com.challenge4.apichallenge4.Service.redisService;
//
//import com.challenge4.apichallenge4.Service.FilmService;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//
//@Service
//@CacheConfig(cacheNames = "filmCache")
//public class RedisService {
//
//    public FilmService filmService;
//
//    @Cacheable(cacheNames = "customers")
//    public filmSvc(){
//
//    }
//
//    private void waitSomeTime() {
//        System.out.println("Long Wait Begin");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Long Wait End");
//    }
//}
