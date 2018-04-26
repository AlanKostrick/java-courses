package org.wecancodeit.courses;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {

	protected Map<Long, Course> courseList = new HashMap<>();

	public CourseRepository() {
		Course java = new Course(1L, "Java", "Java Description");
		Course javascript = new Course(2L, "Javascript", "Javascript Description");
		Course spring = new Course(3L, "Spring", "Spring Description");

		courseList.put(java.getId(), java);
		courseList.put(javascript.getId(), javascript);
		courseList.put(spring.getId(), spring);
		// populateCoursesMap(java,javascript,spring);
	}

	/**
	 * This constructor is for testing
	 */
	public CourseRepository(Course... courses) {
		populateCoursesMap(courses);
	}

	private void populateCoursesMap(Course... courses) {
		for (Course course : courses) {
			courseList.put(course.getId(), course);
		}
	}

	public Collection<Course> findAll() {
		return courseList.values();
	}

	public Course findOne(Long id) {
		return courseList.get(id);
	}

}
