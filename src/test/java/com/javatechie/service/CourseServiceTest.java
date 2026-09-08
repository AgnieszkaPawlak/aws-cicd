package com.javatechie.service;

import com.javatechie.dto.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseServiceTest {

    private CourseService courseService;

    @BeforeEach
    void setUp() {
        courseService = new CourseService();
    }

    @Test
    void seedsDefaultCourses() {
        List<Course> courses = courseService.getAllCourses();

        assertEquals(3, courses.size());
        assertTrue(courseService.getCourseById(1).isPresent());
        assertEquals("Java Fundamentals", courseService.getCourseById(1).orElseThrow().getName());
    }

    @Test
    void addCourseAppendsToCatalog() {
        courseService.addCourse(new Course(4, "Docker", 149.0));

        assertEquals(4, courseService.getAllCourses().size());
        assertTrue(courseService.getCourseById(4).isPresent());
    }
}
