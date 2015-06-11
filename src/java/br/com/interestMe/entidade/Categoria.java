
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

   
}
