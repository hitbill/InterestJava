package br.com.interestMe.controller;

import br.com.interestMe.entidade.Usuario;
import br.com.interestMe.service.IUsuarioService;
import br.com.interestMe.util.MensagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("UsuarioController")
@RequestScoped
public class UsuarioController {
    @EJB
    private IUsuarioService UsuarioService;
    
    private Usuario Usuario;
    private Usuario UsuarioSelecionado;
    
    private List<Usuario> Usuarios;
    
    public void salvar(){
        
        String erro = UsuarioService.salvar(Usuario);
        if(erro == null){ 
            Usuario = new Usuario();
            MensagemUtil.addMensagemInfo("Salvo com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao salvar: " + erro);
        }
    }
    
    public void editar(){
        Usuario = UsuarioSelecionado;
    }
    
    public void excluir(){
        
        String erro = UsuarioService
                .excluir(UsuarioSelecionado.getIdUsuario());
        
        if(erro == null){ //Nao houve erros
            Usuario = new Usuario();
            MensagemUtil.addMensagemInfo("Excluido com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao excluir: " + erro);
        }
    }
    
    public List<Usuario> listar(){
        return UsuarioService.todos();
    }
    
    public IUsuarioService getUsuarioService() {
        return UsuarioService;
    }

    public void setUsuarioService(IUsuarioService UsuarioService) {
        this.UsuarioService = UsuarioService;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public Usuario getUsuarioSelecionado() {
        return UsuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario UsuarioSelecionado) {
        this.UsuarioSelecionado = UsuarioSelecionado;
    }

    public List<Usuario> getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(List<Usuario> Usuarios) {
        this.Usuarios = Usuarios;
    }
}
