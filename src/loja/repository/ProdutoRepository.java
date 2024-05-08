package loja.repository;

import loja.model.Produto;

public interface ProdutoRepository {
	
	public void procurarPorId(int id);
	public void listarTodosProdutos();
	public void cadastrar(Produto produto);
	public void atualizar(Produto Produto);
	public void deletar(int id);
	
	public void adicionarAoCarrinho();

}
