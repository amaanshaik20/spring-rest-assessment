package com.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.BlogEntity;

public class JsonConverter {

	public static String asJsonString(BlogEntity obj) {

		// Convert to JSON
		ObjectMapper objectMapper = new ObjectMapper();

		String jsonString="";
		try {
			jsonString = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonString;

	}

	public static void main(String[] args) {
		BlogEntity blogEntity = new BlogEntity();
		blogEntity.setTitle("Core Java");
		blogEntity.setContent("oops");
		
		String asJsonString = asJsonString(blogEntity);
		System.out.println(asJsonString);
	}

}
