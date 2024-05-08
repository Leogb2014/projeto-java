package loja;

import java.util.Scanner;

import loja.model.ProdutoNovo;
import loja.model.ProdutoUsado;

public class Menu {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int opcao;
		
		while(true) {
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
		
		    opcao = sc.nextInt();
			
			if(opcao == 7) {
				System.out.println("Agradecemos a preferência, Volte sempre!");
				sobre();
				sc.close();
				System.exit(0);
			}
			
			switch(opcao) {
			case 1:
				System.out.println("Cadastrar Produto\n");
				System.out.println("Digite o id do Produto: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Digite o nome: ");
				String nome = sc.nextLine();
				System.out.println("Digte o tipo: (1-Novo/2-Usado)");
				int tipo = sc.nextInt();
				System.out.println("Digite o preço: ");
				float preco = sc.nextFloat();
				System.out.println("Digte a quantidade: ");
				int quantidade = sc.nextInt();
				if(tipo == 1) {
					System.out.println("Digite o tempo de Garantia do Fabricante: ");
					int garantiaFabricante = sc.nextInt();
					ProdutoNovo pn = new ProdutoNovo(id, nome, preco, quantidade, tipo, garantiaFabricante);
					pn.visualizar();

				}else {
					System.out.println("Digite a duração (Meses/Anos): ");
					String duracao = sc.next();
					System.out.println("Digite a quantidade de (Meses/Anos):");
					int tempoUso = sc.nextInt();
					
					ProdutoUsado pu = new ProdutoUsado(id, nome, preco, quantidade, tipo, duracao, tempoUso);
					pu.visualizar();
				}
				
				break;
			case 2:
				System.out.println("Listar todos os Produtos\n");
				
				break;
			case 3:
				System.out.println("Buscar Produto por Id\n");
				
				break;
			case 4:
				System.out.println("Atualizar dados do Produto\n");
				
				break;
			case 5:
				System.out.println("Deletar Produto\n");
				
				break;
			case 6:
				System.out.println("Adicionar ao Carrinho");
				
				break;
			default:
				System.out.println("Entre com uma opção válida!\n");
				
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

	}


