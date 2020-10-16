package com.springcloud.gateway.filter;

import com.springcloud.gateway.domain.RequestDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author xutianhong
 * @Date 2020/10/13 14:17
 */
public class AuthGatewayFilter implements GlobalFilter, Ordered {

    @Autowired
    private VerifyTokenFilter verifyTokenFilter;

    private int order;

    public AuthGatewayFilter(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        RequestDomain requestDomain = exchange.getAttribute("request_domain");

        if(requestDomain.getUrl().equals("/user/login")){
            return chain.filter(exchange);
        }

        return null;
    }
}
