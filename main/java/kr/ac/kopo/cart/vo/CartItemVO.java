package kr.ac.kopo.cart.vo;

public class CartItemVO {

	private int cartItemNo;
	private int cartNo;
	private int itemNo;
	private int quantity;
	private String memberId;
	private String itemName;
	private int price;
	private String imagePath;
	private String description;

	public CartItemVO() {
	}

	public int getCartItemNo() {
		return cartItemNo;
	}

	public void setCartItemNo(int cartItemNo) {
		this.cartItemNo = cartItemNo;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CartItemVO [cartItemNo=" + cartItemNo + ", cartNo=" + cartNo + ", itemNo=" + itemNo + ", quantity="
				+ quantity + ", memberId=" + memberId + ", itemName=" + itemName + ", price=" + price + ", imagePath="
				+ imagePath + "]";
	}

}
