package com.fernando.forum.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fernando.forum.model.Course;
import com.fernando.forum.model.Topic;
import com.fernando.forum.repository.CourseRepository;

public class TopicForm {

	@NotNull @NotEmpty @Size(min = 5)
	private String title;
	
	@NotNull @NotEmpty @Size(min = 10)
	private String message;
	
	@NotNull @NotEmpty
	private String courseName;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public Topic convert(CourseRepository courseRepository) {
		Course course = courseRepository.findByName(this.courseName);
		Topic topic = new Topic(title, message, course);
		return topic;
	}
}
