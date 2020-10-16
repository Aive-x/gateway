package com.springcloud.gateway.filter;

import com.springcloud.gateway.domain.RequestDomain;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author xutianhong
 * @Date 2020/10/13 11:11
 */
public class RequestDomainFilter implements GlobalFilter, Ordered {
    private int order;

    public RequestDomainFilter(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put("request_domain", initAuditDomain(exchange));
        return chain.filter(exchange);
    }

    /**
     * 初始化AuditDomain
     *
     * @param exchange
     * @return
     */
    private RequestDomain initAuditDomain(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        RequestDomain requestDomain = new RequestDomain();
        String path = request.getURI().getPath();
        requestDomain.setUrl(path);
        // 记录开始时间
        requestDomain.setBeginTime(System.currentTimeMillis());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        requestDomain.setActionTime(now.format(ofPattern));
        // 获取method，method为大写可以直接与HttpMethod匹配
        String method = exchange.getRequest().getMethodValue();
        requestDomain.setMethod(method);
        //requestDomain.setRemoteIp(getIpAddress(request));
        // 根据请求路径匹配Route资源
        //requestDomain.setRouteResource(RouteResourceManager.initRouteResource(path));
        // 将请求参数中的map也设置到pathVariableMap中，统一查找
/*        if (request.getQueryParams() != null && requestDomain.getRouteResource().pathVariableMap != null) {
            requestDomain.getRouteResource().pathVariableMap.putAll(request.getQueryParams().toSingleValueMap());
        }*/
        System.out.println(requestDomain.toString());
        return requestDomain;
    }
}
