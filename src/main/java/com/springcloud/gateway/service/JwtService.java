package com.springcloud.gateway.service;

import java.util.Map;

/**
 * @author xutianhong
 * @Date 2020/10/13 14:35
 */
public interface JwtService {

    Map getClaimsFromToken(String token);

}
