package br.com.interestMe.service.impl;


import br.com.interestMe.entidade.TipoInteracao;
import br.com.interestMe.service.ITipoInteracaoService;
import javax.ejb.Stateless;

@Stateless
public class TipoInteracaoService extends GenericService<TipoInteracao, Integer>
        implements ITipoInteracaoService {
    
    public TipoInteracaoService() {
        super(TipoInteracao.class);
    }
    
}
