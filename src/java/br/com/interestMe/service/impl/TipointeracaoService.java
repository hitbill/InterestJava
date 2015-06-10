package br.com.interestMe.service.impl;


import br.com.interestMe.entidade.TipoInteracao;
import br.com.interestMe.service.ITipointeracaoService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class TipointeracaoService extends GenericService<TipoInteracao, Integer> implements ITipointeracaoService{

    @PersistenceContext
    private EntityManager em;
    
    public TipointeracaoService(Class persistentClass) {
        super(persistentClass);
    }
    
}
