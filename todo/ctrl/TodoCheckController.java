package todo.ctrl;
import java.util.List;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoCheckController {
    private TodoService service;
    public TodoCheckController(){

    }
    public TodoCheckController(TodoService service){
        this.service= service;
    }
    public List<TodoResponseDTO> checkTodo(){
        System.out.println("----------ctrl checkCtrl");
        List<TodoResponseDTO> list= service.listService();
        return list.stream().filter(s->s.getStatus()=="Y").toList();
    }
}
