package todo.ctrl;
import java.util.List;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoListController {
    private TodoService service;
    public TodoListController(){

    }
    public TodoListController(TodoService service){
        this.service= service;
    }
    public List<TodoResponseDTO> listTodo(){
        System.out.println("----------ctrl listCtrl");
        return service.listService();
    }
}