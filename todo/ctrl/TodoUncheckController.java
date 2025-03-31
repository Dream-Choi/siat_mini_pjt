package todo.ctrl;
import java.util.List;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoUncheckController {
    private TodoService service;
    public TodoUncheckController(){

    }
    public TodoUncheckController(TodoService service){
        this.service= service;
    }
    public List<TodoResponseDTO> uncheckTodo(){
        System.out.println("----------ctrl uncheckCtrl");
        List<TodoResponseDTO> list= service.listService();
        return list.stream().filter(s->s.getStatus()=="Y").toList();
    }
}
