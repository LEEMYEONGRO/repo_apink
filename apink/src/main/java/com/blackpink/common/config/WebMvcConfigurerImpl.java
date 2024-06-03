package com.blackpink.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.blackpink.interceptor.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer{

		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			
			registry.addInterceptor(new CheckLoginSessionInterceptor()) //LoginCheckInterceptor 등록
//					.order(2)
					.addPathPatterns("/**")
					.excludePathPatterns(
//							"/resources/**",
//							"/adt/**",
							"/user/**",
							"/xdmin/**",
							"/loginXdm",
							"/loginUser",
							"/signinXdm",
							"/portfolioIndex",
							"/indexUser",
							"/shopList",
							"/shopDetailedPage",
							"/joinMembership"
//							"/v1/infra/member/signupXdmForm",
//							"/v1/infra/member/signinXdmForm",
//							"/v1/infra/member/signinXdmProc"
//							"/v1/infra/member/signoutXdmProc"
//							"/v1/infra/index/indexXdmView"
//							"/members/add", 
//							"/login", 
//							"/logout", 
					)
			;
		}
}

