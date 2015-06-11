package br.com.interestMe.service.impl;


import br.com.interestMe.entidade.Gosto;
import br.com.interestMe.service.IGostoService;
import javax.ejb.Stateless;

@Stateless
public class GostoService extends GenericService<Gosto, Short> implements IGostoService{
    
    public GostoService() {
        super(Gosto.class);
    }
}
