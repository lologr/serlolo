package gr.lolo.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class BaseModel {

    private Date createdAt;
    private Date updatedAt;

}
