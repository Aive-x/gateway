package com.springcloud.gateway.config;

import com.springcloud.gateway.filter.RequestDomainFilter;
import com.springcloud.gateway.filter.VerifyTokenFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xutianhong
 * @Date 2020/10/13 11:10
 */
@Configuration
@Slf4j
public class RouteFilterConfig {

    /**
     * 自定义入口filter，初始化RequestDomain
     *
     * @return
     */
    @Bean
    public GlobalFilter RequestDomainFilter() {
        log.info("装载 RequestDomainFilter Bean");
        return new RequestDomainFilter(-10);
    }

    /**
     * 判断是否为登录请求，验证token
     *
     * @return
     */
    @Bean
    public GlobalFilter VerifyTokenFilter() {
        log.info("装载 VerifyTokenFilter Bean");
        return new VerifyTokenFilter(-9);
    }

}
