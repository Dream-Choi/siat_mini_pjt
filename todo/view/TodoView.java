package todo.view;

import java.util.List;
import java.util.Scanner;

import todo.front.FrontController;
import todo.model.domain.TodoResponseDTO;

public class TodoView {
    private FrontController front;
    public TodoView(){
        front =new FrontController();
    }
    public void menu(){
        while (true) {
            
        
            System.out.println("-----Todo Service Menu");
            System.out.println("1. 목록보기 2. 작성 3. 수정 4. 삭제 99. 종료");
            System.out.println("원하는 번호 입력:");
            Scanner scan= new Scanner(System.in);
            int number= scan.nextInt();
            switch (number) {
                case 1:
                    list();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;

                case 99:
                    System.out.println("시스템종료");
                    System.exit(0);
                    break;
            }
        }
    }
    public void list(){
        List<TodoResponseDTO> list= front.list();
        for(TodoResponseDTO response:list){
            System.out.println(response);
        }
        
    }
    public void register(){
        System.out.println("-------Todo register");
        Scanner scan=new Scanner(System.in);
        System.out.print("제목:");
        String title=scan.nextLine();
        System.out.print("내용:");
        String content=scan.nextLine();
        System.out.print("시작일:");
        String startDate=scan.nextLine();
        System.out.print("종료일:");
        String endDate=scan.nextLine();
        System.out.print("우선순위:");
        int priority=scan.nextInt();
        int register=front.register(title,content,startDate,endDate,priority);
        System.out.println(register);
    }
    public void update(){
        System.out.println("-------Todo update");
        Scanner scan=new Scanner(System.in);
        System.out.print("수정할 항목의 번호:");
        int seq=scan.nextInt();
        scan.nextLine();
        System.out.print("제목:");
        String title=scan.nextLine();
        System.out.print("내용:");
        String content=scan.nextLine();
        System.out.print("시작일:");
        String startDate=scan.nextLine();
        System.out.print("종료일:");
        String endDate=scan.nextLine();
        System.out.print("우선순위:");
        int priority=scan.nextInt();
        int update=front.update(seq,title,content,startDate,endDate,priority);
        System.out.println(update);
    }
    public void delete(){
        System.out.println("-------Todo delete");
        Scanner scan=new Scanner(System.in);
        int seq=scan.nextInt();
        int delete=front.delete(seq);
        System.out.println(delete);
    }
}
