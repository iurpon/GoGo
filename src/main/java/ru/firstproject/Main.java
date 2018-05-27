package ru.firstproject;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.firstproject.model.Menu;
import ru.firstproject.repository.jpa.JpaMenuRepositoryImpl;
import ru.firstproject.utils.LunchData;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-app.xml");

//        LunchData.lunchList.stream().forEach(System.out::println);



        String[] str = ctx.getBeanDefinitionNames();
        Arrays.stream(str).forEach(System.out::println);

        JpaMenuRepositoryImpl repository = ctx.getBean(JpaMenuRepositoryImpl.class);

        if(repository != null){
            List<Menu> list = repository.getAll();
            list.stream().forEach(System.out::println);
        }

    }
}
