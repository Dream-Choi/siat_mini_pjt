package todo.ctrl;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoReadController {
    private TodoService service;
    public TodoReadController(TodoService service){
        this.service=service;
    }
    public TodoReadController(){
    }
    public TodoResponseDTO selectTodo(int seq){
        System.out.println("----------ctrl selectCtrl");
        return service.selectService(seq);
    }

}
