package ru.firstproject;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.firstproject.model.Menu;
import ru.firstproject.repository.MenuRepository;
import ru.firstproject.repository.jpa.JpaMenuRepositoryImpl;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
       try( ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-app.xml")){

           String[] str = ctx.getBeanDefinitionNames();
           Arrays.stream(str).forEach(System.out::println);

           MenuRepository repository = ctx.getBean("jpaMenuRepositoryImpl",MenuRepository.class);

           if(repository != null){
               List<Menu> list = repository.getAll();
               list.stream().forEach(System.out::println);
           }

       }

//        LunchData.lunchList.stream().forEach(System.out::println);



    }
}
