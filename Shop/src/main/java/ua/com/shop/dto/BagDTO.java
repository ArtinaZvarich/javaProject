package ua.com.shop.dto;

public class BagDTO {
	
	private String name;
	private String element;
	private String fabric;
	private String color;
	private String size;
	private String collection;

	private int price;
	
	public BagDTO() {
		
	}

	public BagDTO(String name, String element, String fabric, String color, String size, String collection, int price) {
		super();
		this.name = name;
		this.element = element;
		this.fabric = fabric;
		this.color = color;
		this.size = size;
		this.collection = collection;
		this.price = price;
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

	@Override
	public String toString() {
		return "BagDTO [name=" + name + ", element=" + element + ", fabric=" + fabric + ", color=" + color + ", size="
				+ size + ", collection=" + collection + ", price=" + price + "]";
	}
	
}
