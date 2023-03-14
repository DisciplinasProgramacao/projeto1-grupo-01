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
	
	
	//#region ATRIBUTOS
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
	private int quantidadeMinima;
	//#endregion
	
	
	/** 
	 * Cria um novo objeto produto com os dados fornecidos 
	 */
	
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
	 * Retorna a quantidade mínima do produto no estoque
	 * @return quantidadeMinima Representa a quantidade mínima do produto no estoque
	 */
	public int getQuantidadeMinima() {
		return quantidadeMinima;
	}
	
	/**
	 * Set da quantidade mínima no estoque
	 * @param quantidadeMinima Representa a quantidade mínima do produto no estoque
	 */
	public void setQuantidadeMinima(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}
	/** 
	 * Retorna a margem de lucro
	 * @return margemlucro Representa a margem de lucro do produto
	 */
	public double getMargemLucro() {
		return margemLucro;
	}

	/**
	 * Set da margem de lucro.
	 * A margem de lucro deve ser sempre maior que 30 e menor que 80.
	 * @param percentMargemLucro Representa a percentagem da margem de lucro
	 */
	public void setMargemLucro(double percentMargemLucro) {
		if(30 > percentMargemLucro || percentMargemLucro > 80 ) {
			throw new IllegalArgumentException("A margem de lucro deve estar entre 30% e 80%.");
		}
		this.margemLucro = (percentMargemLucro/100) * this.getPrecoCusto();
		setPrecoVenda();
	} 

	/**
	 * Retorna a decrição do produto
	 * @return descricao Representa a descrição do produto
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * Set da descrição do produto.
	 * A descrição deve ter mais que três caracteres
	 * @param descricao Representa a descrição que será inserida no produto
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
	 * @return precoCusto Representa o preço de custo
	 */
	public double getPrecoCusto() {
		return precoCusto;
	}
	
	/**
	 * Método set do preço de custo
	 * @param precoCusto Representa o preço de custo do produto
	 */
	
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	/**
	 * Método get do preco de venda
	 * @return precoVenda Representa o preço de venda do produto
	 */
	public double getPrecoVenda() {
		return precoVenda;
	}
	
	
	/**
	 * Método set do preco de venda, utilizando o preço do custo mais a margem de lucro mais o imposto para calcular o preço da venda
	 */
	public void setPrecoVenda() {
	    this.precoVenda = this.getPrecoCusto() + this.getMargemLucro() + this.getImpostos();
	}

	/**
	 * Retorna a quantidade vendida do produto
	 * @return quantidadeVendida Representa a quantidade vendida pelo produto
	 */
	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}
	/**
	 * Set da quantidade vendida
	 * @param quantidadeVendida Representa a quantidade de produtos vendidos
	 */
	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}
	/**
	 * Retorna o total arrecadado
	 * @return totalArrecadado Representa o total arrecadado
	 */
	public double getTotalArrecadado() {
		return totalArrecadado;
	}
	/**
	 * Set do total arrecadado, sendo esse calculado pela subtração do preço de venda vezes a quantidade vendida menos o preço de custo vezes a quantidades adiquiridas 
	 */
	public void setTotalArrecadado() {
		this.totalArrecadado = this.getPrecoVenda() * this.getQuantidadeVendida() - this.getQuantidadeAdquirida() * this.getCustoAquisicao();
	}
	/**
	 * quantidade de produtos adquiridos
	 * @return quantidadeAdquirida Representa a quantidade de produtos adiquirida
	 */
	public int getQuantidadeAdquirida() {
		return quantidadeAdquirida;
	}
	/**
	 * Set da quantidade de produtos adquiridos
	 * @param quantidadeAdquirida Representa a quantidade de produtos adiquirida
	 */
	public void setQuantidadeAdquirida(int quantidadeAdquirida) {
		this.quantidadeAdquirida = quantidadeAdquirida;
	}
	/**
	 * Retorna custo de aquisição de produtos
	 * @return custoAquisicao Representa o custo de aquisição de um produto
	 */
	public double getCustoAquisicao() {
		return custoAquisicao;
	}
	/**
	 * Set do custo de aquisição
	 * @param custoAquisicao Representa o custo de aquisição de um produto
	 */
	public void setCustoAquisicao(double custoAquisicao) {
		this.custoAquisicao = custoAquisicao;
	}
	/**
	 * Retorna os impostos sobre os produtos
	 * @return impostos Representa os impostos de um produto
	 */
	public double getImpostos() {
		return impostos;
	}
	
	/**
	 * set dos impostos sobre os produtos, sendo calculado pela soma do preço de custo mais a margem de lucro multiplicados por 1.18 subtraidos pelo preço de custo + margem de lucro
	 */
	public void setImpostos() {
		this.impostos = (this.getPrecoCusto() + this.getMargemLucro()) * 0.18;
	}

	 
	 /**
	  * Retorna a quantidade de produtos no estoque
	  * @return quantidadeEstoque Representa a quantidade desse produtos no stoque
	  */

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	
	
	/**
	 * Monitora o estoque desse produto para verificar se ele possuí a quantidade mínima de unidades no estoque
	 * @param unidadesMinimas Representa as unidades mínimas que esse produto deve ter no estoque 
	 * @return true Caso o produto tenha falta no estoque 
	 * @return false Caso o produto não tenha falta no estoque
	 */
	
	public boolean monitorarEstoque(){

		int unidadesMinimas =  this.getQuantidadeMinima();
        if(unidadesMinimas > this.getQuantidadeEstoque()) {
            System.out.println("O produto tem falta no estoque, existindo " + this.getQuantidadeEstoque() + "unidades desse produto no estoque." );
            return true;
        }else {
            System.out.println("Não está há falta desse produto no estoque, existindo " + this.getQuantidadeEstoque() + "unidades desse produto no estoque.");
            return false;
        }
    }

	/**
	 * Set da quantidade de produtos no estoque
	 * @param quantidadeAdquirida Representa a quantidade adiquirida do produto no estoque
	 * @param quantidadeVendida Representa a quantidade vendida do produto no estoque
	 */
	
	public void setQuantidadeEstoque(int quantidadeAdquirida,int quantidadeVendida) {
		this.quantidadeAdquirida = quantidadeAdquirida;
	    this.quantidadeVendida = quantidadeVendida;
	    this.quantidadeEstoque = this.quantidadeAdquirida - this.quantidadeVendida;
	}
	
	
}
