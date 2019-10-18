package com.liyulin.webservice.service.impl;

import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;
import org.springframework.stereotype.Service;

import com.liyulin.webservice.response.UserRespBody;
import com.liyulin.webservice.service.IUserService;

@InInterceptors(interceptors={"com.liyulin.webservice.config.ReqInterceptor","com.liyulin.webservice.config.AuthInterceptor"})
@WebService(
		// 对外发布的服务名
		serviceName = "UserService",
		// 指定你想要的名称空间，通常使用使用包名反转
		targetNamespace = "http://service.webservice.liyulin.com/",
		// 服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
		endpointInterface = "com.liyulin.webservice.service.IUserService")
@Service
public class UserServiceImpl implements IUserService {

	@Override
	public UserRespBody getUser(String userId) {
		UserRespBody user = new UserRespBody();
		user.setUserId(userId);
		user.setUserName("张三");
		user.setEmail("zhangsan@qq.com");
		
		return user;
	}

	@Override
	public String getUserName(String userId) {
		return "张三"+userId;
	}

}