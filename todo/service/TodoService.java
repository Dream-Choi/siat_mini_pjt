import java.util.List;

public class TodoService {
    private TodoDao dao;
    public TodoService(){
        dao=new TodoDao();
    }
    public int insertService(TodoRequestDTO request){
        System.out.println("------ service insertService");
        return dao.insertRow(request);
    }
    public TodoResponseDTO selectService(int seq){
        System.out.println("------ service selectService");
        return dao.selectRow(seq);
    }
    public int deleteService(int seq){
        System.out.println("------ service deleteService");
        return dao.deleteRow(seq);
    }
    public int updateService(TodoRequestDTO request){
        System.out.println("------ service updateService");
        return dao.updateRow(request);
    }
    public List<TodoResponseDTO> listService(){
        System.out.println("------ service listService");
        return dao.listRow();
    }
}

