package com.angular.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angular.crudspring.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
