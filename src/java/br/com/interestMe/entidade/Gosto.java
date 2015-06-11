
package br.com.interestMe.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Gosto {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Short idGosto;
    
    @NotNull(message="teste")
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name="idCategoria")
    @NotNull(message="Informe a categoria:")
    private Categoria categoria;

    public Short getIdGosto() {
        return idGosto;
    }

    public void setIdGosto(Short idGosto) {
        this.idGosto = idGosto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
