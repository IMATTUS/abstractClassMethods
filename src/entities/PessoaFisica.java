package entities;

public class PessoaFisica extends Pessoa{

	private Double healthExpenses;
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String name, Double annualIncome, Double healthExpenses) {
		super(name, annualIncome);
		this.healthExpenses = healthExpenses;
	}
	
	public Double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}

	@Override
	public Double taxes() {
		
		double rate=0;
		if(getAnnualIncome()<20000.00) {
			rate=0.15;
		}else {
			rate=0.25;
		}
		
		if(getHealthExpenses() == null) {
			setHealthExpenses(0.0);
		}
		
		return getAnnualIncome()*rate-getHealthExpenses()*0.5;
	}

}
