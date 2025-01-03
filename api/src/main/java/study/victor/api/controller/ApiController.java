package study.victor.api.controller;
import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping(path = "/tasks")
public class ApiController {

    private List<String> Tasks = new ArrayList<>();

    private ObjectMapper objectMapper;

    public ApiController(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<String> listTask() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(Tasks));
    }

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody String tasks){
        Tasks.add(tasks);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTask() {
        Tasks = new ArrayList<>();
        return ResponseEntity.ok().build();
    }
}
