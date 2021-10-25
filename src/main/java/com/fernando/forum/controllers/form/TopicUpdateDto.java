package com.fernando.forum.controllers.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fernando.forum.model.Topic;
import com.fernando.forum.repository.TopicRepository;

public class TopicUpdateDto {

	@NotNull
	private Long id;
	
	@NotNull @NotEmpty @Size(min = 5)
	private String title;
	
	@NotNull @NotEmpty @Size(min = 10)
	private String message;
	
	public TopicUpdateDto() {}
	
	public TopicUpdateDto(Topic topic) {
		this.id = topic.getId();
		this.title = topic.getTitle();
		this.message = topic.getMessage();
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
	
	public Topic update(Long id, TopicRepository topicRepository){
		Optional<Topic> optional = topicRepository.findById(id);
		if(optional.isPresent()) {
			optional.get().setMessage(this.message);
			optional.get().setTitle(this.title);
			return optional.get();
		}
		return null;
	}
}
