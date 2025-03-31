import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class JdbcAppMain {
    public static void main(String[] args) {
        JdbcDao dao = new JdbcDao();
        /*TodoRequestDTO request = TodoRequestDTO.builder()
                .title("JDBC Test")
                .content("JDBC")
                .status("N")
                .priority(1)
                .build();
        int result = dao.insertRow(request);*/
        /*Map<String, Object> map = new HashMap<>();
        map.put("title", "Test");
        map.put("content", "Test Content");
        map.put("status", "Y");
        map.put("priority", 1);
        map.put("seq", 2);
        int result = dao.updateRow(map);*/
        //int result = dao.deleteRow(2);
        /*if (result > 0) {
            System.out.println("작업 Success");
        } else {
            System.out.println("작업 Failed");
        }*/
        /*List<TodoResponseDTO> result = dao.selectListRow();
        if (result.isEmpty()!= true) {
            System.out.println("작업 Success");
            for (TodoResponseDTO dto : result) {
                System.out.println(dto);
            }
        } else {
            System.out.println("작업 Failed");
        }
        */
        Optional<TodoResponseDTO> result = dao.selectRow(3);
        if (result.isPresent()) {
            System.out.println("작업 Success");
            System.out.println(result.get());
        } else {
            System.out.println("작업 Failed");
        }
    }   
}
