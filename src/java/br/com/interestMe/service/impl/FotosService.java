package br.com.interestMe.service.impl;


import br.com.interestMe.entidade.Foto;
import br.com.interestMe.service.IFotosService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FotosService extends GenericService<Foto, Integer> implements IFotosService{

    @PersistenceContext
    private EntityManager em;
    
    public FotosService(Class persistentClass) {
        super(persistentClass);
    }
    
}
