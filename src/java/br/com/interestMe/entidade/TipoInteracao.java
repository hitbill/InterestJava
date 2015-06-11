
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
public class TipoInteracao {

    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idTipoInteracao;
    
    @NotNull(message="informe a descricao")
    private String descricao;
    
    @OneToMany(mappedBy="tipoInteracao")
    private List<Interacao> interacoes;

    public int getIdTipoInteracao() {
        return idTipoInteracao;
    }

    public void setIdTipoInteracao(int idTipoInteracao) {
        this.idTipoInteracao = idTipoInteracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Interacao> getInteracoes() {
        return interacoes;
    }

    public void setInteracoes(List<Interacao> interacoes) {
        this.interacoes = interacoes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.idTipoInteracao;
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
        final TipoInteracao other = (TipoInteracao) obj;
        if (this.idTipoInteracao != other.idTipoInteracao) {
            return false;
        }
        return true;
    }

   
    
}
