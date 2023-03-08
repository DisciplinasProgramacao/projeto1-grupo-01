importar  org . junit . Teste ;
importar  org estático  . junit . Afirmar .*;


class  TesteProduto {


	@ Teste
	public  void  testSetPrecoVenda () {
	    Produto  p = novo  Produto ( "Camisa" , 10,0 , 20,0 , 5 , 100,0 , 10 , 8,0 , 1,5 , 50,0 , 5 );
	    pág . setPrecoCusto ( 12.0 );
	    pág . setCustoAquisicao ( 9.0 );
	    pág . setImpostos ();
	    pág . setPrecoVenda ();
	    assertEquals ( 24.42 , p . getPrecoVenda (), 0.01 );
	}


	@ Teste
	public  void  testSetImpostos () {
	    Produto  produto = novo  Produto ( "Camiseta" , 50,00 , 80,00 , 10 , 800,00 , 20 , 40,00 , 0,0 , 50,0 , 10 );
	    produto . setImpostos ();
	    assertEquals ( 29.60 , produto . getImpostos (), 0.001 );
	}



}
