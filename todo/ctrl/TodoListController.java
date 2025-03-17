import java.util.List;

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
