package es.jsomoza.advancedqualifiers;

import org.springframework.stereotype.Component;

@Component
public class NormalCustomer implements Customer {

	@Override
	public String profile() {
		return "NormalCustomer";
	}

	@Override
	public Double discount() {
		return 0.10d;
	}

}
