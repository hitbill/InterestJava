package br.com.interestMe.conversor;

import br.com.interestMe.entidade.Gosto;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "gostoConverter",forClass = Gosto.class)
public class GostoConverter implements  Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      
        try{
            if(value == null || value.isEmpty())
                return null;
            
            Short id = Short.valueOf(value);
            
            Gosto gosto = new  Gosto();
            gosto.setIdGosto(id);
            
            return gosto;
        }catch(NumberFormatException e){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       
        if(value == null 
                || !(value instanceof Gosto)){
            return null;
        }
        
        return ((Gosto)value).getIdGosto().toString();
    }
    
}
