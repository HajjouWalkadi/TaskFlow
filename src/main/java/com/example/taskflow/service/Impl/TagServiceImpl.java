package com.example.taskflow.service.Impl;

import com.example.taskflow.entities.Tags;
import com.example.taskflow.repository.TagRepository;
import com.example.taskflow.service.TagService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tags> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tags getTagById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public Tags createTag(Tags tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tags updateTag(Tags tag, Long id) {
        Tags existingTag = getTagById(id);
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    /*@Override
    public List<Tags> getAllTagsPaginated(PageRequest pageRequest) {
        return tagRepository.findAll(pageRequest).getContent();
    }*/
}
