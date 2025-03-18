package todo.front;

import java.util.List;

import todo.ctrl.TodoDeleteController;
import todo.ctrl.TodoInsertController;
import todo.ctrl.TodoListController;
import todo.ctrl.TodoUpdateController;
import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class FrontController {
    //1:전체보기, 2:입력, 3:수정, 4:삭제
    public List<TodoResponseDTO> list(){
        System.out.println("-----FrontController list");
        TodoListController listCtrl = new TodoListController();
        List<TodoResponseDTO> list=listCtrl.listTodo();
        return list;
    }
    public int register(String title, String content, String startDate, String endDate, int priority){
        System.out.println("-----FrontController register");
        TodoInsertController insertCtrl=new TodoInsertController();
        TodoRequestDTO request=TodoRequestDTO
                            .builder()
                            .title(title)
                            .content(content)
                            .startDate(startDate)
                            .endDate(endDate)
                            .priority(priority)
                            .build();
        int insert=insertCtrl.insertTodo(request);
        return insert;
    }
    public int update(){
        System.out.println("-----FrontController update");
        TodoUpdateController updateCtrl=new TodoUpdateController();
        TodoRequestDTO request=TodoRequestDTO.builder().build();
        int update=updateCtrl.updateTodo(request);
        return update;
    }
    public int delete(){
        System.out.println("-----FrontController delete");
        TodoDeleteController deleteCtrl=new TodoDeleteController();
        int delete=deleteCtrl.deleteTodo(1);
        return delete;
    }
}
