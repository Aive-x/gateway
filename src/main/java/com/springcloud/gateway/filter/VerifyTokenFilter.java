package com.springcloud.gateway.filter;

import com.springcloud.gateway.common.enumm.ErrorMessageEnum;
import com.springcloud.gateway.common.exception.AuthRuntimeException;
import com.springcloud.gateway.domain.RequestDomain;
import com.springcloud.gateway.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author xutianhong
 * @Date 2020/10/13 14:16
 */
public class VerifyTokenFilter implements GlobalFilter, Ordered {

    private int order;

    public VerifyTokenFilter(int order) {
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
        HttpHeaders headers = exchange.getRequest().getHeaders();
        String token = headers.getFirst("Authorization");
        if (StringUtils.isEmpty(token)){
            throw new AuthRuntimeException(ErrorMessageEnum.TOKEN_NOT_NULL);
        }
        return chain.filter(exchange);
    }

}
