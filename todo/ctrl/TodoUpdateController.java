package todo.ctrl;

import todo.model.domain.TodoRequestDTO;
import todo.service.TodoService;

public class TodoUpdateController {
    private TodoService service;
    public TodoUpdateController(){
    }
    public TodoUpdateController(TodoService service){
        this.service=service;
    }
    public int updateTodo(TodoRequestDTO request){
        System.out.println("----------ctrl updateCtrl");
        return service.updateService(request);
    }
}
