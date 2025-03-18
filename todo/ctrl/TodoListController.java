package todo.ctrl;
import java.util.List;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoListController {
    private TodoService service;
    public TodoListController(){
        service=new TodoService();
    }
    public List<TodoResponseDTO> listTodo(){
        System.out.println("----------ctrl listCtrl");
        return service.listService();
    }
}