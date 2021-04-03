package com.yc.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.yc.demo.config.convert.BigDecimalToStringSerializer;
import com.yc.demo.config.interceptor.ReactInterceptor;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Yanchen
 * date 2018/8/5 17:42
 */
@Configuration
@JsonComponent
public class WebAppConfig implements WebMvcConfigurer
{
    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 需要添加多个拦截器的话，调用addInterceptor()多次即可
        registry.addInterceptor(new ReactInterceptor())
                // 拦截器要拦截的url规则
                .addPathPatterns("/**")
                // 拦截器屏蔽的url规则
                .excludePathPatterns("/**/remoteHessian.do_", "/index.html", "/static/**", "/error", "/admin/sms/**", "/system/login.do_"
                        ,"/**/callBack","/**/**/callBack" , "/**/expired","/autocache/*", "/inc/expired.jsp",
                        "/swagger-ui.html","/swagger-resources/**","/swagger-resources/**","/webjars/**", "/system/findPassword.do_")
                .excludePathPatterns("/employee/changePasswordByToken.do_")
                .excludePathPatterns("/")
                // 拦截器的执行顺序
                .order(1);
    }

    /**
     * 解决ajax解析后端返回字段经度问题
     * @param builder builder
     */
    /**
     * 解决前后端精度问题
     */
    @Bean
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        //ObjectMapper 是Jackson库的主要类。它提供一些功能将转换成Java对象匹配JSON结构,反之亦然
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        //忽略value为null 时 key的输出
        SimpleModule simpleModule = new SimpleModule();
        //格式化时间
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //序列化将Long转String类型
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        SimpleModule bigIntegerModule = new SimpleModule();
        //序列化将BigInteger转String类型
        bigIntegerModule.addSerializer(BigInteger.class, ToStringSerializer.instance);
        SimpleModule bigDecimalModule = new SimpleModule();
        //序列化将BigDecimal转String类型
        bigDecimalModule.addSerializer(BigDecimal.class, BigDecimalToStringSerializer.getInstance());
        objectMapper.registerModule(simpleModule);
        objectMapper.registerModule(bigDecimalModule);
        objectMapper.registerModule(bigIntegerModule);
        return objectMapper;
    }

    /**
     * 过滤Swagger2的静态资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}