package com.project.crm.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.project.crm.model.User;

import java.util.List;

/**
 * @author: Muma
 * @date: Created in 2020/6/11 14:50
 */
public interface UserMapper extends BaseMapper<User> {

    List selectAll();

}
