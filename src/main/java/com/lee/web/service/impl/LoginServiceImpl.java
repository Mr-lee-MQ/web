package com.lee.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.web.entity.Login;
import com.lee.web.service.LoginService;
import com.lee.web.mapper.LoginMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 *
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login>
implements LoginService {

    //登录功能
    @Override
    public Login getByUsername(String username) {
        LambdaQueryWrapper<Login> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Login::getUsername, username);
        List<Login> list = list(queryWrapper);
        if (CollectionUtils.isNotEmpty(list)) {
            // 从设计上来说,一般用户名是唯一的,所以list的大小一般为1
            return list.get(0);
        }
        return null;
    }
}




