
package br.com.interestMe.controller;

import br.com.interestMe.entidade.Categoria;
import br.com.interestMe.service.ICategoriaService;
import br.com.interestMe.util.MensagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("categoriaController")
@RequestScoped
public class CategoriaController {
    @EJB
    private ICategoriaService categoriaService;
    
    private Categoria categoria;
    private Categoria categoriaSelecionada;
    
    public CategoriaController(){
        categoria = new Categoria();
    }
    
    public void salvar(){
        
        String erro = categoriaService.salvar(categoria);
        if(erro == null){ 
            categoria = new Categoria();
            MensagemUtil.addMensagemInfo("Salvo com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao salvar: " + erro);
        }
    }
   
    public void editar(){
        categoria = categoriaSelecionada;
    }
    
    public void excluir(){
        
        String erro = categoriaService
                .excluir(categoriaSelecionada.getIdCategoria());
        
        if(erro == null){ //Nao houve erros
            categoria = new Categoria();
            MensagemUtil.addMensagemInfo("Excluido com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao excluir: " + erro);
        }
    }
    
    public List<Categoria> listar(){
        return categoriaService.todos();
    }

    public ICategoriaService getCategoriaService() {
        return categoriaService;
    }

    public void setCategoriaService(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoriaSelecionada() {
        return categoriaSelecionada;
    }

    public void setCategoriaSelecionada(Categoria categoriaSelecionado) {
        this.categoriaSelecionada = categoriaSelecionado;
    }

    
    
}
