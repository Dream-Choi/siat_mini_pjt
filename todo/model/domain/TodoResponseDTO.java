package todo.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@ToString
@Setter
public class TodoResponseDTO {
    private int seq;
    private String title;
    private String content;
    private String startDate;
    private String status;
    private String endDate;
    private int priority;
}
