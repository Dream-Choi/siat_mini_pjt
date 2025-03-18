package todo.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString

public class TodoResponseDTO {
    private int seq;
    private String title;
    private String content;
    private String startDate;
    private int check;
    private String endDate;
    private int priority;
}
