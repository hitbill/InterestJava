package br.com.interestMe.controller;

import br.com.interestMe.entidade.Sexo;
import br.com.interestMe.service.ISexoService;
import br.com.interestMe.util.MensagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("SexoController")
@RequestScoped
public class SexoController {
    @EJB
    private ISexoService SexoService;
    
    private Sexo Sexo;
    private Sexo SexoSelecionado;
    
    public SexoController(){
        Sexo = new Sexo();
    }
    
    public void salvar(){
        
        String erro = SexoService.salvar(Sexo);
        if(erro == null){ 
            Sexo = new Sexo();
            MensagemUtil.addMensagemInfo("Salvo com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao salvar: " + erro);
        }
    }
   
    public void editar(){
        Sexo = SexoSelecionado;
    }
    
    public void excluir(){
        
        String erro = SexoService
                .excluir(SexoSelecionado.getIdSexo());
        
        if(erro == null){ //Nao houve erros
            Sexo = new Sexo();
            MensagemUtil.addMensagemInfo("Excluido com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao excluir: " + erro);
        }
    }
    public List<Sexo> listar(){
        return SexoService.todos();
    }
}
