package com.fernando.forum.controllers.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fernando.forum.model.Answer;

public class AnswerDto {

	private Long id;
	
	private String message;
	
	private String author;
	
	private Boolean solved;
	
	public AnswerDto(Answer answer) {
		this.id = answer.getId();
		this.message = answer.getMessage();
		this.solved = answer.getSolved();
		this.author = answer.getAuthor().getName();
	}
	
	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}
	
	public String getAuthor() {
		return author;
	}

	public Boolean getSolved() {
		return solved;
	}

	public static List<AnswerDto> convert(List<Answer> answers){
		return answers.stream().map(AnswerDto::new).collect(Collectors.toList());
	}
}
