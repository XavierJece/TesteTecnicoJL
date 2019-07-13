
package testejl.testetecnicojl.Modelo.VO;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jece Xavier
 */

@Entity
@Table(name = "tb_produto")
public class Produto {
    
//    Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String drescricao;
    
    @Column(name = "quantidade_minima")
    private double quatidadeMinima;
    
    @Column (name = "data_cadastro")
    private LocalDate dataCadastro;
    
    private double valor;
    
    @OneToMany(mappedBy = "produto", orphanRemoval = false, cascade = CascadeType.PERSIST)
    private List<MovimentoEstoque> movitmentos; 
    
//    Contrutor
    public Produto() {
    }
    
    public Produto(String drescricao, double quatidadeMinima, LocalDate dataCadastro, double valor) {
        this.drescricao = drescricao;
        this.quatidadeMinima = quatidadeMinima;
        this.dataCadastro = dataCadastro;
        this.valor = valor;
    }

    public Produto(long id, String drescricao, double quatidadeMinima, LocalDate dataCadastro, double valor) {
        this.id = id;
        this.drescricao = drescricao;
        this.quatidadeMinima = quatidadeMinima;
        this.dataCadastro = dataCadastro;
        this.valor = valor;
    }
    
    
//    Minhas Funções
//    Gets and Sets

    
    
}
