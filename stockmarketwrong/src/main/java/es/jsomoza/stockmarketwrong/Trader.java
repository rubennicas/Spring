package es.jsomoza.stockmarketwrong;

import java.util.ArrayList;
import java.util.List;

public class Trader {
	private String name;
	private Double money;
	private Boolean permission;
	private Market market;
	private List<Stock> stocks = new ArrayList<Stock>();

	public Trader(String name, Double money, Boolean permission) {
		this.name = name;
		this.money = money;
		this.permission = permission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public void buy(Double money, String stockName) {
		System.out.println("Trader> Trying to buy: " + stockName);
		if (permission) {
			Stock stock = this.market.buyStock(stockName, this);
			stocks.add(stock);
			this.money -= money;
		} else System.out.println("Trader> Permission denied for " + name);
	}

	public void sell(Double money, String stockName) {
		System.out.println("Trader> Trying to sell: " + stockName);
		if (permission) {
			for (Stock s : stocks) {
				if (s.getName().equals(stockName)) {
					s.setValue(money);
					market.sellStock(s, this);
					stocks.remove(s);
					this.money += money;
					break;
				}
			}
		} else System.out.println("Trader> Permission denied for " + name);
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Boolean getPermission() {
		return permission;
	}

	public void setPermission(Boolean permission) {
		this.permission = permission;
	}

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}

	@Override
	public String toString() {
		return "Trader [name=" + name + ", money=" + money + ", stocks=" + stocks + "]";
	}

}