package todo.service;

import java.util.List;
import java.util.Optional;

import todo.model.dao.TodoDao;
import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class TodoService {
    private TodoDao dao;
    public TodoService(){
        dao=new TodoDao();
    }
    public int insertService(TodoRequestDTO request){
        System.out.println("------ service insertService");
        return dao.insertRow(request);
    }
    public Optional<TodoResponseDTO> selectService(int seq){
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

