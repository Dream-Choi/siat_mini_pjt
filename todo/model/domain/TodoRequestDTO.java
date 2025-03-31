package todo.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString

public class TodoRequestDTO {
    private int seq;
    private String title;
    private String content;
    private String startDate;
    private String status;
    private String endDate;
    private int priority;
}
