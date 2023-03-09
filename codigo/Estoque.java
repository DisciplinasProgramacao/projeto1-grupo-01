import java.util.ArrayList;

public class Estoque {
	private int tamanhoMaximo;
	private ArrayList<Produto> produtos;
	
	public Estoque(int tamanhoMaximo) {
		this.tamanhoMaximo = tamanhoMaximo;
		this.produtos = new ArrayList<Produto>();
	}
	
	public int getQuantidadeProdutos() {
        return produtos.size();
    }
	
	
	public ArrayList<Produto> getProdutosAbaixoDoMinimo(){
		ArrayList<Produto> produtosAbaixoDoMinimo = new ArrayList<Produto>();
		for(Produto p : produtos) {
			if(p.monitorarEstoque()) {
				produtosAbaixoDoMinimo.add(p);
			}
		}
		return produtosAbaixoDoMinimo;
	}
	
	public boolean adicionarProduto(Produto novo) {
		if(produtos.size() < tamanhoMaximo) {
			produtos.add(novo);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean removerProduto(Produto remover) {
		int index = produtos.indexOf(remover);
		if(index >= 0) {
			produtos.remove(index);
			return true;
		}
		return false;
	}
	
	public void comprarProduto(Produto produtoComprado,int quantidadeComprada) {
		int indexProduto = produtos.indexOf(produtoComprado);
		if(indexProduto != -1) {
			Produto produtoAtual = produtos.get(indexProduto);
	        produtoAtual.setQuantidadeAdquirida(produtoAtual.getQuantidadeAdquirida() + quantidadeComprada);
	        produtoAtual.setQuantidadeEstoque(produtoAtual.getQuantidadeAdquirida(), produtoAtual.getQuantidadeVendida());
		}
	}
	
	public void venderProduto(Produto produtoVendido, int quantidadeVendida) {
        int indexProduto = produtos.indexOf(produtoVendido);
        if (indexProduto != -1) {
            Produto produtoAtual = produtos.get(indexProduto);
            produtoAtual.setQuantidadeEstoque(produtoAtual.getQuantidadeAdquirida() ,produtoAtual.getQuantidadeVendida() +quantidadeVendida);
        }
    }
	
	public double getValorTotalEstoque() {
		double valortotal =0;
		for(Produto p: produtos) {
			valortotal += p.getPrecoVenda() * p.getQuantidadeEstoque();
		}
		return valortotal;
	}

	
	
}
