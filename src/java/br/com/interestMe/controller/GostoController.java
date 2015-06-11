package br.com.interestMe.controller;

import br.com.interestMe.entidade.Gosto;
import br.com.interestMe.service.IGostoService;
import br.com.interestMe.util.MensagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("gostoController")
@RequestScoped
public class GostoController {
    @EJB
    private IGostoService gostoService;
    
    private Gosto gosto;
    private Gosto gostoSelecionado;
    
    public GostoController(){
        gosto = new Gosto();
    }
    
    public void salvar(){
        
        String erro = gostoService.salvar(gosto);
        if(erro == null){ 
            gosto = new Gosto();
            MensagemUtil.addMensagemInfo("Salvo com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao salvar: " + erro);
        }
    }
   
    public void editar(){
        gosto = gostoSelecionado;
    }
    
    public void excluir(){
        
        String erro =gostoService
                .excluir(gostoSelecionado.getIdGosto());
        
        if(erro == null){ //Nao houve erros
            gosto = new Gosto();
            MensagemUtil.addMensagemInfo("Excluido com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao excluir: " + erro);
        }
    }
    public List<Gosto> listar(){
        return gostoService.todos();
    }

    public IGostoService getGostoService() {
        return gostoService;
    }

    public void setGostoService(IGostoService gostoService) {
        this.gostoService = gostoService;
    }

    public Gosto getGosto() {
        return gosto;
    }

    public void setGosto(Gosto gosto) {
        this.gosto = gosto;
    }

    public Gosto getGostoSelecionado() {
        return gostoSelecionado;
    }

    public void setGostoSelecionado(Gosto gostoSelecionado) {
        this.gostoSelecionado = gostoSelecionado;
    }
    
}
