
package br.com.interestMe.entidade;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {
    
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idUsuario;
    
    @NotNull(message="Nome")
    private String nome;
    @NotNull(message="usuario")
    private String userName;
    @NotNull(message="email")
    private String email;
    @NotNull(message="senha")
    private String senha;
    
   @ManyToOne
    @JoinColumn(name="idSexo")
    @NotNull(message="Informe o sexo:")
    private Sexo sexo;
   /*
   @OneToMany(mappedBy="idInteressado")
    private List<Interacao> interessados;
   
   @OneToMany(mappedBy="idInteressante")
    private List<Interacao> interessantes;
    */
   
   @OneToMany(mappedBy="usuario")
    private List<Foto> fotos;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

   
}
