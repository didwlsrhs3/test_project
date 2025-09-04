package net.koreate.vo;

public class ProductVO {

	private int num;			// 상품 번호
	private String name;		// 상품 이름
	private int price;			// 상품 가격
	
	public ProductVO() {
		System.out.println("ProductVO 기본생성자 호출");
	}

	public ProductVO(int num, String name, int price) {
		this.num = num;
		this.name = name;
		this.price = price;
		System.out.println("전체 필드 초기화 생성자 호출");
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		System.out.println("setNum 호출 : " + num);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("setName 호출 : " + name);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		System.out.println("setPrice 호출 : " + price);
	}

	@Override
	public String toString() {
		return "ProductVO [num=" + num + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
