/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cerification.dao;

import java.util.List;

/**
 *
 * @author yassinesalihi
 * @param <T>
 */
public interface IDao <T> {
    
    boolean create (T o);
    boolean delete (T o);
    boolean update (T o);
    T findById (int  id);
    List<T> findAll ();
    
}
