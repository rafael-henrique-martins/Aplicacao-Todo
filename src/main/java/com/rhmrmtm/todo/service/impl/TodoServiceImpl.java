package com.rhmrmtm.todo.service.impl;

import com.rhmrmtm.todo.domain.Todo;
import com.rhmrmtm.todo.domain.dto.TodoDTO;
import com.rhmrmtm.todo.repository.TodoRepository;
import com.rhmrmtm.todo.service.TodoService;
import com.rhmrmtm.todo.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;


    public TodoDTO findById(Integer id){
        Todo obj = todoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        TodoDTO objDTO = coverte(obj);

        return objDTO;
    }

    private TodoDTO coverte(Todo obj) {
         return TodoDTO
                 .builder()
                 .id(obj.getId())
                 .titulo(obj.getTitulo())
                 .descricao(obj.getDescricao())
                 .finalizado(obj.getFinalizado())
                 .dataParaFInalizar(obj.getDataParaFInalizar())
                 .build();
    }

    public void instanciaDados(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Todo t1 = new Todo
                (null, "Estudar", "Estudar Spring com Angular",
                        LocalDateTime.parse("07/08/2022 15:44", formatter), false);

        todoRepository.saveAll(Arrays.asList(t1));
    }
}
