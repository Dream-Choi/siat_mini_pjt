public class TodoService {
    private TodoDao dao =new TodoDao();
    public int insertService(TodoRequestDTO request){
        System.out.println("------ service insertService");
        return dao.insertRow(request);
    }
}
