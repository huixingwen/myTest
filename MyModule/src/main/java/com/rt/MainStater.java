package com.rt;

import com.rt.config.SpringTestConfig;
import com.rt.pojo.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @创建人 wenxinghui
 * @创建时间 2020/4/27 16:12
 * @描述
 */
public class MainStater {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(SpringTestConfig.class);
        Person person = a.getBean(Person.class);
        System.out.println(person);
        System.out.println("22222");
    }
}
