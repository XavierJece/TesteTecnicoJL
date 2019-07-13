/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testejl.testetecnicojl.Modelo.VO;

/**
 *
 * @author Jece Xavier
 */
public enum TipoMovimentacao {
    ENTRADA("ENTRADA"),
    SAIDA("SAÍDA");
    
    private String movimentacao;
   
    TipoMovimentacao(String movimentacao) {
        this.movimentacao = movimentacao;
    }
    
    public String getMovimentacao(){
        return movimentacao;
    }
}
