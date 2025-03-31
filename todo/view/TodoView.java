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
            try{
                System.out.println("-----Todo Service Menu");
                System.out.println("1. 목록보기 2. 작성 3. 수정 4. 삭제 5. 상세보기 99. 종료");
                System.out.println("원하는 번호 입력:");
                Scanner scan= new Scanner(System.in);
                int number= scan.nextInt();
                switch (number) {
                    case 1:
                        subMenu();
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
                    case 5:
                        read();
                        break;
                    case 99:
                        System.out.println("시스템종료? 맞으면 yes를 입력하세요.");
                        Scanner scan1 =new Scanner(System.in);
                        String n= scan1.nextLine();
                        if (n.equals("yes")){
                            System.exit(0);
                        }
                        break;
                    }
        }catch(Exception e){
            System.out.println("보기에 있는 값만 넣어라.");
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
        System.out.print("완료 여부");
        String status=scan.nextLine();
        System.out.print("종료일:");
        String endDate=scan.nextLine();
        System.out.print("우선순위:");
        int priority=scan.nextInt();
        int update=front.update(seq,title,content,startDate,status,endDate,priority);
        System.out.println(update);
    }
    public void delete(){
        System.out.println("-------Todo delete");
        Scanner scan=new Scanner(System.in);
        int seq=scan.nextInt();
        int delete=front.delete(seq);
        System.out.println(delete);
    }
    public void subMenu(){
        while (true) {
            try{
                System.out.println("-----Todo Service Submenu");
                System.out.println("1. 상세보기 2. 완료된 일정 3. 미완료된 일정 4. 상위메뉴 5. 정렬");
                System.out.println("원하는 번호 입력:");
                Scanner scan= new Scanner(System.in);
                int number= scan.nextInt();
                switch (number) {
                    case 1:
                        list();
                        break;
                    case 2:
                        checkTodo();
                        break;
                    case 3:
                        uncheckTodo();
                        break;
                    case 4:
                        return;
                    case 5:
                        sort();
                        break;
                }
        }catch(Exception e){
            System.out.println("똑바로 입력해라.");
        }
    }
}
    public void read(){
        System.out.println("-------Todo read");
        Scanner scan=new Scanner(System.in);
        System.out.print("상세보기");
        int seq=scan.nextInt();
        TodoResponseDTO response= front.read(seq);
        System.out.println(response);
    }
    public void checkTodo(){
        System.out.println("-------Todo check");
        List<TodoResponseDTO> checkList= front.checkList();
        for(TodoResponseDTO response:checkList){
            System.out.println(response);
        }
    }
    public void uncheckTodo(){
        System.out.println("-------Todo uncheck");
        List<TodoResponseDTO> uncheckList=front.uncheckList();
        for(TodoResponseDTO response:uncheckList){
            System.out.println(response);
        }
    }
    public void sort(){
        System.out.println("------Todo sort");
        List<TodoResponseDTO> list= front.sort();
        for(TodoResponseDTO response:list){
            System.out.println(response);
        }
    }
}
