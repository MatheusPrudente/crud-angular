package com.angular.crudspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.crudspring.model.Course;
import com.angular.crudspring.repository.CourseRepository;

@RestController
@RequestMapping("/api")

public class CourseController {

	private final CourseRepository courseRepository;

	public CourseController(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@GetMapping(path = { "/courses" })
	public List<Course> list() {
		return courseRepository.findAll();
	}
}
