public class TodoUpdateController {
    private TodoService service;
    public TodoUpdateController(){
        service=new TodoService();
    }
    public int updateTodo(TodoRequestDTO request){
        System.out.println("----------ctrl updateCtrl");
        return service.updateService(request);
    }
}
