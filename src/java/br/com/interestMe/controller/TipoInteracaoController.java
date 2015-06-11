package br.com.interestMe.controller;

import br.com.interestMe.entidade.TipoInteracao;
import br.com.interestMe.service.ITipoInteracaoService;
import br.com.interestMe.util.MensagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("TipoInteracaoController")
@RequestScoped
public class TipoInteracaoController {
    @EJB
    private ITipoInteracaoService TipoInteracaoService;
    
    private TipoInteracao tipoInteracao;
    private TipoInteracao tipoInteracaoSelecionado;
     
    public TipoInteracaoController(){
        tipoInteracao = new TipoInteracao();
    }
    private List<TipoInteracao> tipoInteracoes;
    
    public void salvar(){
        
        String erro = TipoInteracaoService.salvar(tipoInteracao);
        if(erro == null){ 
            tipoInteracao = new TipoInteracao();
            MensagemUtil.addMensagemInfo("Salvo com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao salvar: " + erro);
        }
    }
    
    public void editar(){
        tipoInteracao = tipoInteracaoSelecionado;
    }
    
    public void excluir(){
        
        String erro = TipoInteracaoService
                .excluir(tipoInteracaoSelecionado.getIdTipoInteracao());
        
        if(erro == null){ //Nao houve erros
            tipoInteracao = new TipoInteracao();
            MensagemUtil.addMensagemInfo("Excluido com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao excluir: " + erro);
        }
    }
    
    public List<TipoInteracao> listar(){
        return TipoInteracaoService.todos();
    }

    public ITipoInteracaoService getTipoInteracaoService() {
        return TipoInteracaoService;
    }

    public void setTipoInteracaoService(ITipoInteracaoService TipoInteracaoService) {
        this.TipoInteracaoService = TipoInteracaoService;
    }

    public TipoInteracao getTipoInteracao() {
        return tipoInteracao;
    }

    public void setTipoInteracao(TipoInteracao tipoInteracao) {
        this.tipoInteracao = tipoInteracao;
    }

    public TipoInteracao getTipoInteracaoSelecionado() {
        return tipoInteracaoSelecionado;
    }

    public void setTipoInteracaoSelecionado(TipoInteracao tipoInteracaoSelecionado) {
        this.tipoInteracaoSelecionado = tipoInteracaoSelecionado;
    }

    public List<TipoInteracao> getTipoInteracoes() {
        return tipoInteracoes;
    }

    public void setTipoInteracoes(List<TipoInteracao> tipoInteracoes) {
        this.tipoInteracoes = tipoInteracoes;
    }

   
}
