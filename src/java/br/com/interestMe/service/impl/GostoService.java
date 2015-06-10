package br.com.interestMe.service.impl;


import br.com.interestMe.entidade.Gosto;
import br.com.interestMe.service.IGostoService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GostoService extends GenericService<Gosto, Integer> implements IGostoService{
    @PersistenceContext
    private EntityManager em;
    
    public GostoService() {
        super(Gosto.class);
    }
}
