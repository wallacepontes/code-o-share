package org.codeoshare.designpatterns.creational.prototype;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Campanha implements Prototype<Campanha> {
    private String name;
    private Calendar vencimento;
    private Set<String> palavrasChave;
    
    public Campanha(String name, Calendar vencimento, Set<String> palavrasChave) {
		this.name = name;
		this.vencimento = vencimento;
		this.palavrasChave = palavrasChave;
	}

	public String getName() {
		return name;
	}

	public Calendar getVencimento() {
		return vencimento;
	}

	public Set<String> getPalavrasChave() {
		return palavrasChave;
	}

	public Campanha clone() {
		String nome = "Cópia da campanha: " + this.name;
		Calendar vencimento = (Calendar) this.vencimento.clone();
		Set<String> palavrasChave = new HashSet<String>(this.palavrasChave);
    	Campanha campanha = new Campanha(nome, vencimento, palavrasChave);
    	return campanha;
    }

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("----------------");
		buffer.append("\n");
		buffer.append("Nome da Campanha: ");
		buffer.append(this.name);
		buffer.append("\n");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String format = simpleDateFormat.format(this.vencimento.getTime());
		buffer.append("Vencimento: " + format);
		buffer.append("\n");
		buffer.append("Palavras-chave: \n");
		for(String palavrasChave : this.palavrasChave) {
			buffer.append(" - " + palavrasChave);
			buffer.append("\n");
		}
		buffer.append("--------------");
		buffer.append("\n");
		return buffer.toString();
	}	
}
