package org.wecancodeit.courses;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;


public class CourseControllerTests {

	@InjectMocks
	private CourseController underTest;

	@Mock
	private CourseRepository repository;

	@Mock
	private Course course;

	@Mock
	private Course anotherCourse;

	@Mock
	private Model model;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddSingleCourseToModel() {
		long arbitraryCourseId = 42;
		when(repository.findOne(arbitraryCourseId)).thenReturn(course);

		underTest.findOneCourse(arbitraryCourseId, model);

		verify(model).addAttribute("courses", course);
	}
	
	/**
	 * I might do this in my MockMvc test instead.
	 */
	@Test
	public void shouldReturnSingleCourseView() {
		String templateName = underTest.findOneCourse(42L, model);
		
		assertThat(templateName, is("course"));
	}
	
	@Test
	public void shouldAddAllCoursesToModel() {
		Collection<Course> allCourses = asList(course, anotherCourse);
		when(repository.findAll()).thenReturn(allCourses);
		
		underTest.findAllCourses(model);
		
		verify(model).addAttribute("courses", allCourses);
	}

}
