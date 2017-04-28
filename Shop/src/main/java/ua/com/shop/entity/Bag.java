package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import ua.com.shop.entity.BagImage;
import ua.com.shop.entity.User;

@Entity
public class Bag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String element;
	private String fabric;
	private String color;
	private String size;
	private String collection;
	private int price;
	
	private String bagImage;

	@ManyToMany
	@JoinTable(name = "user_bag", joinColumns = @JoinColumn(name = "bag_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;


	@OneToMany(mappedBy = "bag")
	private List<BagImage> bagImages;
	
	public Bag() {
		
	}

	public Bag(String name, String element, String fabric, String color, String size, String collection, int price) {
		super();
		this.name = name;
		this.element = element;
		this.fabric = fabric;
		this.color = color;
		this.size = size;
		this.collection = collection;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBagImage() {
		return bagImage;
	}

	public void setBagImage(String bagImage) {
		this.bagImage = bagImage;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<BagImage> getBagImages() {
		return bagImages;
	}

	public void setBagImages(List<BagImage> bagImages) {
		this.bagImages = bagImages;
	}

}
