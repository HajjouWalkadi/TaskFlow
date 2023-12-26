package com.example.taskflow.service;

import com.example.taskflow.entities.Tags;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface TagService {
    List<Tags> getAllTags();
    Tags getTagById(Long id);
    Tags createTag(Tags tag);
    Tags updateTag(Tags tag, Long id);
    void deleteTag(Long id);

    //List<Tags> getAllTagsPaginated(PageRequest pageRequest);
}
