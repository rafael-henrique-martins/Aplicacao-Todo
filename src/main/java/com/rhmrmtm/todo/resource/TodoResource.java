package com.rhmrmtm.todo.resource;

import com.rhmrmtm.todo.domain.dto.TodoDTO;
import com.rhmrmtm.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/todos")
public class TodoResource {

    @Autowired
    private TodoService todoService;

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> findById(@PathVariable Integer id) {
        TodoDTO todoDTO = todoService.findById(id);
        return ResponseEntity.ok().body(todoDTO);
    }


    @GetMapping("/open")
    public ResponseEntity<List<TodoDTO>> listOpen() {
        List<TodoDTO> lista = todoService.findAllOpen();
        return ResponseEntity.ok().body(lista);
    }


    @GetMapping("/close")
    public ResponseEntity<List<TodoDTO>> listClose() {
        List<TodoDTO> lista = todoService.findAllClose();
        return ResponseEntity.ok().body(lista);
    }


    @GetMapping
    public ResponseEntity<List<TodoDTO>> listAll() {
        List<TodoDTO> lista = todoService.findAll();
        return ResponseEntity.ok().body(lista);
    }


    @PostMapping
    public ResponseEntity<TodoDTO> save(@RequestBody TodoDTO todoDTO) {
        todoDTO = todoService.save(todoDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(todoDTO
                        .getId())
                .toUri();
        return ResponseEntity.created(uri).body(todoDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> update(@PathVariable Integer id, @RequestBody TodoDTO todoDTO) {
        TodoDTO todo = todoService.update(id, todoDTO);
        return ResponseEntity.ok().body(todo);

    }
}
