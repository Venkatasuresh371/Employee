package com.org.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.employee.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Integer> {

}
