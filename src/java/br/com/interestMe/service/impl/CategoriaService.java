package br.com.interestMe.service.impl;

import br.com.interestMe.entidade.Categoria;
import br.com.interestMe.service.ICategoriaService;
import javax.ejb.Stateless;

@Stateless
public class CategoriaService extends GenericService<Categoria, Integer>
        implements ICategoriaService {
    
    public CategoriaService() {
        super(Categoria.class);
    }
    
}