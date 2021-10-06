package com.fernando.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.forum.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>{

}
