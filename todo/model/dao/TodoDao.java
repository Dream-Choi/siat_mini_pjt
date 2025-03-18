package todo.model.dao;

import java.util.ArrayList;
import java.util.List;

import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class TodoDao {
    private List<TodoResponseDTO> list;
    private int i;
    public TodoDao(){
        list= new ArrayList<TodoResponseDTO>();
    }
    //입력
    public int insertRow(TodoRequestDTO request){
        System.out.println("-------dao insertRow");
        TodoResponseDTO response=TodoResponseDTO.builder()
                                    .seq(i++)
                                    .title(request.getTitle())
                                    .content(request.getContent())
                                    .check(0)
                                    .startDate(request.getStartDate())
                                    .endDate(request.getEndDate())
                                    .priority(request.getPriority())
                                    .build();
        list.add(response);
        return 1;
    }

    //상세보기
    public TodoResponseDTO selectRow(int seq){
        System.out.println("-------dao selectDao");
        for(TodoResponseDTO todo:list){
            if(todo.getSeq()==seq){
                return todo;
            }
        }
        return null;
    }

    //삭제
    public int deleteRow(int seq){
        System.out.println("-------dao deleteRow");
        for(TodoResponseDTO todo :list){
            if(todo.getSeq()==seq){
                list.remove(todo);
                System.out.println("삭제됨");
                return 1;
            }
        }
        return 0;
    }
    //수정
    public int updateRow(TodoRequestDTO request) {
        System.out.println("-------dao updateRow");
        for (TodoResponseDTO todo : list) {
            if (todo.getSeq() == request.getSeq()) {
                todo.setTitle(request.getTitle());
                todo.setContent(request.getContent());
                todo.setStartDate(request.getStartDate());
                todo.setEndDate(request.getEndDate());
                todo.setPriority(request.getPriority());
                System.out.println("수정완료");
                return 1;
            }
        }
        return 0;
    }
    //전체보기
    public List<TodoResponseDTO> listRow(){
        System.out.println("-------dao listRow");
        return list;
    }
}