package todo.ctrl;

import todo.service.TodoService;

public class TodoDeleteController {
    private TodoService service;
    public TodoDeleteController(){
        service=new TodoService();
    }
    public int deleteTodo(int seq){
        System.out.println("----------ctrl deleteCtrl");
        return service.deleteService(seq);
    }

}