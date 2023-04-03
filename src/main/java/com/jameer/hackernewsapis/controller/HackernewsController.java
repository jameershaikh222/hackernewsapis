package com.jameer.hackernewsapis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jameer.hackernewsapis.model.Comments;
import com.jameer.hackernewsapis.model.TopStoriesDetails;
import com.jameer.hackernewsapis.service.HackernewsService;

@RestController
public class HackernewsController {
    @Autowired
    HackernewsService hackernewsService;

    @GetMapping("/top-stories")
    public List<TopStoriesDetails> getTop10Stories() {
        return hackernewsService.getTopStories(10);
    }

    @GetMapping("/comments/{storyId}")
    public List<Comments> gettoptenComments(@PathVariable String storyId) {
        return hackernewsService.getTopComments(storyId);
    }

    @GetMapping("/past-stories")
    public List<TopStoriesDetails> getAllPastStories() {
        return hackernewsService.getAllSetories();
    }
}
