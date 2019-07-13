
package testejl.testetecnicojl.Modelo.VO;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jece Xavier
 */
@Entity
@Table(name = "tb_movimento_estoque")
public class MovimentoEstoque {
    
//    Atritutos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "produto", nullable = true, foreignKey = @ForeignKey(name = "produto_fk"))
    private Produto produto;
    
    @Column(name = "data_movimento")
    private LocalDate dataMovimento;
    
    private double quantidade;
    
    @Column(name = "tipo_movimentacao")
    private String tipoMovimentacao;
    
    
//    Construtor

    public MovimentoEstoque() {
    }

    public MovimentoEstoque(Produto produto, LocalDate dataMovimento, double quantidade, TipoMovimentacao tipoMovimentacao) {
        this.produto = produto;
        this.dataMovimento = dataMovimento;
        this.quantidade = quantidade;
        this.tipoMovimentacao = tipoMovimentacao.getMovimentacao();
    }

    public MovimentoEstoque(long id, Produto produto, LocalDate dataMovimento, double quantidade, TipoMovimentacao tipoMovimentacao) {
        this.id = id;
        this.produto = produto;
        this.dataMovimento = dataMovimento;
        this.quantidade = quantidade;
        this.tipoMovimentacao = tipoMovimentacao.getMovimentacao();
    }
    
//    Minhas Funções
    
//    Gets and Sets

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    

    public LocalDate getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(LocalDate dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipoMovimento() {
        return tipoMovimentacao;
    }

    public void setTipoMovimento(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao.getMovimentacao();
    }
    
    
    
}
