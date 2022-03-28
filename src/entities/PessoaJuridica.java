package entities;

public class PessoaJuridica extends Pessoa {

	private Integer numFuncionarios;
	
	public PessoaJuridica() {
		super();
	}
		
	public PessoaJuridica(String name, Double annualIncome, Integer numFuncionarios) {
		super(name, annualIncome);
		this.numFuncionarios = numFuncionarios;
	}

	public Integer getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(Integer numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	@Override
	public Double taxes() {
		double rate=0;
		
		if(numFuncionarios>10) {
			rate=0.14;
		}else {
			rate=0.16;
		}
		
		return getAnnualIncome()*rate;
	}

}
