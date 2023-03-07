import org.junit.Test;
import static org.junit.Assert.*;


class TestProduto {


	@Test
	public void testSetPrecoVenda() {
	    Produto p = new Produto("Camisa", 10.0, 20.0, 5, 100.0, 10, 8.0, 1.5, 50.0, 5);
	    p.setPrecoCusto(12.0);
	    p.setCustoAquisicao(9.0);
	    p.setImpostos();
	    p.setPrecoVenda();
	    assertEquals(24.42, p.getPrecoVenda(), 0.01);
	}


	@Test
	public void testSetImpostos() {
	    Produto produto = new Produto("Camiseta", 50.00, 80.00, 10, 800.00, 20, 40.00, 0.0, 50.0, 10);
	    produto.setImpostos();
	    assertEquals(29.60, produto.getImpostos(), 0.001);
	}



}
