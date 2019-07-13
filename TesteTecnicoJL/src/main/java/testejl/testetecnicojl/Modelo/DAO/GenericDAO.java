/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testejl.testetecnicojl.Modelo.DAO;

import java.util.List;

/**
 *
 * @author a1980009
 */
public interface GenericDAO<T> {
    
    boolean save(T objeto);
    
    T listOne(String pkName, int pkValue, Class clazz);
    
    T listOne(String pkName, String pkValue, Class clazz);
    
    T listOne(String pkName, String pkValue, Class clazz, String pkName2, String pkValue2);
       
    List listAll(Class clazz);
    
    List listAll(Class clazz, String order, int limite, String column);
    
    void update(T objeto);
    
    void delete(T objeto);
    
    
}
