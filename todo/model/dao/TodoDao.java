public class TodoDao {
    public int insertRow(TodoRequestDTO request){
        System.out.println("-------dao insertRow");
        return 0;
    }
    public TodoResponseDTO selectRow(int seq){
        System.out.println("-------dao selectDao");
        return null;
    }
}
