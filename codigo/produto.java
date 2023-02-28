
public class produto {
	
	private String descricao;
	private double precoCusto;
	private double precoVenda;
	private int quantidadeVendida;
	private double totalArrecadado;
	private int quantidadeAdquirida;
	private double custoAquisicao;
	private double impostos;
	private double margemLucro;
	private int quantidadeEstoque;
	
	
	public produto(String descricao, double precoCusto, double precoVenda, int quantidadeVendida,
			double totalArrecadado, int quantidadeAdquirida, double custoAquisicao, double impostos, double margemLucro, int quantidadeEstoque) {
		super();
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.quantidadeVendida = quantidadeVendida;
		this.totalArrecadado = totalArrecadado;
		this.quantidadeAdquirida = quantidadeAdquirida;
		this.custoAquisicao = custoAquisicao;
		this.impostos = impostos;
		this.margemLucro = margemLucro;
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	public double getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(double margemLucro) {
		
		if(30 < margemLucro && margemLucro < 80 ) {
			throw new IllegalArgumentException("A margem de lucro deve estar entre 30% e 80%.");
		}
		this.margemLucro = (margemLucro/100) * this.getPrecoCusto()	- this.getPrecoCusto() ;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda() {
		this.precoVenda = this.getPrecoCusto() + this.getPrecoCusto() + this.getImpostos();
	}
	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}
	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}
	public double getTotalArrecadado() {
		return totalArrecadado;
	}
	public void setTotalArrecadado(double totalArrecadado) {
		this.totalArrecadado = totalArrecadado;
	}
	public int getQuantidadeAdquirida() {
		return quantidadeAdquirida;
	}
	public void setQuantidadeAdquirida(int quantidadeAdquirida) {
		this.quantidadeAdquirida = quantidadeAdquirida;
	}
	public double getCustoAquisicao() {
		return custoAquisicao;
	}
	public void setCustoAquisicao(double custoAquisicao) {
		this.custoAquisicao = custoAquisicao;
	}
	public double getImpostos() {
		return impostos;
	}
	public void setImpostos() {
		this.impostos = (this.getPrecoCusto() + this.getMargemLucro()) * 1.18;
	}
	
	 public boolean temDescricaoValida() {
	        return this.getDescricao().length() >= 3;
	    }

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque() {
		this.quantidadeEstoque = this.getQuantidadeAdquirida() - this.getQuantidadeVendida();
	}

	 
	 
	 
}
