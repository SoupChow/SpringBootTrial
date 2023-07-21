package com.springrest.services;

import java.util.List;

import com.springrest.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course course);

}
