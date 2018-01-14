package com.ronglexie.ronglexiegirl.web;

import com.ronglexie.ronglexiegirl.entity.Girl;
import com.ronglexie.ronglexiegirl.properties.GirlProperties;
import com.ronglexie.ronglexiegirl.repository.GirlRepository;
import com.ronglexie.ronglexiegirl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

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

    @Autowired
    GirlService girlService;

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
     * @return com.ronglexie.ronglexiegirl.entity.Girl
     * @author wxt.xqr
     * @version 2018-1-14
     */
    @PostMapping("girls")
    public Girl addGirl(@Valid Girl girl,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(""+bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlService.save(girl);
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
        return girlService.save(girl);
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

    /**
     * 根据年龄查询数据
     *
     * @param age
     * @return java.util.List<com.ronglexie.ronglexiegirl.entity.Girl>
     * @author wxt.xqr
     * @version 2018-1-14
     */
    @GetMapping("girls/fingByAge/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

}
