package todo.view;

import java.util.Scanner;

import todo.front.FrontController;

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
                    front.list();
                    break;
                case 2:
                    front.register();
                    break;
                case 3:
                    front.update();
                    break;
                case 4:
                    front.delete();
                    break;

                case 99:
                    System.out.println("시스템종료");
                    System.exit(0);
                    break;
            }
        }
    }
}
    /*public void list(){

    }
    public void register(){

    }
    public void update(){

    }
    public void delete(){

    }
*/
