package com.example.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfiguration {

    /**
     * 容器中注册 mybatis 的分页插件
     * @return
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor(){
        return new MybatisPlusInterceptor();
    }

}
