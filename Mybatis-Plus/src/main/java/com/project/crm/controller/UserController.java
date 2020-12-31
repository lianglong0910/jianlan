package com.project.crm.controller;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.project.crm.mapper.UserMapper;
import com.project.crm.model.User;
import java.util.List;

import com.project.crm.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Muma
 * @date: Created in 2020/6/11 14:47
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "add")
    @ResponseBody
    public Object add(){
        User user = new User();
        user.setUserName("mybatis-plus");
        user.setGender("男");
        user.setAge(18);
        user.setPhone("15000000000");
        return userMapper.insert(user);
    }


    //updateById方法，没有传值的字段不会进行更新，
    //updateAllColumnById方法，会更新所有的列，没有传值的列会更新为null。
    @RequestMapping("update")
    @ResponseBody
    public Object update(HttpServletRequest request){
        User user = new User();
        user.setId(4);
        user.setUserName("mybatis-plus");
        user.setAge(20);
        user.setPhone("1511111111");
        return userMapper.updateById(user);
    }


    @RequestMapping("selectById")
    @ResponseBody
    public Object selectById(HttpServletRequest request){
        return userMapper.selectById(4);
    }


    @RequestMapping("selectByIds")
    @ResponseBody
    public Object selectByIds(HttpServletRequest request){
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(4);
        return userMapper.selectBatchIds(ids);
    }


    //根据条件查询一条数据
    @RequestMapping("selectOne")
    @ResponseBody
    public Object selectOne(HttpServletRequest request){
        User user = new User();
        //若是数据库中符合传入的条件的记录有多条，那就不能用这个方法，会报错
        user.setUserName("mybatis-plus");
        user.setAge(18);
        return userMapper.selectOne(user);
    }


    //根据查询条件返回多条数据
    @RequestMapping("selectByMap")
    @ResponseBody
    public Object selectByMap(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("user_name","mybatis-plus");
        return userMapper.selectByMap(map);
    }


    //分页查询
    @RequestMapping("selectPage")
    @ResponseBody
    public Object selectPage(HttpServletRequest request){
        /*
        在page中传入分页信息，后者为null的分页条件，这里先让其为null，讲了条件构造器再说其用法。
        这个分页其实并不是物理分页，而是内存分页。
        也就是说，查询的时候并没有limit语句。等配置了分页插件后才可以实现真正的分页
        **/

        return userMapper.selectPage(new Page<>(1,5),null);
    }


    @RequestMapping("deleteById")
    @ResponseBody
    public Object deleteById(HttpServletRequest request){
        return userMapper.deleteById(6);
    }


    @RequestMapping("deleteByIds")
    @ResponseBody
    public Object deleteByIds(HttpServletRequest request){
        List<Integer> ids = new ArrayList<>();
        ids.add(7);
        ids.add(8);
        return userMapper.deleteBatchIds(ids);
    }


    @RequestMapping("deleteByMap")
    @ResponseBody
    public Object deleteByMap(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("user_name","mybatis-plus");
        return userMapper.deleteByMap(map);
    }

    /**
    *以上基本的 CRUD 操作，我们仅仅需要继承一个 BaseMapper 即可实现大部分单表 CRUD 操作。
     * BaseMapper 提供了多达 17 个方法供使用, 可以极其方便的实现单一、批量、分页等操作，极大的减少开发负担。
     * 我们需要分页查询 tb_employee 表中，年龄在 18~50 之间性别为男且姓名为 xx 的所有用户，这时候我们该如何实现上述需求呢？
     * 使用MyBatis : 需要在 SQL 映射文件中编写带条件查询的 SQL,并用PageHelper 插件完成分页. 实现以上一个简单的需求，往往需要我们做很多重复单调的工作。
     * 使用MP: 依旧不用编写 SQL 语句，MP 提供了功能强大的条件构造器 ------ EntityWrapper。
    **/


    //分页查询年龄在0-20之间 用户名为mybatis-plus的用户
    @RequestMapping("select1")
    @ResponseBody
    public Object select1(HttpServletRequest request){

        /*分页查询和之前一样，new 一个page对象传入分页信息即可。
        至于分页条件，new 一个EntityWrapper对象，调用该对象的相关方法即可。
        between方法三个参数，分别是column、value1、value2，该方法表示column的值要在value1和value2之间；
        eq是equals的简写，该方法两个参数，column和value，表示column的值和value要相等。
        注意column是数据表对应的字段，而非实体类属性字段。
         */

        return userMapper.selectPage(new Page<>(1,20),
                new EntityWrapper<User>()
                .between("age",0,20)
                .eq("user_name","mybatis-plus"));

    }



    //查询性别为男 并且名字like 许红祥 或者电话like 150
    @RequestMapping("select2")
    @ResponseBody
    public Object select2(HttpServletRequest request){

        return userMapper.selectList( new EntityWrapper<User>()
                .eq("gender","男")
                .like("user_name","mybatis")
                //.or()//和or new 区别不大
                .orNew()
                .like("phone","150"));
    }


    //查询行别为女 通过id排序 并分页
    @RequestMapping("select3")
    @ResponseBody
    public Object select3(HttpServletRequest request){
        /*
        简单分页是指不用page对象进行分页。
        orderBy方法就是根据传入的column进行升序排序，若要降序，可以使用orderByDesc方法，
        也可以如案例中所示用last方法；last方法就是将last方法里面的value值追加到sql语句的后面，
        **/

        return userMapper.selectList(new EntityWrapper<User>()
                .eq("gender","女")
                //直接orderby 是升序，asc
                .orderBy("id")
                //在sql语句后面追加last里面的内容(改为降序，同时分页))
                .last("desc limit 1,5"));
    }


    @RequestMapping("select4")
    @ResponseBody
    public Object select4(HttpServletRequest request){
        /*
        条件构造器除了EntityWrapper，还有Condition
        Condition和EntityWrapper的区别就是，创建条件构造器时，EntityWrapper是new出来的，
        而Condition是调create方法创建出来。
        **/

        return userMapper.selectPage(new Page<User>(1,5),
                Condition.create()
                        .between("age",0,18)
                        .eq("gender","女"));
    }


    //条件更新
    @RequestMapping("update1")
    @ResponseBody
    public Object update1(HttpServletRequest request){
        User user = new User();
        user.setUserName("BBB");
        user.setAge(22);

        return userMapper.update(user,new EntityWrapper<User>()
                .eq("user_name","AAA")
                .eq("age","20"));
    }


    //条件删除
    @RequestMapping("delete1")
    @ResponseBody
    public Object delete1(HttpServletRequest request){

        return userMapper.delete(new EntityWrapper<User>()
                .eq("user_name","BBB")
                .eq("age","22"));
    }


}
