package org.wecancodeit.courses;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class CourseRepositoryTest {

	private CourseRepository underTest;

	private long firstCourseId = 23L;
	private Course firstCourse = new Course(firstCourseId, "first course", "description of first course");

	private long secondCourseId = 86L;
	private Course secondCourse = new Course(secondCourseId, "second course", "description of second course");

	@Test
	public void shouldFindFirstCourse() {
		underTest = new CourseRepository(firstCourse);

		Course result = underTest.findOne(firstCourseId);

		assertThat(result, is(firstCourse));
	}

	@Test
	public void shouldFindSecondCourse() {
		underTest = new CourseRepository(firstCourse, secondCourse); // varargs
		// or... new CourseRepository(Arrays.asList(firstCourse, secondCourse));

		Course result = underTest.findOne(secondCourseId);

		assertThat(result, is(secondCourse));
	}

	@Test
	public void shouldFindAll() {
		underTest = new CourseRepository(firstCourse, secondCourse); // varargs
		// or... new CourseRepository(Arrays.asList(firstCourse, secondCourse));

		Collection<Course> result = underTest.findAll();
		
		assertThat(result, containsInAnyOrder(firstCourse, secondCourse));
	}
}

