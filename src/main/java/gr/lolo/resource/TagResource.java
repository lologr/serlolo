package gr.lolo.resource;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class TagResource {

    private String id;

    @NotBlank
    private String name;
}
