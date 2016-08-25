package gr.lolo.service;

import gr.lolo.domain.Tag;
import gr.lolo.repository.TagRepository;
import gr.lolo.util.Slugifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private Slugifier slugifier;

    public Tag upsertTag(Tag tag) {
        return upsertTag(tag.getName());
    }

    public Tag upsertTag(String name) {
        Optional<Tag> ingr = tagRepository.findOneByName(name);
        return ingr.orElseGet(() -> {
            Tag newTag = new Tag();
            newTag.setName(name);
            newTag.setSlug(slugifier.slugify(name));
            return tagRepository.save(newTag);
        });
    }
}
