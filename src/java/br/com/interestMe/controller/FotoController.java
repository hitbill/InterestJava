package br.com.interestMe.controller;


import br.com.interestMe.entidade.Foto;
import br.com.interestMe.service.IFotoService;
import br.com.interestMe.util.MensagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
 
@Named("fotoController")
@RequestScoped
public class FotoController {
    @EJB
    private IFotoService FotoService;
    
    private Foto foto;
    private Foto fotoSelecionadas;
    
    public FotoController(){
        foto = new Foto();
    }
    
    public void salvar(){
        
        String erro = FotoService.salvar(foto);
        if(erro == null){ 
            foto = new Foto();
            MensagemUtil.addMensagemInfo("Salvo com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao salvar: " + erro);
        }
    }
   
    public void editar(){
        foto = fotoSelecionadas;
    }
    
    public void excluir(){
        
        String erro =FotoService
                .excluir(fotoSelecionadas.getIdFoto());
        
        if(erro == null){ //Nao houve erros
            foto = new Foto();
            MensagemUtil.addMensagemInfo("Excluido com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao excluir: " + erro);
        }
    }
    public List<Foto> listar(){
        return FotoService.todos();
    }

    public IFotoService getFotoService() {
        return FotoService;
    }

    public void setFotoService(IFotoService FotoService) {
        this.FotoService = FotoService;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public Foto getFotoSelecionadas() {
        return fotoSelecionadas;
    }

    public void setFotoSelecionadas(Foto fotoSelecionadas) {
        this.fotoSelecionadas = fotoSelecionadas;
    }
    
}
