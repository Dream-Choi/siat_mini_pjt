public class TodoReadController {
    private TodoService service;
    public TodoReadController(){
        service=new TodoService();
    }
    public TodoResponseDTO selectTodo(int seq){
        System.out.println("----------ctrl selectCtrl");
        return service.selectService(seq);
    }

}
