package com.rt.config;

import com.rt.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @创建人 wenxinghui
 * @创建时间 2020/4/27 16:09
 * @描述
 */
@Configuration
//@ComponentScan("com.rt")
public class SpringTestConfig {

    @Bean
    public Person createPerson(){
        Person p = new Person("张三",19);
        return p;
    }
}
