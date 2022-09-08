package com.rhmrmtm.todo.config;

import com.rhmrmtm.todo.service.TodoService;
import com.rhmrmtm.todo.service.impl.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("teste")
public class TodoConfig {

    @Autowired
    private TodoServiceImpl todoServiceImpl;

    @Bean
    public boolean instancia(){
        this.todoServiceImpl.instanciaDados();
        return true;
    }
}
