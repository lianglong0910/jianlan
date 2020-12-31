package com.project.crm.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.project.crm.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @author: Muma
 * @date: Created in 2020/6/16 10:40
 */

@Controller
@RequestMapping(value = "/appUser")
public class ARController {

    @RequestMapping(value = "add")
    @ResponseBody
    public Object add(){
        User user = new User();
        user.setGender("男");
        user.setAge(60);
        user.setPhone("15069165200");
        return user.insert();
    }


    @RequestMapping(value = "update")
    @ResponseBody
    public Object update(){
        User user = new User();
        user.setId(6);
        user.setUserName("mybatis-plus");
        user.setGender("女");
        return user.updateById();
    }


    @RequestMapping(value = "select1")
    @ResponseBody
    public Object select1(){
        User user = new User();

        //1、根据id查询
        user = user.selectById(1);
        //或者这样用
        //user.setId(1);
        //user = user.selectById();

        return user;
    }


    @RequestMapping(value = "select2")
    @ResponseBody
    public Object select2(){
        User user = new User();

        //2、查询所有
        List<User> users = user.selectAll();

        return users;
    }


    @RequestMapping(value = "select3")
    @ResponseBody
    public Object select3(){
        User user = new User();

        //3、根据条件查询
        List<User> users = user.selectList(new EntityWrapper<User>().like("user_name","mybatis"));

        return users;
    }


    @RequestMapping(value = "select4")
    @ResponseBody
    public Object select4(){
        User user = new User();

        //4、查询符合条件的总数
        int count = user.selectCount(new EntityWrapper<User>().eq("phone","15069165200"));

        return count;
    }


    @RequestMapping(value = "delete1")
    @ResponseBody
    public Object delete1(){
        User user = new User();
        //删除数据库中不存在的数据也是返回true
        //1、根据id删除数据
        long id = 1;
        boolean result = user.deleteById(id);
        //或者这样写
        //user.setId(id);
        //boolean result = user.deleteById();
        return result;
    }


    @RequestMapping(value = "delete2")
    @ResponseBody
    public Object delete2(){
        User user = new User();
        //2、根据条件删除  没有符合条件的也会返回true
        boolean result = user.delete(new EntityWrapper<User>().like("user_name","mybatis"));
        return result;
    }



    @RequestMapping(value = "selectPage")
    @ResponseBody
    public Object selectPage(){
        /*
        * 这个分页方法和BaseMapper提供的分页一样都是内存分页，并非物理分页，
        * 因为sql语句中没用limit，和BaseMapper的selectPage方法一样，配置了分页插件后就可以实现真正的物理分页。
        * AR的分页方法与BaseMapper提供的分页方法不同的是，BaseMapper的selectPage方法返回值是查询到的记录的list集合，
        * 而AR的selectPage方法返回的是page对象，该page对象封装了查询到的信息，可以通过getRecords方法获取信息。
        */
        User user = new User();
        Page<User> page =
                user.selectPage(new Page<>(1,4),
                        new EntityWrapper<User>().like("user_name","mybatis"));

        List<User> users = page.getRecords();

        return users;
    }

}
