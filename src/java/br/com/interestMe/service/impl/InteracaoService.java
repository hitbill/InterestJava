package br.com.interestMe.service.impl;


import br.com.interestMe.entidade.Interacao;
import br.com.interestMe.service.IInteracaoService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class InteracaoService extends GenericService<Interacao, Integer> implements IInteracaoService{

    @PersistenceContext
    private EntityManager em;
    
    public InteracaoService(Class persistentClass) {
        super(persistentClass);
    }
    
}
