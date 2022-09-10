package com.rhmrmtm.todo.service;

import com.rhmrmtm.todo.domain.Todo;
import com.rhmrmtm.todo.domain.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    TodoDTO findById(Integer id);
    TodoDTO save(TodoDTO todoDTO);
    List<TodoDTO> findAll();
    void delete(Integer id);
    TodoDTO update(Integer id, TodoDTO todoDTO);
    List<TodoDTO> findAllOpen();
    List<TodoDTO> findAllClose();
}
