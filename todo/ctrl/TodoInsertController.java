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