package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	//List<Course> list;
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
		/*
		 * list = new ArrayList<>(); list.add(new Course(1,"Java","Java Course"));
		 * list.add(new Course(2,"Spring","Spring Course")); list.add(new
		 * Course(3,"Python","Python Course"));
		 */
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		//return list;
		
		return courseDao.findAll();
	}
	
	@Override
	public Course getCourse(long courseId) {
		/*
		 * Course course = null; for(Course c : list) { if(c.getId()==courseId) {
		 * course=c; } }
		 */
		//return course;
		
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		/*
		 * for(Course c : list) { if(c.getId() == course.getId()) {
		 * c.setTitle(course.getTitle()); c.setDescription(course.getDescription()); } }
		 */
		courseDao.save(course);
		
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
		/*
		 * boolean courseremovedFlag = list.removeIf(c -> c.getId()==courseId);
		 * System.out.println("courseremovedFlag == "+courseremovedFlag);
		 */
		
		Course entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
	}

}
