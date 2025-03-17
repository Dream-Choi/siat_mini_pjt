public class TodoInsertController {
    private TodoService service=new TodoService();
    public int insertTodo(TodoRequestDTO request){
        System.out.println("----------ctrl insertCtrl");
        return service.insertService(request);
    }
    
}