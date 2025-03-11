package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.controller.BlogController;
import com.model.BlogEntity;
import com.service.BlogService;

@WebMvcTest(BlogController.class)
@AutoConfigureMockMvc
public class BlogControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private BlogService blogService;
	@Test
	public void testCreateBlog() throws Exception {
		BlogEntity blogEntity = new BlogEntity();
		blogEntity.setId(1L);
		blogEntity.setTitle("Core Java");
		blogEntity.setContent("oops");
		BlogEntity savedBlogEntity = blogEntity;
		savedBlogEntity.setId(1L);
		when(this.blogService.createBlog(blogEntity)).thenReturn(savedBlogEntity);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/blogs")
				.content(JsonConverter.asJsonString(blogEntity)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		assertEquals(result.getResponse().getContentAsString(),JsonConverter.asJsonString(savedBlogEntity));
		System.err.println(result.getResponse().getContentAsString());

	}
}