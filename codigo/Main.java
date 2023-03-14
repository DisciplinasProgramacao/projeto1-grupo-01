import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int resp;
		String str;
		int num;
		
		System.out.println("Primeiramente o estoque e seus produtos devem ser criados");
		System.out.println("Digite a quantidade máxima de produtos que o estoque deve suportar");
		num = scan.nextInt();
		Estoque estoque = new Estoque(num);
		System.out.println("Adicione no mínimo um produto no estoque");
		do {
			Produto p = new Produto();
			System.out.println("Digite o nome do produto");
			str = scan.nextLine();
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
			System.out.println("Digite a margem de lucro do produto (deve estar entre 30 we 80)");
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
		}while(resp == -1);
							
		System.out.println("Agora as funcionalidades do sistema estão liberadas");
		
		do {
			switch (resp) {
			case 1: 
				venderProduto(estoque); //retirando do estoque e fazer pedido de produtos para repor o estoque;
				break;
			case 2:
				consultarDados(); //Consultar dados de produtos individualmente e do estoque como um todo (do segundo enunciado);
				break;
			case 3:
				balancoSimplificado(); //Calcular e exibir um balanço simplificado da empresa: valor do estoque atual, valor vendido e valor gasto
									  //em pedidos de reposição
				break;
			case -1:
				System.out.println("O programa será finalizado");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + resp);
			}
			
			
		}while(resp != -1);

	}
	
	public static void venderProduto(Estoque e) {
		System.out.println("Digite o nome do produto que você busca vender");
		Scanner scan = new Scanner(System.in);
		String resp = scan.nextLine();
		int qnt = scan.nextInt();
		e.venderProduto(resp, qnt );
		
	}

}
