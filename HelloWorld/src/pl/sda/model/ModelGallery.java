package pl.sda.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ModelGallery {
	
	private String name;
	private List<Image> images;
	private LocalDate createdDeate;
	
	public ModelGallery(String name){
		this.name = name;
		this.images = new LinkedList<>();
		this.createdDeate = LocalDate.now();
	}
	
	public void addImage(Image image){
		images.add(image);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public LocalDate getCreatedDeate() {
		return createdDeate;
	}
	public void setCreatedDeate(LocalDate createdDeate) {
		this.createdDeate = createdDeate;
	}
	
}
