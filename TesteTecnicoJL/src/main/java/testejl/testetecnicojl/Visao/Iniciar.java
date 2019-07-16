/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testejl.testetecnicojl.Visao;

import testejl.testetecnicojl.Modelo.DAO.ConnectionHibernate;
import testejl.testetecnicojl.Modelo.DAO.GenericDAO;
import testejl.testetecnicojl.Modelo.DAO.GenericDAOImpl;
import testejl.testetecnicojl.Modelo.RN.GenericRN;
import testejl.testetecnicojl.Modelo.VO.MovimentoEstoque;
import testejl.testetecnicojl.Modelo.VO.Produto;
import testejl.testetecnicojl.Modelo.VO.TipoMovimentacao;

/**
 *
 * @author Jece Xavier
 */
public class Iniciar {
    
    public static void main(String[] args) {
        
        
        GenericDAO<MovimentoEstoque> movimentoDAO = new GenericDAOImpl<>();
        GenericRN<Produto> produtoRN = new GenericRN<>();
        
        long entrada, saida, quantidade;
        
        
        for(Produto p : produtoRN.listAll(Produto.class)){
            entrada = movimentoDAO.soma(TipoMovimentacao.ENTRADA, p);
            saida = movimentoDAO.soma(TipoMovimentacao.SAIDA, p);
            quantidade = entrada - saida;
            
            System.err.println(p.getDescricao() + " tem no estoque " + quantidade);
        }
            ConnectionHibernate.close();
        
        
//        TelaHome telaHome = new TelaHome();
//        
//        telaHome.setVisible(true);
//        
        
    }
    
}
