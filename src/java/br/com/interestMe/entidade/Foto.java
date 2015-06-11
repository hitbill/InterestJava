
package br.com.interestMe.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Foto {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idFoto;
    
    //CAMINHO REFERENTE A URL DA FOTO
    private String caminho;
    
    
    
  @ManyToOne
    @JoinColumn(name="idUsuario")
    @NotNull(message="Informe o usuario:")
    private Usuario usuario;

   

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.idFoto;
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
        final Foto other = (Foto) obj;
        if (this.idFoto != other.idFoto) {
            return false;
        }
        return true;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }
  
}
