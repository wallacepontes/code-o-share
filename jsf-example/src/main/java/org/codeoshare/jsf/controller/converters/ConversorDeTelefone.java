package org.codeoshare.jsf.controller.converters;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.codeoshare.jsf.model.entities.Telefone;

@FacesConverter(forClass=Telefone.class)
public class ConversorDeTelefone implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		value = value.trim();
		if (!Pattern.matches("[0-9]+\\s+[0-9]+\\s+[0-9-]+", value)) {
			FacesMessage message = new FacesMessage("Número de telefone inválido");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(message);
		}
		String campos[] = value.split("\\s+");
		
		String codigoDoPais = campos[0];
		String codigoDeArea = campos[1];
		String numeroLocal = campos[2].replaceAll("-", "");
		
		Telefone telefone = new Telefone(codigoDoPais, codigoDeArea, numeroLocal);

		return telefone;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Telefone telefone = (Telefone) value;
		return telefone.getCodigoDoPais() 
				+ " " + telefone.getCodigoDeArea()
				+ " " + telefone.getNumeroLocal();
	}
}
