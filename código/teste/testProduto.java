import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class testProduto {

    

    @Test
    public void testSetDescricao() {
    	Produto produto = new Produto();
        String descricao = "Produto Teste";
        produto.setDescricao(descricao);
        assertEquals(descricao, produto.getDescricao());
    }

    @Test
    public void testSetMargemLucro() {
    	Produto produto = new Produto();
        double margemLucro = 30;
        double precoCusto = 100;
        produto.setPrecoCusto(precoCusto);
        produto.setMargemLucro(margemLucro);
        assertEquals(30, produto.getMargemLucro(), 0.001);
    }

    @Test
    public void testSetPrecoVenda() {
    	Produto produto = new Produto();
        double custo = 100.0;
        double margemLucro = 30;
        double precoEsperado = 130 * 1.18;
        produto.setPrecoCusto(custo);
        produto.setMargemLucro(margemLucro);
        produto.setImpostos();
        produto.setPrecoVenda();
        assertEquals(precoEsperado, produto.getPrecoVenda(), 0.001);
    }

    @Test
    public void testSetImpostos() {
    	Produto produto = new Produto();
        double custo = 100.0;
        double margemLucro = 30;
        double impostoEsperado = 130 * 1.18 - 130;
        produto.setPrecoCusto(custo);
        produto.setMargemLucro(margemLucro);
        produto.setImpostos();
        assertEquals(impostoEsperado, produto.getImpostos(), 0.001);
    }
    
    @Test
    public void testMonitorarEstoque() {
    	Produto produto = new Produto();
    	produto.setQuantidadeEstoque(50,10);
    	assertEquals(false, produto.monitorarEstoque(30));
    }
}
