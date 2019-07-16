/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testejl.testetecnicojl.Modelo.RN;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import testejl.testetecnicojl.Modelo.DAO.GenericDAO;
import testejl.testetecnicojl.Modelo.DAO.GenericDAOImpl;
import testejl.testetecnicojl.Modelo.VO.Produto;
import testejl.testetecnicojl.Modelo.VO.TipoMovimentacao;

/**
 *
 * @author Matheus_CRF
 */
public class GenericRN<T> {
    private GenericDAO genericDAO;
    
    public GenericRN(){
        genericDAO = new GenericDAOImpl();
    }
    
    public boolean save(T objeto){
        return genericDAO.save(objeto);
    }
    
    public void delete(T objeto){
        genericDAO.delete(objeto);
    }
    
    public List<T> listAll(Class clazz){
        return genericDAO.listAll(clazz);
    }
    
    public List listAll(Class clazz, String order, int limite, String column){
        return genericDAO.listAll(clazz, order, limite, column);
    }
    
    public  T findOne(String pkName, String pkValue, Class clazz){
        return (T) genericDAO.listOne(pkName, pkValue, clazz);
    }
    
    public  T findOne(String pkName, long pkValue, Class clazz){
        return (T) genericDAO.listOne(pkName, pkValue, clazz);
    }
    
    public  T findOne(String pkName, String pkValue, Class clazz, String pkName2, String pkValue2){
        return (T) genericDAO.listOne(pkName, pkValue, clazz, pkName2, pkValue2);
    }
    
    public List<T> listLike(Class clazz, String pkName, String pkValue) {
        return genericDAO.listLike(clazz, pkName, pkValue);
    }
    
    public boolean update(T objeto){
        return genericDAO.update(objeto);
    }
    
    public long soma(TipoMovimentacao tm, Produto p){
        return genericDAO.soma(tm, p);
    }

    
}
