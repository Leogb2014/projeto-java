package loja.model;

public class ProdutoUsado extends Produto{

	private int tempoUso;
	private String tipoDuracao;
	
	public ProdutoUsado(int id, String nome, float preco, int quantidade, int tipo,String tipoduracao, int tempoUso) {
		super(id, nome, preco, quantidade, tipo);
		this.tempoUso = tempoUso;
		this.tipoDuracao = tipoduracao;
		
	}

	public int getTempoUso() {
		return tempoUso;
	}

	public void setTempoUso(int tempoUso) {
		this.tempoUso = tempoUso;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Tempo de Uso do Produto: " + tempoUso + " " + tipoDuracao);
	}
	
	

}
