package todo.ctrl;

import todo.model.domain.TodoRequestDTO;
import todo.service.TodoService;

public class TodoInsertController {
    private TodoService service;
    public TodoInsertController(){
        service=new TodoService();
    }
    public int insertTodo(TodoRequestDTO request){
        System.out.println("----------ctrl insertCtrl");
        return service.insertService(request);
    }
}