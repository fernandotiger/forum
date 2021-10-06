package com.fernando.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.forum.controllers.dto.TopicDto;
import com.fernando.forum.repository.TopicRepository;

@RestController
public class TopicController {

	@Autowired
	private TopicRepository topicRepository;
	
	@RequestMapping("/topics")
	public List<TopicDto> topics(){
		
		return TopicDto.convert(topicRepository.findAll());
	}
}
