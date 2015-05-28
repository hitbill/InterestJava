
package br.com.interestMe.entidade;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Interacao {
    
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idInteracao;
    
    @Temporal(TemporalType.TIME)
    private Date dataHora;
    
  /*@ManyToOne
    @JoinColumn(name="idUsuario")
    @NotNull(message="Informe o usuario 1:")
    private Usuario idInteressado;
  
  @ManyToOne
    @JoinColumn(name="idUsuario")
    @NotNull(message="Informe o usuario 2:")
    private Usuario idInteressante;
*/
   @ManyToOne
    @JoinColumn(name="idTipoInteracao")
    @NotNull(message="Informe o tipo de InTERACÃO:")
    private TipoInteracao tipoInteracao;

    public int getIdInteracao() {
        return idInteracao;
    }

    public void setIdInteracao(int idInteracao) {
        this.idInteracao = idInteracao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public TipoInteracao getTipoInteracao() {
        return tipoInteracao;
    }

    public void setTipoInteracao(TipoInteracao tipoInteracao) {
        this.tipoInteracao = tipoInteracao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idInteracao;
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
        final Interacao other = (Interacao) obj;
        if (this.idInteracao != other.idInteracao) {
            return false;
        }
        return true;
    }

    
   
}
