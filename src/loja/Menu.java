package loja;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import loja.controller.ProdutoController;
import loja.model.ProdutoNovo;
import loja.model.ProdutoUsado;

public class Menu {

	public static void main(String[] args) {

		ProdutoController produtos = new ProdutoController();

		Scanner sc = new Scanner(System.in);

		int opcao, id, quantidade, tipo;
		String nome;
		float preco;

		while (true) {
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("                    LOJA ONLINE                      ");
			System.out.println("-----------------------------------------------------");
			System.out.println("-----------------------------------------------------");
			System.out.println("------------1 - Cadastrar produto--------------------");
			System.out.println("------------2 - Listar todos os Produtos-------------");
			System.out.println("------------3 - Buscar Produto por Id----------------");
			System.out.println("------------4 - Atualizar dados do Produto-----------");
			System.out.println("------------5 - Deletar Produto----------------------");
			System.out.println("------------6 - Adicionar ao Carrinho----------------");
			System.out.println("------------7 - Sair---------------------------------");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("Entre com a opção desejada:                          ");

			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite Valores inteiros!");
				sc.nextLine();
				opcao = 0;
			}

			if (opcao == 7) {
				System.out.println("Agradecemos a preferência, Volte sempre!");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar Produto\n");
				sc.nextLine();
				System.out.println("Digite o nome: ");
				nome = sc.nextLine();
				System.out.println("Digite o tipo: (1-Novo/2-Usado)");
				tipo = sc.nextInt();
				System.out.println("Digite o preço: ");
				preco = sc.nextFloat();
				System.out.println("Digite a quantidade: ");
				quantidade = sc.nextInt();

				switch (tipo) {
				case 1:
					System.out.println("Digite o tempo de Garantia do Fabricante: ");
					int garantiaFabricante = sc.nextInt();
					produtos.cadastrar(
					new ProdutoNovo(produtos.gerarID(), nome, preco, quantidade, tipo, garantiaFabricante));
					break;
				case 2:
					sc.nextLine();
					System.out.println("Digite a duração (Meses/Anos): ");
					String duracao = sc.nextLine();
					System.out.println("Digite a quantidade de (Meses/Anos):");
					int tempoUso = sc.nextInt();

					produtos.cadastrar(
							new ProdutoUsado(produtos.gerarID(), nome, preco, quantidade, tipo, duracao, tempoUso));
					break;
				default:
					System.out.println("tipo do Produto Inválido!");
					
					break;
				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os Produtos\n");
				produtos.listarTodosProdutos();

				break;
			case 3:
				System.out.println("Buscar Produto por ID\n");
				System.out.println("Digite o ID do Produto: ");
				id = sc.nextInt();
				produtos.procurarPorId(id);

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados do Produto\n");

				System.out.println("Digite o número do Produto:");
				id = sc.nextInt();

				var acharProduto = produtos.buscarNaCollection(id);
				if (acharProduto != null) {

					tipo = acharProduto.getTipo();
					sc.nextLine();
					System.out.println("Digite o nome: ");
					nome = sc.nextLine();
					System.out.println("Digite o preço: ");
					preco = sc.nextFloat();
					System.out.println("Digite a quantidade: ");
					quantidade = sc.nextInt();

					switch (tipo) {
					case 1:
						System.out.println("Digite o tempo de Garantia do Fabricante: ");
						int garantiaFabricante = sc.nextInt();
						produtos.atualizar(new ProdutoNovo(id, nome, preco, quantidade, tipo, garantiaFabricante));
						sc.nextLine();
						break;

					case 2:
						System.out.println("Digite a duração (Meses/Anos): ");
						String duracao = sc.next();
						System.out.println("Digite a quantidade de (Meses/Anos):");
						int tempoUso = sc.nextInt();
						produtos.atualizar(new ProdutoUsado(id, nome, preco, quantidade, tipo, duracao, tempoUso));

						break;
					default:
						System.out.println("Tipo de Produto Inválido!");
					}
				}
				
				keyPress();
				break;
			case 5:
				System.out.println("Deletar Produto\n");
				System.out.println("Digite o número do Produto: ");
				id = sc.nextInt();

				produtos.deletar(id);

				keyPress();
				break;
			case 6:
				String continuar = "s";
				do {
					System.out.println("Adicionar ao Carrinho\n");

					System.out.println("Digite o número do Produto que deseja adicionar:");
					id = sc.nextInt();
					var produtoCarrinho = produtos.buscarNaCollection(id);

					System.out.println("Digite a quantidade: ");
					quantidade = sc.nextInt();

					if (produtoCarrinho != null) {
						produtos.adicionarAoCarrinho(produtoCarrinho);

					} else {
						System.out.println("O Produto não foi encontrado!");
					}
					System.out.println("Deseja adicionar outros produtos? (s/n)");
					continuar = sc.next();

				} while (continuar.equals("s"));

				System.out.printf("\nValor Total da Compra: R$%.2f", produtos.totalCompra(quantidade));

				keyPress();
				break;
			default:
				System.out.println("Entre com uma opção válida!\n");

				keyPress();
				break;
			}

		}

	}

	private static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Leonardo Gobetti Borges - leogobettiborges17@hotmail.com");
		System.out.println("https://github.com/Leogb2014");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {

		try {
			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

}
