package gr.lolo.converter;

import gr.lolo.domain.Tag;
import gr.lolo.resource.TagResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TagConverter implements Converter<Tag, TagResource> {

    @Override
    public TagResource convert(Tag source) {
        TagResource resource = new TagResource();

        resource.setId(source.getSlug());
        resource.setName(source.getName());

        return resource;
    }
}
