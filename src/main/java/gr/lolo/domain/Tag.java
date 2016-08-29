package gr.lolo.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "slug",
        scope = Recipe.class)
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id", nullable = false)
    private Long tagId;

    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(unique = true)
    private String tag;

    @ManyToMany(mappedBy = "tags")
    private Set<Recipe> recipes = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        return tagId != null ? tagId.equals(tag.tagId) : tag.tagId == null;
    }

    @Override
    public int hashCode() {
        return tagId != null ? tagId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", slug='" + slug + '\'' +
                ", title='" + tag + '\'' +
                ", recipes=" + recipes.stream().map(Recipe::getTitle)
                .collect(Collectors.joining(",")) +
                '}';
    }
}
