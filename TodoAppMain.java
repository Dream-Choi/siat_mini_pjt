public class TodoAppMain {
    public static void main(String[] args) {
        TodoRequestDTO request= TodoRequestDTO.builder()
                                    .title("씨앗")
                                    .content("잘")
                                    .startDate("2025-03-17")
                                    .endDate("2025-03-21")
                                    .priority(3)
                                    .build();
        //quiz
        //사용자로 부터 입력받은 데이터를 TodoInsertController(insertTodo)에 전달하여
        //TodoService(insertService) ->TodoDao(insertDao)작업을 수행하고
        //실행결과를 반환받는다.
        TodoInsertController controller = new TodoInsertController();
        int result = controller.insertTodo(request);
        System.out.println("Result: " + result);       
        //quiz(상세보기)
        //사용자로부터 입력받은 키를 TodoReadController(selectTodo)전달하여
        //TodoService(selectService)->TodoDao(selectDao)작업수행하고
        //실행결과를 (TodoResponseDTO)를 반환받는다.  
        TodoReadController readCtrl = new TodoReadController();
        TodoResponseDTO response = readCtrl.selectTodo(1);
        System.out.println(response);      
    }
}
