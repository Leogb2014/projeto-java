package loja.model;

public class ProdutoNovo extends Produto{
	
	private int garantiaFabricante;
	
	public ProdutoNovo(int id, String nome, float preco, int quantidade, int tipo, int garantiaFabricante) {
		super(id, nome, preco, quantidade, tipo);
		this.garantiaFabricante = garantiaFabricante;
	}

	public int getGarantiaFabricante() {
		return garantiaFabricante;
	}

	public void setGarantiaFabricante(int garantiaFabricante) {
		this.garantiaFabricante = garantiaFabricante;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Garantia do Fabricante: " + garantiaFabricante + " anos");
		
	}

	

}
