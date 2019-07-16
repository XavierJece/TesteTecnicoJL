
package testejl.testetecnicojl.Modelo.VO;

import java.sql.Connection;
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
import javax.persistence.Transient;
import testejl.testetecnicojl.Modelo.DAO.ConnectionHibernate;
import testejl.testetecnicojl.Modelo.RN.GenericRN;

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
    
    @Column(unique = true, nullable = false)
    private String descricao;
    
    @Column(name = "quantidade_minima", nullable = false)
    private int quatidadeMinima;
    
    @Column (name = "data_cadastro", nullable
            = false)
    private LocalDate dataCadastro;
    
    @Column(nullable = false)
    private double valor;
    
    @OneToMany(mappedBy = "produto", orphanRemoval = false, cascade = CascadeType.PERSIST)
    private List<MovimentoEstoque> movitmentos;         
    
    @Transient
    private long quantidade;
    
//    Contrutor
    public Produto() {
    }
    
    public Produto(String descricao, int quatidadeMinima, LocalDate dataCadastro, double valor) {
        this.descricao = descricao;
        this.quatidadeMinima = quatidadeMinima;
        this.dataCadastro = dataCadastro;
        this.valor = valor;
        this.quantidade = 0;
    }

    public Produto(long id, String descricao, int quatidadeMinima, LocalDate dataCadastro, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.quatidadeMinima = quatidadeMinima;
        this.dataCadastro = dataCadastro;
        this.valor = valor;
        this.quantidade = 0;
    }
    
    
//    Minhas Funções
//    Gets and Sets

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuatidadeMinima() {
        return quatidadeMinima;
    }

    public void setQuatidadeMinima(int quatidadeMinima) {
        this.quatidadeMinima = quatidadeMinima;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<MovimentoEstoque> getMovitmentos() {
        return movitmentos;
    }

    public void setMovitmentos(List<MovimentoEstoque> movitmentos) {
        this.movitmentos = movitmentos;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade() {
        GenericRN<MovimentoEstoque> movimentoRN = new GenericRN<>();
        
        long entrada = movimentoRN.soma(TipoMovimentacao.ENTRADA, this);
        long saida = movimentoRN.soma(TipoMovimentacao.SAIDA, this);
        
        this.quantidade = entrada - saida;
//        ConnectionHibernate.close();s
    }
    
    

    @Override
    public String toString() {
        return getDescricao();
    }
    
    

    
    
}
