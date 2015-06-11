package br.com.interestMe.service.impl;


import br.com.interestMe.entidade.Usuario;
import br.com.interestMe.service.IUsuarioService;
import javax.ejb.Stateless;

@Stateless
public class UsuarioService extends GenericService<Usuario, Integer>
        implements IUsuarioService {
    
    public UsuarioService() {
        super(Usuario.class);
    }
    
}
