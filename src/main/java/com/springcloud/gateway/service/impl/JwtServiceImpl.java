package com.springcloud.gateway.service.impl;

import com.springcloud.gateway.service.JwtService;
import com.springcloud.gateway.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author xutianhong
 * @Date 2020/10/13 14:36
 */
public class JwtServiceImpl implements JwtService {

    @Override
    public Map getClaimsFromToken(String token) {
        Map user = JwtUtil.getClaimsFromToken(token);
        return user;
    }
}
