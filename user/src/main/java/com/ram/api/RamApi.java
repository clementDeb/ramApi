package com.ram.api;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.ram.api.persistance")
@EnableJpaRepositories("com.ram.api.repositories")
@ComponentScan("com.ram.api")
@EnableCaching
public class RamApi
{
    public static void main( String[] args )
    {
    	SpringApplication.run(RamApi.class, args);
    }
    
    @Bean
    public CacheManager cacheManager() {
    	ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("user");
        return cacheManager;
    }
    
}
