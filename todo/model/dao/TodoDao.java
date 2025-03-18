package todo.model.dao;

import java.util.List;

import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class TodoDao {
    //입력
    public int insertRow(TodoRequestDTO request){
        System.out.println("-------dao insertRow");
        return 0;
    }

    //상세보기
    public TodoResponseDTO selectRow(int seq){
        System.out.println("-------dao selectDao");
        return null;
    }

    //삭제
    public int deleteRow(int seq){
        System.out.println("-------dao deleteRow");
        return 0;
    }
    //수정
    public int updateRow(TodoRequestDTO request){
        System.out.println("-------dao updateRow");
        return 0;
    }
    //전체보기
    public List<TodoResponseDTO> listRow(){
        System.out.println("-------dao listRow");
        return null;
    }
}