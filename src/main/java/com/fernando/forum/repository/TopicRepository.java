package com.fernando.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.forum.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>{

	public List<Topic> findByCourseName(String textFilter);
}
