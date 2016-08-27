package gr.lolo.domain;

import lombok.Getter;

import java.util.Date;

@Getter
public class BaseModel {

    private Date createdAt;
    private Date updatedAt;
}
