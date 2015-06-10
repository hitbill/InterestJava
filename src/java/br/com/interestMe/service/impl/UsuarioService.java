package br.com.interestMe.service.impl;


import br.com.interestMe.entidade.Usuario;
import br.com.interestMe.service.IUsuarioService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UsuarioService extends GenericService<Usuario, Integer> implements IUsuarioService{
    @PersistenceContext
    private EntityManager em;

    public UsuarioService(Class persistentClass) {
        super(persistentClass);
    }
}