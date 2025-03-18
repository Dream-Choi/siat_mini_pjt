package todo.front;

import java.util.List;

import todo.ctrl.TodoDeleteController;
import todo.ctrl.TodoInsertController;
import todo.ctrl.TodoListController;
import todo.ctrl.TodoUpdateController;
import todo.model.domain.TodoResponseDTO;

public class FrontController {
    //1:전체보기, 2:입력, 3:수정, 4:삭제
    public List<TodoResponseDTO> list(){
        System.out.println("-----FrontController list");
        TodoListController listCtrl = new TodoListController();
        List<TodoResponseDTO> list=listCtrl.listTodo();
        return list;
    }
    public int register(){
        System.out.println("-----FrontController register");
        TodoInsertController insertCtrl=new TodoInsertController();
        int insert=insertCtrl.insertTodo(null);
        return insert;
    }
    public int update(){
        System.out.println("-----FrontController update");
        TodoUpdateController updateCtrl=new TodoUpdateController();
        int update=updateCtrl.updateTodo(null);
        return update;
    }
    public int delete(){
        System.out.println("-----FrontController delete");
        TodoDeleteController deleteCtrl=new TodoDeleteController();
        int delete=deleteCtrl.deleteTodo(0);
        return delete;
    }
}
