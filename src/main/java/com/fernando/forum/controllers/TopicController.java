package com.fernando.forum.controllers;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fernando.forum.controllers.dto.TopicDetailDto;
import com.fernando.forum.controllers.dto.TopicDto;
import com.fernando.forum.controllers.form.TopicForm;
import com.fernando.forum.controllers.form.TopicUpdateDto;
import com.fernando.forum.model.Topic;
import com.fernando.forum.repository.CourseRepository;
import com.fernando.forum.repository.TopicRepository;

@RestController
@RequestMapping(value = "/topics")
public class TopicController {

	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping
	public List<TopicDto> topics(String textFilter){
		if(Objects.nonNull(textFilter)) {
			return TopicDto.convert(topicRepository.findByCourseName(textFilter));
		}
		return TopicDto.convert(topicRepository.findAll());
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<TopicDto> save(@RequestBody @Valid TopicForm topicForm, UriComponentsBuilder uriBuilder){
		Topic topic = topicForm.convert(courseRepository);
		topicRepository.save(topic);
		
		URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicDto(topic));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TopicDetailDto> topicDetail(@PathVariable Long id){
		Optional<Topic> optional = topicRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(new TopicDetailDto(optional.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicUpdateDto> updateTopic(@PathVariable Long id, @RequestBody TopicUpdateDto dto){
		Optional<Topic> optional = topicRepository.findById(id);
		if(optional.isPresent()) {
			Topic entity = dto.update(id, topicRepository);
			return ResponseEntity.ok(new TopicUpdateDto(entity));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Topic> optional = topicRepository.findById(id);
		if(optional.isPresent()) {
			topicRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
