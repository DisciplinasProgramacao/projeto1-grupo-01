import java.util.Scanner;


/**
* Esta classe representa um objeto produto com os atributos descricao,preço que foi 
 * comprado o produto, preço de venda do produto, quantidadede produtis vendida, total arrecado
 * com a venda, quantidade adquirida(lucro),custo de aquisição, imposto sobre o produto,margem 
 * de lucro, e quantidade que tem em estoque	
 * @author 1402031
 *
 */


public class Produto {
	
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
	
	/** 
	 * Cria um novo objeto produto com os dados fornecidos */
	
	public Produto() {
		super();
		this.descricao = "Ainda não foi adicionada uma descrição para esse produto" ;
		this.precoCusto = 0.0;
		this.precoVenda = 0.0;
		this.quantidadeVendida = 0;
		this.totalArrecadado = 0.0;
		this.quantidadeAdquirida = 0;
		this.custoAquisicao = 0.0;
		this.impostos = 0.0;
		this.margemLucro = 0.0;
		this.quantidadeEstoque = 0;
	}
	/** 
	 * Retorna a margem de lucro
	 * @return margem de lucro
	 */
	public double getMargemLucro() {
		return margemLucro;
	}

	/**
	 * 
	 * set da margem de lucro
	 * @param percentMargemLucro 
	 */
	public void setMargemLucro(double percentMargemLucro) {
		if(30 > percentMargemLucro || percentMargemLucro > 80 ) {
			throw new IllegalArgumentException("A margem de lucro deve estar entre 30% e 80%.");
		}
		this.margemLucro = (percentMargemLucro/100) * this.getPrecoCusto();
	}

	/**
	 * retorna a decrição do produto
	 * @return 
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * Set da descrição do produto
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
    		if(descricao.length() <= 3) {
        		throw new IllegalArgumentException("A descrição deve ter pelo menos 3 caracteres.");
   		 } else {
        		this.descricao = descricao;
   		 }
	}

	
	/**
	 * Retorna o preço de custo
	 * 
	 * @return o preço de custo
	 */
	public double getPrecoCusto() {
		return precoCusto;
	}
	
	/**
	 * Set o preço de custo
	 * @param precoCusto
	 */
	
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	/**
	 * Retorna o preço de venda
	 * @return o preço de venda
	 */
	public double getPrecoVenda() {
		return precoVenda;
	}
	//mudar precocusto
	public void setPrecoVenda() {
		this.precoVenda = this.getPrecoCusto() + this.getMargemLucro() + this.getImpostos();
	}
	/**
	 * Retorna a quantidade vendida
	 * @return quatidade vendida
	 */
	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}
	/**
	 * Set da quantidade vendida
	 * @param quantidadeVendida
	 */
	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}
	/**
	 * Retorna o total arrecadado
	 * @return o total arrecadado
	 */
	public double getTotalArrecadado() {
		return totalArrecadado;
	}
	/**
	 * Set do total arrecadado
	 * @param totalArrecadado
	 */
	public void setTotalArrecadado(double totalArrecadado) {
		this.totalArrecadado = totalArrecadado;
	}
	/**
	 * quantidade de produtos adquiridos
	 * @return quantidade adquirida
	 */
	public int getQuantidadeAdquirida() {
		return quantidadeAdquirida;
	}
	/**
	 * Set da quantidade de produtos adquiridos
	 * @param quantidadeAdquirida
	 */
	public void setQuantidadeAdquirida(int quantidadeAdquirida) {
		this.quantidadeAdquirida = quantidadeAdquirida;
	}
	/**
	 * Retorna custo de aquisição de produtos
	 * @return o custo de aquisição
	 */
	public double getCustoAquisicao() {
		return custoAquisicao;
	}
	/**
	 * Set do custo de aquisição
	 * @param custoAquisicao
	 */
	public void setCustoAquisicao(double custoAquisicao) {
		this.custoAquisicao = custoAquisicao;
	}
	/**
	 * Retorna os impostos sobre os produtos
	 * @return impostos
	 */
	public double getImpostos() {
		return impostos;
	}
	
	/**
	 * set dos impostos sobre os produtos 
	 */
	public void setImpostos() {
		this.impostos = (this.getPrecoCusto() + this.getMargemLucro()) * 1.18 - (this.getPrecoCusto() + this.getMargemLucro());
	}

	 
	 /**
	  * Retorna a quantidade de produtos no estoque
	  * @return quantidade no estoque
	  */

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	
	public void monitorarEstoque(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite em unidades o estoque mínimo desse produto");
		int n = scanner.nextInt();
		if(n > this.getQuantidadeEstoque()) {
			System.out.println("O produto tem falta no estoque, existindo " + this.getQuantidadeEstoque() + "unidades desse produto no estoque." );
		}else {
			System.out.println("Não está há falta desse produto no estoque, existindo " + this.getQuantidadeEstoque() + "unidades desse produto no estoque.");
		}
	}

	/**
	 * Set da quantidade de produtos no estoque
	 */
	public void setQuantidadeEstoque() {
		this.quantidadeEstoque = this.getQuantidadeAdquirida() - this.getQuantidadeVendida();
	}
}
