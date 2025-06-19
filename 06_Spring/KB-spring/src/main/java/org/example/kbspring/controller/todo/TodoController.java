package org.example.kbspring.controller.todo;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.domain.todo.Todo;
import org.example.kbspring.service.todo.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Todo Controller")
@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    //암것도 안쓰면 /todo(RequestMapping)으로 자동으로 간다.
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        return ResponseEntity.ok(todoService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createTodo(@RequestBody Todo todo){
        todoService.save(todo);
        return ResponseEntity.ok("Create Completed");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Integer id){
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> updateDone(@PathVariable Integer id){
        todoService.updateDone(id);
        return ResponseEntity.ok("Update Completed");
    }

}
