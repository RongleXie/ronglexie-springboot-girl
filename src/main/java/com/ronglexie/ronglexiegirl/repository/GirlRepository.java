package com.ronglexie.ronglexiegirl.repository;

import com.ronglexie.ronglexiegirl.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ronglexie
 * @version 2018-1-14
 */
public interface GirlRepository  extends JpaRepository<Girl,Integer>{

    /**
     * 根据年龄查询
     *
     * @param age
     * @return java.util.List<com.ronglexie.ronglexiegirl.entity.Girl>
     * @author wxt.xqr
     * @version 2018-1-14
     */
    List<Girl> findByAge(Integer age);
}
