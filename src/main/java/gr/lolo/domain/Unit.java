package gr.lolo.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString(callSuper = true)
public class Unit extends BaseModel {

    @Id
    private String name;

    @Column(name = "slug", nullable = false, unique = true)
    private String slug;
}
