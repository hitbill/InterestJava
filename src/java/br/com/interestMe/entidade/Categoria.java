
package br.com.interestMe.entidade;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idCategoria;
    
    @NotNull(message="Informe:")
    private String descricao; 
    
    @OneToMany(mappedBy="categoria")
    private List<Gosto> gostos;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idCategoria;
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
        final Categoria other = (Categoria) obj;
        if (this.idCategoria != other.idCategoria) {
            return false;
        }
        return true;
    }

    public List<Gosto> getGostos() {
        return gostos;
    }

    public void setGostos(List<Gosto> gostos) {
        this.gostos = gostos;
    }
    
    
}
