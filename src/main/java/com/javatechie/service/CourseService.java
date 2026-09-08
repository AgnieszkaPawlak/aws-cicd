package com.javatechie.service;

import com.javatechie.dto.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final List<Course> courses = new ArrayList<>();

    public CourseService() {
        courses.add(new Course(1, "Java Fundamentals", 199.0));
        courses.add(new Course(2, "Spring Boot", 249.0));
        courses.add(new Course(3, "AWS CI/CD", 299.0));
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getAllCourses() {
        return List.copyOf(courses);
    }

    // Retrieve a course by id
    public Optional<Course> getCourseById(int id) {
        return courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst();
    }

    // Update a course
    public boolean updateCourse(int id, Course newCourse) {
        return getCourseById(id).map(existingCourse -> {
            courses.remove(existingCourse);
            courses.add(newCourse);
            return true;
        }).orElse(false);
    }

    // Delete a course by id
    public boolean deleteCourse(int id) {
        return courses
                .removeIf(course -> course.getId() == id);
    }
}
