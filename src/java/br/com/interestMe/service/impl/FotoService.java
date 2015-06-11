package br.com.interestMe.service.impl;

import br.com.interestMe.entidade.Foto;
import br.com.interestMe.service.IFotoService;
import javax.ejb.Stateless;

@Stateless
public class FotoService extends GenericService<Foto, Integer>
        implements IFotoService {
    
    public FotoService() {
        super(Foto.class);
    }
    
}