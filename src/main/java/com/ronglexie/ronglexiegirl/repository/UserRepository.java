package com.ronglexie.ronglexiegirl.repository;

import com.ronglexie.ronglexiegirl.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ronglexie
 * @version 2018-2-8
 */
@CacheConfig(cacheNames = "Users")
public interface UserRepository extends JpaRepository<User,Integer>{
	@Cacheable
	User findByUsername(String username);
}
