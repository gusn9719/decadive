package kr.ac.kopo.item.vo;

public class ItemVO {

	private int itemNo; // PK
	private String name;
	private int price;
	private String era; // 80s / 90s / 00s
	private String category; // WALL / TECH / ...
	private String imagePath; // 대표 이미지 경로
	private String regDate;
	private String description;

	public ItemVO() {

	}

	public ItemVO(int itemNo, String name, int price, String era, String category, String imagePath, String regDate) {
		this.itemNo = itemNo;
		this.name = name;
		this.price = price;
		this.era = era;
		this.category = category;
		this.imagePath = imagePath;
		this.regDate = regDate;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getEra() {
		return era;
	}

	public void setEra(String era) {
		this.era = era;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ItemVO [itemNo=" + itemNo + ", name=" + name + ", price=" + price + ", era=" + era + ", category="
				+ category + ", imagePath=" + imagePath + ", regDate=" + regDate + ", description=" + description + "]";
	}

}
