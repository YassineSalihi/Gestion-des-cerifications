/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cerification.dao;

import cerification.beans.User;


/**
 *
 * @author yassinesalihi
 */
public interface IUserDao {
    
    boolean addUser(User user); 
    User findUserByLogin(String login); 
    boolean authenticate(String login, String password); 
    boolean userExists(String login);
    boolean updatePassword(String login, String newPassword);
}
