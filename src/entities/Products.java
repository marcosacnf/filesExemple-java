package entities;

public class Products {

	private String name;
	private Double price;
	private Integer qtd;
	
	public Products(String name, Double price, Integer qtd) {
		this.name = name;
		this.price = price;
		this.qtd = qtd;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQtd() {
		return qtd;
	}
	
	public double totalValue() {
		return qtd * price;
	}
}
