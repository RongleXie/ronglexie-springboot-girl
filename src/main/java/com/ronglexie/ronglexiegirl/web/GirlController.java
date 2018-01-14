package com.ronglexie.ronglexiegirl.web;

import com.ronglexie.ronglexiegirl.entity.Girl;
import com.ronglexie.ronglexiegirl.properties.GirlProperties;
import com.ronglexie.ronglexiegirl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ronglexie
 * @version 2018-1-14
 */
@RestController
@RequestMapping("girl")
public class GirlController {

    @Autowired
    GirlProperties girlProperties;

    @Autowired
    GirlRepository girlRepository;

    @Value("${girl.cupSize}")
    private String cupSize;

    @Value("${girl.age}")
    public Integer age;

    @GetMapping("girlDetail")
    public String girl(){
        return "GirlProperties:Age:"+girlProperties.getAge()+"  CupSize:"+girlProperties.getCupSize()
                +"<br>Properties:Age:"+age+"  CupSize:"+cupSize;
    }

    /**
     * 获取所有数据
     *
     * @param
     * @return java.util.List<com.ronglexie.ronglexiegirl.entity.Girl>
     * @author wxt.xqr
     * @version 2018-1-14
     */
    @GetMapping("girls")
    public List<Girl> getGirlList(){
        List<Girl> girlList = girlRepository.findAll();
        return girlList;
    }

    /**
     * 新增一条数据
     *
     * @param cupSize
     * @param age
     * @return com.ronglexie.ronglexiegirl.entity.Girl
     * @author wxt.xqr
     * @version 2018-1-14
     */
    @PostMapping("girls")
    public Girl addGirl(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 获取一个对象
     *
     * @param id
     * @return com.ronglexie.ronglexiegirl.entity.Girl
     * @author wxt.xqr
     * @version 2018-1-14
     */
    @GetMapping("girls/{id}")
    public Girl getOneGirl(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新一条数据
     *
     * @param id
     * @param cupSize
     * @param age
     * @return com.ronglexie.ronglexiegirl.entity.Girl
     * @author wxt.xqr
     * @version 2018-1-14
     */
    @PutMapping("girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 删除一条数据
     *
     * @param id
     * @return void
     * @author wxt.xqr
     * @version 2018-1-14
     */
    @DeleteMapping("girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

}
