package br.com.interestMe.controller;

import br.com.interestMe.entidade.TipoInteracao;
import br.com.interestMe.service.ITipointeracaoService;
import br.com.interestMe.util.MensagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("TipoInteracaoController")
@RequestScoped
public class TipoInteracaoController {
    @EJB
    private ITipointeracaoService TipoInteracaoService;
    
    private TipoInteracao TipoInteracao;
    private TipoInteracao TipoInteracaoSelecionado;
    
    private List<TipoInteracao> TipoInteracoes;
    
    public void salvar(){
        
        String erro = TipoInteracaoService.salvar(TipoInteracao);
        if(erro == null){ 
            TipoInteracao = new TipoInteracao();
            MensagemUtil.addMensagemInfo("Salvo com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao salvar: " + erro);
        }
    }
    
    public void editar(){
        TipoInteracao = TipoInteracaoSelecionado;
    }
    
    public void excluir(){
        
        String erro = TipoInteracaoService
                .excluir(TipoInteracaoSelecionado.getIdTipoInteracao());
        
        if(erro == null){ //Nao houve erros
            TipoInteracao = new TipoInteracao();
            MensagemUtil.addMensagemInfo("Excluido com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao excluir: " + erro);
        }
    }
    
    public List<TipoInteracao> listar(){
        return TipoInteracaoService.todos();
    }
}
