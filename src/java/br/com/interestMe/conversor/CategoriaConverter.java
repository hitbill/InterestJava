package br.com.interestMe.conversor;

import br.com.interestMe.entidade.Categoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="categoriaConverter",
        forClass=Categoria.class)
public class CategoriaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try{
            Short id = Short.parseShort(value);
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(id);
            return categoria; 
        }catch(NumberFormatException ex){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return null;
        }
        if(value instanceof Categoria){
            Categoria categoria = (Categoria) value;
            Short idCategoria = categoria.getIdCategoria();
            return idCategoria.toString();  
        }else{
            return null;
        }
    }
    
    
}
