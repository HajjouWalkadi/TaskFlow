package com.example.taskflow.controller;

import com.example.taskflow.entities.Tags;
import com.example.taskflow.handler.response.ResponseMessage;
import com.example.taskflow.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")

public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public ResponseEntity getAllTags() {
        List<Tags> tags = tagService.getAllTags();
        if (tags.isEmpty()) {
            return ResponseMessage.notFound("Tags not found");
        } else {
            return ResponseMessage.ok("Success", tags);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getTagById(@PathVariable Long id) {
        return ResponseMessage.ok("Success", tagService.getTagById(id));
    }

    @PostMapping("/save")
    public ResponseEntity addTag(@RequestBody Tags tag) {
        Tags tag1 = tagService.createTag(tag);
        if (tag1 == null) {
            return ResponseMessage.badRequest("Tag not created");
        } else {
            return ResponseMessage.created("Success", tag1);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTag(@RequestBody Tags tag, @PathVariable Long id) {
        Tags tag1 = tagService.updateTag(tag, id);
        if (tag1 == null) {
            return ResponseMessage.badRequest("Tag not updated");
        } else {
            return ResponseMessage.created("Success", tag1);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return ResponseMessage.ok("Success", null);
    }

 /*   @GetMapping("/paginate")
    public ResponseEntity getAllTagsPaginate(@RequestParam @DefaultValue("0") Integer page, @RequestParam Integer size) {
        List<Tags> tags;
        if (size != null)
            tags = tagService.getAllTagsPaginated(PageRequest.of(page, size));
        else
            tags = tagService.getAllTags();
        if (tags.isEmpty()) {
            return ResponseMessage.notFound("Tags not found");
        } else {
            return ResponseMessage.ok("Success", tags);
        }
    }*/
}
