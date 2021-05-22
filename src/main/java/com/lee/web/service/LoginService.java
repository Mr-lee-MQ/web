package com.lee.web.service;

import com.lee.web.entity.Login;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface LoginService extends IService<Login> {

    //登录功能
    Login getByUsername(String username);
}
