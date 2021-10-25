package com.fernando.forum.controllers.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.fernando.forum.model.Topic;

public class TopicDetailDto {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime creationDate = LocalDateTime.now();
	
	public TopicDetailDto(Topic topic) {
		this.id = topic.getId();
		this.title = topic.getTitle();
		this.message = topic.getMessage();
		this.creationDate = topic.getCreationDate();
	}
	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getMessage() {
		return message;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	
	public static List<TopicDetailDto> convert(List<Topic> topics){
		return topics.stream().map(TopicDetailDto::new).collect(Collectors.toList());
	}
}
