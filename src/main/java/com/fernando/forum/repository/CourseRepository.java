package com.fernando.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.forum.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

	public Course findByName(String name);
}
