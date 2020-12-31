import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.project.crm.mapper.StudentMapper;
import com.project.crm.mapper.UserMapper;
import com.project.crm.model.Student;
import com.project.crm.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Muma
 * @date: Created in 2020/6/18 16:41
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-common.xml"})
public class TestTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        User user = new User();
        user.setGender("男");
        user.setAge(18);
        user.setPhone("123456");
        userMapper.insert(user);

    }

    @Test
    public void test2(){
        User user = new User();
        user.setGender("女");
        user.setAge(20);
        user.setPhone("654321");
        userMapper.update(user,new EntityWrapper<User>()
                .eq("id",15));

    }
}
