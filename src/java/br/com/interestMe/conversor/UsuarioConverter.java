package br.com.interestMe.conversor;

import br.com.interestMe.entidade.Usuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="usuarioConverter",
        forClass=Usuario.class)
public class UsuarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try{
            Integer id = Integer.parseInt(value);
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(id);
            return usuario; 
        }catch(NumberFormatException ex){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return null;
        }
        if(value instanceof Usuario){
            Usuario usuario = (Usuario) value;
            Integer idUsuario = usuario.getIdUsuario();
            return idUsuario.toString();  
        }else{
            return null;
        }
    }
    
    
}
