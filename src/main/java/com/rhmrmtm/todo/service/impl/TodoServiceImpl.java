package com.rhmrmtm.todo.service.impl;

import com.rhmrmtm.todo.domain.Todo;
import com.rhmrmtm.todo.domain.dto.TodoDTO;
import com.rhmrmtm.todo.repository.TodoRepository;
import com.rhmrmtm.todo.service.TodoService;
import com.rhmrmtm.todo.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public TodoDTO findById(Integer id) {
        Todo obj = todoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException
                        ("Objeto não encontrado id: " + id + ", Tipo: " + Todo.class.getName()));
        TodoDTO objDTO = coverte(obj);

        return objDTO;
    }


    public List<TodoDTO> findAllOpen() {
        List<Todo> lista = todoRepository.findAll();
        List<TodoDTO> l = new ArrayList<>();
        for (Todo x : lista) {
            if (!x.getFinalizado()) {
                TodoDTO dto = (coverte(x));
                l.add(dto);
            }
        }
        return l;
    }


    public List<TodoDTO> findAllClose() {
        List<Todo> lista = todoRepository.findAll();
        List<TodoDTO> l = new ArrayList<>();
        for (Todo x : lista) {
            if (x.getFinalizado()) {
                TodoDTO dto = (coverte(x));
                l.add(dto);
            }
        }
        return l;
    }


    public List<TodoDTO> findAll() {
        List<Todo> lista = todoRepository.findAll();
        List<TodoDTO> l = new ArrayList<>();
        for (Todo x : lista) {
            TodoDTO dto = (coverte(x));
            l.add(dto);
        }
        return l;
    }


    public TodoDTO save(TodoDTO todoDTO) {
        todoDTO.setId(null);
        Todo todo = todoRepository.save(coverte(todoDTO));
        return coverte(todo);
    }


    public void delete(Integer id) {
        findById(id);
        todoRepository.deleteById(id);
    }


    public TodoDTO update(Integer id, TodoDTO todoDTO) {
        findById(id);
        todoDTO.setId(id);
        todoRepository.save(coverte(todoDTO));
        return todoDTO;
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


    private Todo coverte(TodoDTO obj) {
        return Todo
                .builder()
                .id(obj.getId())
                .titulo(obj.getTitulo())
                .descricao(obj.getDescricao())
                .finalizado(obj.getFinalizado())
                .dataParaFInalizar(obj.getDataParaFInalizar())
                .build();
    }
}
