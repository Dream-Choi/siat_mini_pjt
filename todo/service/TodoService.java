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
}

