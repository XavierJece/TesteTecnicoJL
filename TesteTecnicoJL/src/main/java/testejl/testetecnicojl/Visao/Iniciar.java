/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testejl.testetecnicojl.Visao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import testejl.testetecnicojl.Modelo.DAO.ConnectionHibernate;
import testejl.testetecnicojl.Modelo.DAO.GenericDAO;
import testejl.testetecnicojl.Modelo.DAO.GenericDAOImpl;
import testejl.testetecnicojl.Modelo.VO.MovimentoEstoque;
import testejl.testetecnicojl.Modelo.VO.Produto;
import testejl.testetecnicojl.Modelo.VO.TipoMovimentacao;

/**
 *
 * @author Jece Xavier
 */
public class Iniciar {
    
    public static void main(String[] args) {
        
        Produto p1 = new Produto("Nescau", 10, LocalDate.now(), 5.88);
        
        GenericDAO<Produto> pDAO = new GenericDAOImpl<>();
        GenericDAO<MovimentoEstoque> movimentoDAO = new GenericDAOImpl<>();
        
        pDAO.save(p1);
        
//        List<Produto> produtosMovimentados = new ArrayList<>();
//        produtosMovimentados.add(p1);
        
        MovimentoEstoque mov = new MovimentoEstoque(p1, LocalDate.now(), 4, TipoMovimentacao.ENTRADA);
        
        movimentoDAO.save(mov);
        
        ConnectionHibernate.close();
        
        
    }
    
}
