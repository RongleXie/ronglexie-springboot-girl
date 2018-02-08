package com.ronglexie.ronglexiegirl.web;

import com.ronglexie.ronglexiegirl.entity.Girl;
import com.ronglexie.ronglexiegirl.enums.MessageEnum;
import com.ronglexie.ronglexiegirl.properties.GirlProperties;
import com.ronglexie.ronglexiegirl.repository.GirlRepository;
import com.ronglexie.ronglexiegirl.service.GirlService;
import com.ronglexie.ronglexiegirl.utils.Messageutils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    GirlService girlService;

    @Value("${girl.cupSize}")
    private String cupSize;

    @Value("${girl.age}")
    public Integer age;

    @ApiOperation(value="获取girl详情", notes="")
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
    @RequiresPermissions("girls:view")
    @ApiOperation(value="获取girl列表", notes="获取配置文件中注入属性值的Girl对象")
    @GetMapping("girls")
    public Object getGirlList(){
        List<Girl> girlList = girlRepository.findAll();
        return Messageutils.successed("获取数据成功",girlList);
    }

	/**
	 * 获取一个对象
	 *
	 * @param id
	 * @return com.ronglexie.ronglexiegirl.entity.Girl
	 * @author wxt.xqr
	 * @version 2018-1-14
	 */
	@ApiOperation(value="获取一个Girl", notes="获取一个Girl")
	@GetMapping("girls/{id}")
	@ApiImplicitParam(name = "id", value = "实体对象Girl的ID", required = true, dataType = "Long",paramType="path")
	public Object getOneGirl(@PathVariable("id") Integer id){
		return Messageutils.successed("获取数据成功",girlRepository.findOne(id));
	}

    /**
     * 新增一条数据
     *
     * @return com.ronglexie.ronglexiegirl.entity.Girl
     * @author wxt.xqr
     * @version 2018-1-14
     */
    @ApiOperation(value="新增一条数据", notes="新增一条数据")
	@ApiImplicitParam(name = "girl", value = "实体对象Girl", required = true, dataType = "Girl",paramType="path")
    @PostMapping("girls")
    public Object addGirl(@Valid Girl girl,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return Messageutils.error(MessageEnum.UNKNOW_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        return Messageutils.successed("保存成功",girlService.save(girl));
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
    public Object updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("id") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return Messageutils.successed("更新数据成功",girlService.save(girl));
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
    public Object deleteGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
        return Messageutils.successed("删除数据成功",null);
    }

    /**
     * 根据年龄查询数据
     *
     * @param age
     * @return java.util.List<com.ronglexie.ronglexiegirl.entity.Girl>
     * @author wxt.xqr
     * @version 2018-1-14
     */
    @GetMapping("girls/fingByAge/{id}")
    public Object findByAge(@PathVariable("id") Integer age){
        return Messageutils.successed("获取数据成功",girlRepository.findByAge(age));
    }

    /**
     * 查询人员年龄数据
     *
     * @param id
     * @return java.util.List<com.ronglexie.ronglexiegirl.entity.Girl>
     * @author wxt.xqr
     * @version 2018-1-14
     */
    @GetMapping("girls/getAge/{id}")
    public Object getAge(@PathVariable("id") Integer id) throws Exception {
        return girlService.getAge(id);
    }

}
