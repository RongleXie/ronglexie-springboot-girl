package com.ronglexie.ronglexiegirl.service;

import com.ronglexie.ronglexiegirl.entity.Girl;
import com.ronglexie.ronglexiegirl.enums.MessageEnum;
import com.ronglexie.ronglexiegirl.exception.GirlException;
import com.ronglexie.ronglexiegirl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ronglexie
 * @version 2018-1-14
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GirlService {

    @Autowired
    GirlRepository girlRepository;

    public static final Integer ADULT_AGE = 18;

    /**
     * 保存一条数据
     *
     * @param girl
     * @return com.ronglexie.ronglexiegirl.entity.Girl
     * @author wxt.xqr
     * @version 2018-1-14
     */
    public Girl save(Girl girl){
        return girlRepository.save(girl);
    }

    /**
     * 查询人员年龄
     *
     * @param id
     * @return java.lang.Integer
     * @author wxt.xqr
     * @version 2018-1-17
     */
    public Integer getAge(Integer id) throws Exception {
        Integer age = girlRepository.findOne(id).getAge();
        if (age < ADULT_AGE){
            throw new GirlException(MessageEnum.NONAGE);
        }else {
            throw new GirlException(MessageEnum.ADULT);
        }
    }
}
