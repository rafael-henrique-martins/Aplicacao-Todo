package com.rhmrmtm.todo.resource;

import com.rhmrmtm.todo.domain.dto.TodoDTO;
import com.rhmrmtm.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping(value="/todos")
public class TodoResource {

    @Autowired
    private TodoService todoService;

    @GetMapping("/{id}")
    public TodoDTO findById(@PathVariable Integer id){
        return todoService.findById(id);
    }
}
