package com.jameer.hackernewsapis.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jameer.hackernewsapis.model.Comments;
import com.jameer.hackernewsapis.model.Story;
import com.jameer.hackernewsapis.model.TopStoriesDetails;
import com.jameer.hackernewsapis.repository.StoriesRepository;


@Service
public class HackernewsService {
    private static final String GET_TOP_STORIES_LIST_URL = "https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty";
    // private static final String GET_STORY_DETAILS_URL = "https://hacker-news.firebaseio.com/v0/item/";
    private static final String GET_STORY_AND_COMMENT_URL = "https://hacker-news.firebaseio.com/v0/item/%s.json?print=pretty";

    @Autowired 
    RestTemplate restTemplate;

    @Autowired
    StoriesRepository storiesRepository;

@Cacheable(value = "getTop10Stories", key = "'top10stories'")
    public List<TopStoriesDetails> getTopStories(int storyCnt){
        ResponseEntity<Integer[]> allStories = restTemplate.getForEntity(GET_TOP_STORIES_LIST_URL, Integer[].class);
        List<Integer> storyIdList = Arrays.asList(allStories.getBody());
        List<TopStoriesDetails> top10Stories =new ArrayList<>();
        for(int i=0;i<storyCnt;i++){
            ResponseEntity<TopStoriesDetails> responce = restTemplate.getForEntity(String.format(GET_STORY_AND_COMMENT_URL, storyIdList.get(i).toString()),
             TopStoriesDetails.class);
             TopStoriesDetails topStoriesDetails =responce.getBody();
             storiesRepository.save(topStoriesDetails);
             top10Stories.add(topStoriesDetails);
        }
        return top10Stories;
    }

    @Cacheable(value = "comments",key = "'comments'+#storyId")
    public List<Comments> getTopComments(String storyId){
       ResponseEntity<Story> responce = restTemplate.getForEntity(String.format(GET_STORY_AND_COMMENT_URL, storyId),
       Story.class);
        List<Integer> commentIds = responce.getBody().getKids().size()<10?responce.getBody().getKids().subList(0,responce.getBody().getKids().size()):responce.getBody().getKids().subList(0, 10);
        List<Comments> commetsList = new ArrayList<>();
        for (Integer commentId : commentIds) {
            Comments comment = restTemplate.getForEntity(String.format(GET_STORY_AND_COMMENT_URL, commentId.toString()), Comments.class).getBody();
            if (comment != null) {
                commetsList.add(comment);
            }
        }
        return commetsList;

    }
    public List<TopStoriesDetails> getAllSetories(){
        List<TopStoriesDetails> pastStories =storiesRepository.findAll();
        return pastStories;
    }
}
