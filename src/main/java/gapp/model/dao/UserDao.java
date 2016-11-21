package gapp.model.dao;

import java.util.List;

import javax.servlet.http.HttpSession;
import gapp.model.User;

public interface UserDao {

    User getUser( Integer id );

    List<User> getUsers();
    
    User saveUser(User user);
    
    User getUserByEmail( String email );
    
     User checkLogin(User user,HttpSession session);

	User getStudent(User user);

	User getAdmin(User user);

	User getStaff(User user);
}