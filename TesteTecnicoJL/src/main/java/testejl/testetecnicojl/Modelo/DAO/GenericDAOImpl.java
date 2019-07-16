 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testejl.testetecnicojl.Modelo.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import testejl.testetecnicojl.Modelo.VO.MovimentoEstoque;
import testejl.testetecnicojl.Modelo.VO.Produto;
import testejl.testetecnicojl.Modelo.VO.TipoMovimentacao;

/**
 *
 * @author a1980009
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {
   
    EntityManager manager;
    
    public GenericDAOImpl(){
        manager = ConnectionHibernate.getInstance();
    }

    @Override
    public boolean save(T objeto) {
        try {
            manager.getTransaction().begin();
            manager.persist(objeto);
            manager.getTransaction().commit();
            
            return true;
        } catch (PersistenceException e) {
            JOptionPane.showMessageDialog(null, "Erro!\n Dado já cadastrado.", "Falha :(", 0,new ImageIcon(getClass().getResource("/icones/errado.png")));
            manager.getTransaction().rollback();
            return false;
        }catch (Exception e){
             JOptionPane.showMessageDialog(null, "Erro: \n " + e, "Falha :(", 0,new ImageIcon(getClass().getResource("/icones/errado.png")));
             manager.getTransaction().rollback();
             return false;
        }
    }

    @Override
    public T listOne(String pkName, long pkValue, Class clazz) {
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " t WHERE t." + pkName + "=" + pkValue; //Posso colocar "SELECT t FROM TB_" + ..
        
        try {
            Query query = this.manager.createQuery(jpql);
            Object obj = query.getSingleResult();
            
            return (T) obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }
        
        return null;
    }
    
    @Override
    public T listOne(String pkName, String pkValue, Class clazz, String pkName2, String pkValue2) {
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " t WHERE t." + pkName + " = :value1 AND t." + pkName2 + " = :value2";
        Query query = this.manager.createQuery(jpql);
        query.setParameter("value1", pkValue);
        query.setParameter("value2", pkValue2);

        Object obj = query.getSingleResult();
        return (T) obj;
    }
    
    @Override
    public T listOne(String pkName, String pkValue, Class clazz) {
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " AS t WHERE t." + pkName + " = " + pkValue;
        Query query = this.manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (T) obj;
    }
    


    @Override
    public List listAll(Class clazz) {
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " t";
        Query query = manager.createQuery(jpql); 
        List<T> obj = query.getResultList();
        return obj;
    }

    @Override
    public boolean update(T objeto) {
        try {
            manager.getTransaction().begin();
            manager.merge(objeto);
            manager.getTransaction().commit();
        } catch (PersistenceException e) {
            manager.getTransaction().rollback();
            return false;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: \n " + e, "Falha :(", 0,new ImageIcon(getClass().getResource("/icones/errado.png")));
            manager.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public void delete(T objeto) {
       manager.getTransaction().begin();
       manager.remove(objeto);
       manager.getTransaction().commit();
    }
   
    @Override
    public List listAll(Class clazz, String order, int limite, String column){
        
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " t ORDER BY  t." + column + " " + order;
        Query query = manager.createQuery(jpql); 
        List<T> obj = query.getResultList();
        return obj;
    }

    @Override
    public List<T> listLike(Class clazz, String pkName, String pkValue) {
        
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " t WHERE  t." + pkName + " LIKE '%" + pkValue + "%'";
        Query query = manager.createQuery(jpql); 
//        query.setParameter("condicao", pkValue);
        
        List<T> obj = query.getResultList();
        return obj;
    }

    @Override
    public long soma(TipoMovimentacao tm, Produto p){
        try {
            String jpql = "SELECT SUM(quantidade) FROM " + MovimentoEstoque.class.getTypeName() 
                + " WHERE tipo_movimentacao = '" + tm.getMovimentacao()
                + "' GROUP BY produto HAVING produto =" +  p.getId();//
            Query query = manager.createQuery(jpql); 
            
            long obj = (long) query.getSingleResult();
            return  obj;
        }catch(NullPointerException e){
            return  0;
        }catch(NoResultException e){
            return  0;
        }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Erro inesperado!\n "+ e, "Falha :(", 0,new ImageIcon(getClass().getResource("/icones/errado.png")));
           return 0; 
        }
        
        
    }
    
}
