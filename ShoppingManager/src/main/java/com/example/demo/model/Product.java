package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="product")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message = "name cannot be empty.")
	@Column(name="name")
    private String name;
	
	@Column(name="image_path")
	private String imagePath;

	@NotEmpty(message = "content cannot be empty.")
	@Column(name="content")  
    private String content;
    
	@NotEmpty(message = "author Name cannot be empty.")
    @Column(name="author_name")
    private String authorName;
    
    @Column(name="price")
    private float price;
 
    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public void setId(Long id) {
		this.id = id;
	}
    
    public Long getId() {
        return id;
    }
 }