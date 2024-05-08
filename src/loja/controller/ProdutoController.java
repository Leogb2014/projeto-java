package loja.controller;

import java.util.ArrayList;

import loja.model.Produto;
import loja.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository{
	
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	int id = 0;
	
	private ArrayList<Produto> carrinho = new ArrayList<Produto>();
	

	@Override
	public void procurarPorId(int id) {
		var produto = buscarNaCollection(id);
		
		if(produto != null) {
			produto.visualizar();
		}
		else {
			System.out.println("O Produto número: " + id + " não foi encontrado");
		}
		
	}

	@Override
	public void listarTodosProdutos() {
		for(var produto: produtos) {
			produto.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Produto produto) {
		produtos.add(produto);
		System.out.println("Produto cadastrado com sucesso!");
		
	}

	@Override
	public void atualizar(Produto produto) {
		var acharProduto = buscarNaCollection(id);
		
		if(acharProduto != null) {
			produtos.set(produtos.indexOf(acharProduto), produto);
			System.out.println("\nO Produto numero: " + id + " foi atualizado com sucesso!");
		}else
			System.out.println("\nO Produto numero: " + id + " não foi encontrado!");
	
		
	}

	@Override
	public void deletar(int id) {
		var produto = buscarNaCollection(id);
		
		if(produto != null) {
			if(produtos.remove(produto) == true) 
				System.out.println("O Produto número: " + id + " foi deletado com sucesso!");
			
		   }else
			   System.out.println("O Produto número: " + id + " não foi encontrado!");
			
		}
		

	@Override
	public void adicionarAoCarrinho(Produto produto) {
		var produtoCarrinho = buscarNaCollection(id);
		
		if(produtoCarrinho != null) {
			carrinho.add(produto);
			System.out.println("O Produto foi adcionado ao carrinho com sucesso!\n");
		}else
			System.out.println("O Produto número: " + id + " não foi encontrado!\n");
	
	}
	
	public int gerarID() {
		return ++ id;
	}
	
	public Produto buscarNaCollection(int numero) {
		for(var produto : produtos) {
			if(produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}
	
	public float totalCompra(int quantidade) {
		float soma = 0;
		for(Produto p: carrinho) {
			soma += p.getPreco() * quantidade;
		}
		return soma;
	}

}
