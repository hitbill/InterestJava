package br.com.interestMe.controller;

import br.com.interestMe.entidade.Usuario;
import br.com.interestMe.service.IUsuarioService;
import br.com.interestMe.util.MensagemUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("usuarioController")
@RequestScoped
public class UsuarioController {
    @EJB
    private IUsuarioService UsuarioService;
    
    private Usuario usuario;
    private Usuario usuarioSelecionado;
    
    private List<Usuario> usuarios;
    
    public void salvar(){
        
        String erro = UsuarioService.salvar(usuario);
        if(erro == null){ 
            usuario = new Usuario();
            MensagemUtil.addMensagemInfo("Salvo com sucesso!");
        }else{
            MensagemUtil.addMensagemInfo("Erro ao salvar: " + erro);
        }
    }
    
    public void editar(){
        usuario = usuarioSelecionado;
    }
    
    public void excluir(){
        
        String erro = UsuarioService
                .excluir(usuarioSelecionado.getIdUsuario());
        
        if(erro == null){ //Nao houve erros
            usuario = new Usuario();
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
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
