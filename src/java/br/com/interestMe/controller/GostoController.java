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
    private IGostoService GostoService;
    
    private Gosto Gosto;
    private Gosto GostoSelecionado;
    
    public GostoController(){
        Gosto = new Gosto();
    }
    
    public void salvar(){
        
        String erro = GostoService.salvar(Gosto);
        if(erro == null){ 
            Gosto = new Gosto();
            MensagemUtil.addMensagemInfo("Salvo com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao salvar: " + erro);
        }
    }
   
    public void editar(){
        Gosto = GostoSelecionado;
    }
    
    public void excluir(){
        
        String erro =GostoService
                .excluir(GostoSelecionado.getIdGosto());
        
        if(erro == null){ //Nao houve erros
            Gosto = new Gosto();
            MensagemUtil.addMensagemInfo("Excluido com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao excluir: " + erro);
        }
    }
    public List<Gosto> listar(){
        return GostoService.todos();
    }
}
