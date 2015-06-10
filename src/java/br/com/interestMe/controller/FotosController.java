package br.com.interestMe.controller;


import br.com.interestMe.entidade.Foto;
import br.com.interestMe.service.IFotosService;
import br.com.interestMe.util.MensagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("FotosController")
@RequestScoped
public class FotosController {
    @EJB
    private IFotosService FotosService;
    
    private Foto Fotos;
    private Foto FotosSelecionadas;
    
    public FotosController(){
        Fotos = new Foto();
    }
    
    public void salvar(){
        
        String erro = FotosService.salvar(Fotos);
        if(erro == null){ 
            Fotos = new Foto();
            MensagemUtil.addMensagemInfo("Salvo com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao salvar: " + erro);
        }
    }
   
    public void editar(){
        Fotos = FotosSelecionadas;
    }
    
    public void excluir(){
        
        String erro =FotosService
                .excluir(FotosSelecionadas.getIdFoto());
        
        if(erro == null){ //Nao houve erros
            Fotos = new Foto();
            MensagemUtil.addMensagemInfo("Excluido com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao excluir: " + erro);
        }
    }
    public List<Foto> listar(){
        return FotosService.todos();
    }
}
