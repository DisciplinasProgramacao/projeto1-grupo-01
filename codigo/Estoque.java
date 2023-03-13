import java.util.ArrayList;

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
     * @return A quantidade de produtos no estoque.
     */
	public int getQuantidadeProdutos() {
        return produtos.size();
    }
	
    /**
     * Retorna uma lista de produtos que estão abaixo da quantidade mínima em estoque.
     * @return Uma lista de produtos abaixo da quantidade mínima.
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
	public boolean removerProduto(Produto remover) {
		int index = produtos.indexOf(remover);
		if(index >= 0) {
			produtos.remove(index);
			return true;
		}
		return false;
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
	public void venderProduto(Produto produtoVendido, int quantidadeVendida) {
        int indexProduto = produtos.indexOf(produtoVendido);
        if (indexProduto != -1) {
            Produto produtoAtual = produtos.get(indexProduto);
            produtoAtual.setQuantidadeEstoque(produtoAtual.getQuantidadeAdquirida() ,produtoAtual.getQuantidadeVendida() +quantidadeVendida);
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
