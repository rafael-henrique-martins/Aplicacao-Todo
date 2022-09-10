package com.rhmrmtm.todo.repository;

import com.rhmrmtm.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
