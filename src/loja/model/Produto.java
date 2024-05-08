package loja.model;

public abstract class Produto {
	
	private int id;
	private String nome;
	private float preco;
	private int quantidade;
	private int tipo;
	
	
    public Produto(int id, String nome, float preco, int quantidade, int tipo) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.tipo = tipo;
	}
    
  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void visualizar() {
		
		String tipo = "";
		
		switch(this.tipo) {
		case 1:
			tipo = "Produto Novo";
			break;
		case 2:
			tipo = "Produto Usado";
			break;
		}
		System.out.println("\n\n********************************************");
		System.out.println("Dados do produto:");
		System.out.println("***************************************");
		System.out.println("ID do Produto: " + this.id);
		System.out.println("Nome: " + this.nome);
		System.out.println("Tipo do produto: " + tipo);
		System.out.println("Preco: " + this.preco);
		System.out.println("Quantidade: " + this.quantidade);
		
    }
	

}


