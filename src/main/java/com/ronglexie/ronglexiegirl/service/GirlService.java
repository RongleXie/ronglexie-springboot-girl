package com.ronglexie.ronglexiegirl.service;

import com.ronglexie.ronglexiegirl.entity.Girl;
import com.ronglexie.ronglexiegirl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author ronglexie
 * @version 2018-1-14
 */
@Service
public class GirlService {

    @Autowired
    GirlRepository girlRepository;

    /**
     * 保存一条数据
     *
     * @param girl
     * @return com.ronglexie.ronglexiegirl.entity.Girl
     * @author wxt.xqr
     * @version 2018-1-14
     */
    @Transactional
    public Girl save(Girl girl){
        return girlRepository.save(girl);
    }
}
