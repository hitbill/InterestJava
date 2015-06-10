package br.com.interestMe.service.impl;

import br.com.interestMe.entidade.Sexo;
import br.com.interestMe.service.ISexoService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SexoService extends GenericService<Sexo, Integer> implements ISexoService{

    @PersistenceContext
    private EntityManager em;
    
    public SexoService(Class persistentClass) {
        super(persistentClass);
    }
    
}
