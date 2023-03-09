
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
}
