package todo.front;

import java.util.List;

import todo.ctrl.TodoCheckController;
import todo.ctrl.TodoDeleteController;
import todo.ctrl.TodoInsertController;
import todo.ctrl.TodoListController;
import todo.ctrl.TodoReadController;
import todo.ctrl.TodoSortController;
import todo.ctrl.TodoUncheckController;
import todo.ctrl.TodoUpdateController;
import todo.factory.BeanFactory;
import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class FrontController {


    private BeanFactory factory;
    public FrontController(){
        factory=BeanFactory.getInstance();
    }
    //1:전체보기, 2:입력, 3:수정, 4:삭제
    public List<TodoResponseDTO> list(){
        System.out.println("-----FrontController list");
        TodoListController listCtrl=(TodoListController)factory.getCtrl("list");
        List<TodoResponseDTO> list=listCtrl.listTodo();
        return list;
    }
    public List<TodoResponseDTO> checkList(){
        System.out.println("-----FrontController list");
        TodoCheckController listCtrl=(TodoCheckController)factory.getCtrl("check");
        List<TodoResponseDTO> checkList=listCtrl.checkTodo();
        return checkList;
    }
    public List<TodoResponseDTO> uncheckList(){
        System.out.println("-----FrontController list");
        TodoUncheckController listCtrl=(TodoUncheckController)factory.getCtrl("uncheck");
        List<TodoResponseDTO> uncheckList=listCtrl.uncheckTodo();
        return uncheckList;
    }
    public int register(String title, String content, String startDate, String endDate, int priority){
        System.out.println("-----FrontController register");
        TodoInsertController insertCtrl=(TodoInsertController)factory.getCtrl("register");
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
    public int update(int seq,String title, String content, String startDate,String status, String endDate, int priority){
        System.out.println("-----FrontController update");
        TodoUpdateController updateCtrl=(TodoUpdateController)factory.getCtrl("update");
        TodoRequestDTO request=TodoRequestDTO.builder()
                                .seq(seq)
                                .title(title)
                                .content(content)
                                .startDate(startDate)
                                .status(status)
                                .endDate(endDate)
                                .priority(priority)
                                .build();
        int update=updateCtrl.updateTodo(request);
        return update;
    }
    public int delete(int seq){
        System.out.println("-----FrontController delete");
        TodoDeleteController deleteCtrl=(TodoDeleteController)factory.getCtrl("delete");
        int delete=deleteCtrl.deleteTodo(seq);
        return delete;
    }
    public TodoResponseDTO read(int seq){
        System.out.println("-----FrontController read");
        TodoReadController readCtrl=(TodoReadController)factory.getCtrl("read");
        TodoResponseDTO response=readCtrl.selectTodo(seq);
        return response;
    }
    public List<TodoResponseDTO> sort(){
        System.out.println("-----FrontController list");
        TodoSortController listCtrl=(TodoSortController)factory.getCtrl("sort");
        List<TodoResponseDTO> sort=listCtrl.sortTodo();
        return sort;
    }
}
