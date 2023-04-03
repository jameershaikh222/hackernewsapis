package com.jameer.hackernewsapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jameer.hackernewsapis.model.TopStoriesDetails;

public interface StoriesRepository extends JpaRepository<TopStoriesDetails,Integer>{
    
}
