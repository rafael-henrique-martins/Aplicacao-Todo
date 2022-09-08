package com.rhmrmtm.todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rhmrmtm.todo.domain.Todo;
import com.rhmrmtm.todo.repository.TodoRepository;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner{
	
	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		Todo t1 = new Todo
				(null, "Estudar", "Estudar Spring com Angular",
						LocalDateTime.parse("07/08/2022 15:44", formatter), false);

		todoRepository.saveAll(Arrays.asList(t1));
	}
}
