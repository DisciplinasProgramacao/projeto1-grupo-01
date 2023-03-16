import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int resp;
		// String str;
		int num;
		
		System.out.println("Primeiramente o estoque e seus produtos devem ser criados");
		System.out.println("Digite a quantidade máxima de produtos que o estoque deve suportar");
		num = scan.nextInt();
        scan.nextLine(); 
        
		Estoque estoque = new Estoque(num);
		System.out.println("Adicione no mínimo um produto no estoque");
		do {
			Produto p = new Produto();
			System.out.println("Digite o nome do produto");
			String str = scan.nextLine();
			p.setDescricao(str);
			System.out.println("Digite o preco de custo do produto");
			num = scan.nextInt();
			p.setPrecoVenda();
			System.out.println("Digite a quantidade adquirida do produto");
			num = scan.nextInt();
			p.setQuantidadeAdquirida(num);
			System.out.println("Digite o custo de aquisição do produto");
			num = scan.nextInt();
			p.setCustoAquisicao(num);
			System.out.println("Digite a margem de lucro do produto (deve estar entre 30 e 80)");
			num = scan.nextInt();
			p.setMargemLucro(num);
			p.setImpostos();
			System.out.println("Digite a quantidade mínima do produto que deve haver no estoque");
			num = scan.nextInt();
			p.setQuantidadeMinima(num);
			p.setQuantidadeEstoque(p.getQuantidadeAdquirida(), p.getQuantidadeVendida());
			estoque.adicionarProduto(p);
			
			System.out.println("Cadastro de produto finalizado, deseja cadastrar outro produto?(1)Sim (-1)Não");
			resp = scan.nextInt();
		}while(resp == 1);
        
		System.out.println("Agora as funcionalidades do sistema estão liberadas");
        System.out.println("Digite:\n1 - Vender Produto \n2- Consultar Produtos no Estoque\n3 - Balança do Empresa\n-1 - Finalizar Programa");
        scan.nextLine();

        int func = scan.nextInt();		
        

		do {
            
			switch (func) {
			case 1: 
				venderProduto(estoque); //retirando do estoque e fazer pedido de produtos para repor o estoque;
				break;
			case 2:
				consultarDados(estoque); //Consultar dados de produtos individualmente e do estoque como um todo (do segundo enunciado);
				break;
			case 3:
				balancoSimplificado(estoque); //Calcular e exibir um balanço simplificado da empresa: valor do estoque atual, valor vendido e valor gasto
									  //em pedidos de reposição
				break;
			case -1:
				System.out.println("O programa será finalizado");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + func);
			}
			

            System.out.println("Digite:\n1 - Vender Produto \n2- Consultar Produtos no Estoque\n3 - Balança do Empresa\n-1 - Finalizar Programa");
            scan.nextLine();
            func = scan.nextInt();		
			
		}while(func != -1);

	}
	
	public static void venderProduto(Estoque e) {
		System.out.println("Digite o nome e quantidade do produto que você quer vender");
		Scanner scan = new Scanner(System.in);
		String resp = scan.nextLine();
		int qnt = scan.nextInt();
		e.venderProduto(resp, qnt );
		
	}

    public static void consultarDados(Estoque e){
        System.out.println("Digite o nome do produto que você busca");
        Scanner scan = new Scanner(System.in);
		String resp = scan.nextLine();

        Produto result = e.informarProduto(resp);

        System.out.println(result.toString());
    }
	public static void balancoSimplificado(Estoque estoque) {
		double acumulaVendido = 0;
		double acumulaPrecoVendido = 0;
		double acumulaGastoReposicao = 0;
		
		for (Produto produto : estoque.produtos) {
			acumulaVendido = produto.getQuantidadeVendida();
			for (int i = 0; i < acumulaVendido; i++) {
				acumulaPrecoVendido += produto.getPrecoVenda();
				acumulaGastoReposicao += produto.getPrecoVenda();
			}
		}
		double totalEstoque = estoque.getValorTotalEstoque();
		System.out.println("Valor total no estoque "+ totalEstoque);
		System.out.println("O valor vendido e "+ acumulaPrecoVendido);
		System.out.println("O valor gasto em reposicao e "+ acumulaGastoReposicao);
	}
}
