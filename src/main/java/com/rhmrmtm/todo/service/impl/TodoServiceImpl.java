package com.rhmrmtm.todo.service.impl;

import com.rhmrmtm.todo.domain.Todo;
import com.rhmrmtm.todo.repository.TodoRepository;
import com.rhmrmtm.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public void instanciaDados(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Todo t1 = new Todo
                (null, "Estudar", "Estudar Spring com Angular",
                        LocalDateTime.parse("07/08/2022 15:44", formatter), false);

        todoRepository.saveAll(Arrays.asList(t1));
    }
}
