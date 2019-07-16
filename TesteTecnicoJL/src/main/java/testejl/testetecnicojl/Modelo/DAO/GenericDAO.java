/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testejl.testetecnicojl.Modelo.DAO;

import java.util.List;
import testejl.testetecnicojl.Modelo.VO.Produto;
import testejl.testetecnicojl.Modelo.VO.TipoMovimentacao;

/**
 *
 * @author a1980009
 */
public interface GenericDAO<T> {
    
    boolean save(T objeto);
    
    T listOne(String pkName, long pkValue, Class clazz);
    
    T listOne(String pkName, String pkValue, Class clazz);
    
    T listOne(String pkName, String pkValue, Class clazz, String pkName2, String pkValue2);
       
    List listAll(Class clazz);
    
    public long soma(TipoMovimentacao tm, Produto p);
    
    List listLike(Class clazz, String pkName, String pkValue);
    
    List listAll(Class clazz, String order, int limite, String column);
    
    boolean update(T objeto);
    
    void delete(T objeto);
    
    
}
