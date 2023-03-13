import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int resp = scan.nextInt();
		
		
		do {
			switch (resp) {
			case 1: 
				venderProduto(); //retirando do estoque e fazer pedido de produtos para repor o estoque;
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

}
