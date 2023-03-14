import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class MainTest {

	//retirando do estoque e fazer pedido de produtos para repor o estoque;;
	@Test
	void testVenderProduto() {
		Estoque estoque = new Estoque(10);

		Produto produto = new Produto();

		estoque.adicionarProduto(produto);
		produto.setQuantidadeEstoque(40, 0);
		produto.setDescricao("Monitor");
		
		
		venderProduto(estoque);

		assertEquals(30, produto.getQuantidadeEstoque());
	}

	public static void venderProduto(Estoque e) {
		System.out.println("Digite o nome do produto que você busca vender");
		Scanner scan = new Scanner(System.in);
		String resp = scan.nextLine();
		System.out.println("Digite a quantidade de produtos que deseja vender");
		int qnt = scan.nextInt();
		e.venderProduto(resp, qnt );
		
	}

	@Test
	void testConsultarDados1(){
		Scanner scanner = new Scanner(System.in);
		Estoque estoque = new Estoque(10);
		Produto produto = new Produto();

		estoque.adicionarProduto(produto);
		produto.setQuantidadeEstoque(40,1);
		produto.setDescricao("eh um produto");
		produto.setMargemLucro(30);
		produto.setPrecoCusto(10);
		produto.setImpostos();
		produto.setCustoAquisicao(10);
		produto.setPrecoVenda();
		produto.setTotalArrecadado();

		consultarDadosProduto();

		assertEquals("Produto: produto/ Quantidade no estoque: 39/ Descricao: eh um produto/ Margem Lucro: 30/ Preco custo: 10/ Custo aquisicao: 10/ Total arrecadado: 30", estoque.consultarDadosProduto());



	}

	@Test
	void testConsultarDados2(){
		Scanner scanner = new Scanner(System.in);
		Estoque estoque = new Estoque(10);

		Produto produto1 = new Produto();
		Produto produto2 = new Produto();

		estoque.adicionarProduto(produto1);
		estoque.adicionarProduto(produto2);
		produto1.setQuantidadeEstoque(40,1);
		produto2.setQuantidadeEstoque(30,0);

		consultarDadosEstoque();

		assertEquals("Produto: produto1, Quantidade no estoque: 39/ Produto: produto2, Quantidade no estoque 29", estoque.consultarDadosEstoque());



	}

}
