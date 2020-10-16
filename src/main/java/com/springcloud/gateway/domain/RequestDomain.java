package com.springcloud.gateway.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/**
 * @author xutianhong
 * @Date 2020/10/13 11:14
 */
@Data
public class RequestDomain {
    @Id
    private String id;
    // 请求路径
    private String url;

    private String method;

    private String subject;

    private String moduleChDesc;

    private String moduleEnDesc;

    private String actionChDesc;

    private String actionEnDesc;

    /**
     * http请求参数
     */
    private String requestParams;
    /**
     * http请求结果
     */
    private String response;
    /**
     * 访问IP
     */
    private String remoteIp;
    /**
     * http请求失败或成功
     */
    private String status;

    private String actionTime;

    private String tenant;

    private String project;

    private String user;

    /**
     * 开始时间
     */
    @Transient
    private long beginTime;

    @Override
    public String toString() {
        return "RequestDomain{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", subject='" + subject + '\'' +
                ", moduleChDesc='" + moduleChDesc + '\'' +
                ", moduleEnDesc='" + moduleEnDesc + '\'' +
                ", actionChDesc='" + actionChDesc + '\'' +
                ", actionEnDesc='" + actionEnDesc + '\'' +
                ", requestParams=" + requestParams +
                ", response='" + response + '\'' +
                ", remoteIp='" + remoteIp + '\'' +
                ", status='" + status + '\'' +
                ", actionTime='" + actionTime + '\'' +
                ", tenant='" + tenant + '\'' +
                ", project='" + project + '\'' +
                ", user=" + user +
                ", beginTime=" + beginTime +
                '}';
    }


}
