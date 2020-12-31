package com.project.crm.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.project.crm.mapper.UserMapper;
import com.project.crm.model.User;
import com.project.crm.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author: Muma
 * @date: Created in 2020/6/11 14:49
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

}
