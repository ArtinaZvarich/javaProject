package ua.com.shop.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.entity.Bag;
import ua.com.shop.entity.User;

public interface UserService {
	void save(User user) throws Exception;

    List<User> findAll();

    User findOne(int id);

    void delete(int id);

    void buyBag(Principal principal, String id);

    public void saveImage(Principal principal, MultipartFile multipartFile);

    User fetchUserWithBag(int id);



    User findByUUID(String uuid);

    void update(User user);

    void updateProfile(User user);


    
    // for cookie
    
    public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response);
    
    List<Bag> userBagsCookie(HttpServletRequest request);
    
    public void getOrder(Principal principal, String id, Cookie [] cookies, HttpServletResponse response);
    
    public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response);
    

    void join(int idUser, int idBag);

}
