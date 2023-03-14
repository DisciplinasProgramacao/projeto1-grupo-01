import java.util.ArrayList;
import java.util.Scanner;

/**
 * A classe Estoque representa um conjunto de produtos em um armazém.
 * Ela é responsável por gerenciar os produtos e controlar o estoque.
 */
public class Estoque {
	
    /**
     * O tamanho máximo do estoque.
     */
	private int tamanhoMaximo;
	
    /**
     * A lista de produtos armazenados no estoque.
     */
	private ArrayList<Produto> produtos;
	
    /**
     * Construtor que cria um novo estoque com um tamanho máximo especificado.
     * @param tamanhoMaximo O tamanho máximo do estoque.
     */
	public Estoque(int tamanhoMaximo) {
		this.tamanhoMaximo = tamanhoMaximo;
		this.produtos = new ArrayList<Produto>();
	}
	
    /**
     * Retorna a quantidade de produtos atualmente armazenados no estoque.
     * @return produtos.size() Representa a quantidade de produtos no estoque.
     */
	public int getQuantidadeProdutos() {
        return produtos.size();
    }
	
    /**
     * Retorna uma lista de produtos que estão abaixo da quantidade mínima em estoque.
     * @return produtosAbaixoDoMinimo Uma lista de produtos abaixo da quantidade mínima.
     */
	public ArrayList<Produto> getProdutosAbaixoDoMinimo(){
		ArrayList<Produto> produtosAbaixoDoMinimo = new ArrayList<Produto>();
		for(Produto p : produtos) {
			if(p.monitorarEstoque()) {
				produtosAbaixoDoMinimo.add(p);
			}
		}
		return produtosAbaixoDoMinimo;
	}
	
    /**
     * Adiciona um novo produto ao estoque, se houver espaço suficiente.
     * @param novo O novo produto a ser adicionado.
     * @return true se o produto foi adicionado com sucesso, false caso contrário.
     */
	public boolean adicionarProduto(Produto novo) {
		if(produtos.size() < tamanhoMaximo) {
			produtos.add(novo);
			return true;
		}
		else {
			return false;
		}
	}
	
    /**
     * Remove um produto específico do estoque, se ele existir.
     * @param remover O produto a ser removido.
     * @return true se o produto foi removido com sucesso, false caso contrário.
     */
	public boolean removerProduto(String remover) {
		remover = formatarString(remover);
		for(Produto p : produtos) {
			if(formatarString(p.getDescricao()).equals(remover)) {
				produtos.remove(p);
				return true;
			}
		}
		return false;
	}
	
	
	/**
     * Formata uma string especificada para que ela tenha seus caracteres conectados e todos em minúsculo
     * @param str Representa a string que será formatada
     */
	public static String formatarString(String str) {
	    String strSemEspacos = str.replaceAll("\\s+", "");
	    String strMinuscula = strSemEspacos.toLowerCase();
	    
	    return strMinuscula;
	}

	
    /**
     * Atualiza a quantidade adquirida de um produto após uma compra e atualiza a quantidade em estoque.
     * @param produtoComprado O produto comprado.
     * @param quantidadeComprada A quantidade comprada do produto.
     */
	public void comprarProduto(Produto produtoComprado,int quantidadeComprada) {
		int indexProduto = produtos.indexOf(produtoComprado);
		if(indexProduto != -1) {
			Produto produtoAtual = produtos.get(indexProduto);
	        produtoAtual.setQuantidadeAdquirida(produtoAtual.getQuantidadeAdquirida() + quantidadeComprada);
	        produtoAtual.setQuantidadeEstoque(produtoAtual.getQuantidadeAdquirida(), produtoAtual.getQuantidadeVendida());
		}
	}
	
	/**
	* Atualiza a quantidade vendida de um produto e a em estoque
	* @param produtoVendido O produto vendido.
    * @param quantidadeVendida A quantidade vendida do produto
	*/
	public void venderProduto(String produtoVendido, int quantidadeVendida) {
		produtoVendido = formatarString(produtoVendido);
		for(Produto p : produtos) {
	        if (formatarString(produtoVendido).equals(formatarString(p.getDescricao()))) {
	           p.setQuantidadeVendida(p.getQuantidadeVendida() + quantidadeVendida);
	           
	           Scanner scan = new Scanner(System.in);
	           
	           System.out.println("Digite 1 caso quera repor o estoque vendido e 2 caso contrário");
	           int resp = scan.nextInt();
	           
	           if (resp == 1) {
	        	   p.setQuantidadeAdquirida(quantidadeVendida + p.getQuantidadeAdquirida());   
	        	   p.setQuantidadeEstoque(p.getQuantidadeAdquirida(), p.getQuantidadeVendida());
	           }else {
	        	   p.setQuantidadeEstoque(p.getQuantidadeAdquirida(), p.getQuantidadeVendida());
	           }
	           
        	}
        }
    }
	/**
	* Faz o somatório de todos os produtos em estoque 
	* @return o valor de todos os produtos em estoque somados
	*/
	public double getValorTotalEstoque() {
		double valortotal =0;
		for(Produto p: produtos) {
			valortotal += p.getPrecoVenda() * p.getQuantidadeEstoque();
		}
		return valortotal;
	}

	
	
}
