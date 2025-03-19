package todo.ctrl;

import java.util.Optional;

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
        Optional<TodoResponseDTO> response=service.selectService(seq);
        if(response.isPresent()){
            return response.get();
        }else{
            return null;
        }
    }

}
