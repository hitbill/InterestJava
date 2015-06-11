package br.com.interestMe.conversor;

import br.com.interestMe.entidade.Sexo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="sexoConverter",
        forClass=Sexo.class)
public class SexoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try{
            Integer id = Integer.parseInt(value);
            Sexo sexo = new Sexo();
            sexo.setIdSexo(id);
            return sexo; 
        }catch(NumberFormatException ex){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return null;
        }
        if(value instanceof Sexo){
            Sexo sexo = (Sexo) value;
            Integer idSexo = sexo.getIdSexo();
            return idSexo.toString();  
        }else{
            return null;
        }
    }
    
    
}
