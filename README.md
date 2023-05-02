[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10074482)
# Gestão de estoque
Sistema simples de gestão de estoque, com cálculo de preço de venda de produtos e atualização/reposição de produtos quando necessário.
- escrito/corrigido por mim (Cleiton)

---

## Nota base do grupo: 9

A nota final, que é individual, se dará pela nota acima, multiplicada por um peso entre 0 e 1 relativo ao acompanhamento semanal do projeto. Lembre-se: não é só a entrega do produto finalizado que importa, é todo o processo de sua construção e as entregas parciais para o “cliente”.

## Comentários

Arquivos Main.java e Estoque.java referem-se as mesmas informações

### Diagrama + aderência das classes ao diagrama: 0,5/2 pontos 
Elementos presentes no diagrama porém incondizentes com a implementação:
- Produto
 id
 nome
 quantidadeMinima
 monitorarEstoque()
 verificarQuantidadeMinimaEstoque()
- Estoque
 Nome incondizente do atributo maxProdutos
 Tipo incondizente do atributo produtos: Produto [ ]
 adicionarId()
 removerProduto() falta parâmetro
 quantidadeProdutos()
 valorTotalEstoque()
 produtosAbaixodoMinimo() - tipo de retorno também incondizente
 reporProduto()
 retirarProduto()



### Requisitos corretamente implementados: 3/6 pontos 
	- produto (preço, estoque) - 1,5 / 2
	Nome da variavel impostos não está intuitivo, ela representa o valor do produto após calculo dos impostos e não o precentual do imposto
	Poderiam ter alinhado várias operações em seguida. Exemplo: ao setar o preço de custo, já chamar automaticamente as demais operações, para os valores que poderiam oscilar, poderiam utilizar a função do random()
	- estoque (valor, abaixo do estoque) - 1,5
	Não é uma boa prática colocar operações de entrada de informações dentro de uma classe que contém as regras de negócio. Ex. venderProduto()
	- sistema (vender, comprar, consultas) - 0/2
	Não construíram o menu

	Observações:
	Poderiam ter criado métodos privados que seriam acessado por meio dos métodos publicos de get e set
	Poderiam ter criado a estrutura organizacional separando código dos testes

### Documentação de código: 3 pontos 
	
	
### Testes (quantidade e qualidade): 2,5/4 pontos 
	- produto: 1,5/2 pontos
	testMonitorarEstoque() com erro - removido parâmetro
	não entendi muito bem o objetivo deste teste
	deveriam testar o caso de falha. Exemplo: descrição menor que 3
	- estoque: 1/2 pontos
	Problemas com nome do arquivo e classe
	A ideia de teste automatizado seria em não precisar interagir com a suite de testes
	Não entendi o objetivo do testRemoverProduto()
	testGetQuantidadeProdutos(), testAdicionarProduto(), testRemoverProduto() exercitam a mesma operação
	

## Alunos integrantes da equipe

* Henrique Santana Diniz
* Lucas Tabosa Guedes
* Vinícius Gonzaga Guilherme
* Diego Machado Cordeiro
* Klaus Leão Teles


## Professores responsáveis

* João Caram Santos de Oliveira
* Cleiton Silva Tavares


