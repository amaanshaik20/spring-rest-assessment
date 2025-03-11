package com.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BlogDTO {
    private Long id;
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;
    @NotBlank(message = "Content cannot be blank")
    @Size(min = 3, max = 200, message = "Content must be between 3 and 200 characters")
    private String content;
	public BlogDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlogDTO(Long id,
			@NotBlank(message = "Title cannot be blank") @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters") String title,
			@NotBlank(message = "Content cannot be blank") @Size(min = 3, max = 200, message = "Content must be between 3 and 200 characters") String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
}

