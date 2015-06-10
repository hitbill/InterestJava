package br.com.interestMe.controller;

import br.com.interestMe.entidade.Interacao;
import br.com.interestMe.service.IInteracaoService;
import br.com.interestMe.util.MensagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("InteracaoController")
@RequestScoped
public class InteracaoController {
    @EJB
    private IInteracaoService InteracaoService;
    
    private Interacao Interacao;
    private Interacao InteracaoSelecionada;
    
    private List<Interacao> Interacoes;
    
    public void salvar(){
        
        String erro = InteracaoService.salvar(Interacao);
        if(erro == null){ 
            Interacao = new Interacao();
            MensagemUtil.addMensagemInfo("Salvo com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao salvar: " + erro);
        }
    }
    
    public void editar(){
        Interacao = InteracaoSelecionada;
    }
    
    public void excluir(){
        
        String erro = InteracaoService
                .excluir((InteracaoSelecionada.getIdInteresado())&&(InteracaoSelecionada.getIdInteresante());
        
        if(erro == null){ //Nao houve erros
            Interacao = new Interacao();
            MensagemUtil.addMensagemInfo("Excluido com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao excluir: " + erro);
        }
    }
    
    public List<Interacao> listar(){
        return InteracaoService.todos();
    }
}

