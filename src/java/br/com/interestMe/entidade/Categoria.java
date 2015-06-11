
package br.com.interestMe.entidade;

import java.util.List;
import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="categoria")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Short idCategoria;
    
    @Column(name="descricao",nullable=false)
    @NotNull(message="Informe:")
    private String descricao; 
    
    @OneToMany(mappedBy="categoria")
    private List<Gosto> gostos;

    public Short getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Short idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Gosto> getGostos() {
        return gostos;
    }

    public void setGostos(List<Gosto> gostos) {
        this.gostos = gostos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.idCategoria != null ? this.idCategoria.hashCode() : 0);
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
        if (this.idCategoria != other.idCategoria && (this.idCategoria == null || !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

   
}
