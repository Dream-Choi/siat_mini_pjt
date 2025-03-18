package todo.ctrl;

import todo.model.domain.TodoRequestDTO;
import todo.service.TodoService;

public class TodoInsertController {
    private TodoService service;

    public TodoInsertController(){
    }
    public TodoInsertController(TodoService service){
        this.service=service;

    }
    public int insertTodo(TodoRequestDTO request){
        System.out.println("----------ctrl insertCtrl");
        return service.insertService(request);
    }
}