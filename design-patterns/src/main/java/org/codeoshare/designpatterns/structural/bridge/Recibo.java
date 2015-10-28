package org.codeoshare.designpatterns.structural.bridge;

public class Recibo implements Documento {
    private String emissor;
    private String favorecido;
	private double valor;
    
    private GeradorDeArquivo gerador;
    
    public Recibo(String emissor, String favorecido, double valor, GeradorDeArquivo gerador) {
    	this.emissor = emissor;
    	this.favorecido = favorecido;
    	this.valor = valor;
    	this.gerador = gerador;
    }

	public void geraArquivo() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" Recibo : ");
		buffer.append("\n");
		buffer.append(" Empresa: " + this.emissor);
		buffer.append("\n");
		buffer.append(" Cliente: " + this.favorecido);
		buffer.append("\n");
		buffer.append(" Valor: " + this.valor);
		buffer.append("\n");
		this.gerador.gera(buffer.toString());
	}
}
