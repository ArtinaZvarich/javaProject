package ua.com.shop.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.entity.Role;
import ua.com.shop.dao.BagDao;
import ua.com.shop.dao.UserDao;
import ua.com.shop.validator.Validator;
import ua.com.shop.entity.Bag;
import ua.com.shop.entity.User;
import ua.com.shop.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private BagDao bagDao;

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		System.out.println(userDao.findByName(name));

		return userDao.findByName(name);
	}

	public void save(User user) throws Exception {
		validator.validate(user);

		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
		
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	@Transactional
	public void buyBag(Principal principal, String id) {
		User user = userDao.findOne(Integer.parseInt(principal.getName()));

		Bag bag = bagDao.findOne(Integer.parseInt(id));

		user.getBags().add(bag);
	}

	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {

		User user = userDao.findOne(Integer.parseInt(principal.getName()));

		String path = System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"
				+ multipartFile.getOriginalFilename();

		user.setPathImage("resources/" + user.getName() + "/" + multipartFile.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
	}

	public User fetchUserWithBag(int id) {
		return userDao.fetchUserWithBag(id);
	}

	public User findByUUID(String uuid) {
		return userDao.findByUUID(uuid);
	}

	public void update(User user) {
		userDao.save(user);
		
	}

	public void updateProfile(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response) {
		request.getSession(false);
		Bag bag = bagDao.findOne(id);

		Cookie cookieBag =
				new Cookie(bag.getName(), String.valueOf(bag.getId()));
		cookieBag.setMaxAge(24 * 60 * 60 * 60);
		cookieBag.setHttpOnly(true);
		cookieBag.setPath("/");

		response.addCookie(cookieBag);
		return cookieBag;
	}

	public List<Bag> userBagsCookie(HttpServletRequest request) {
		request.getSession(false);
		List<Bag> bags = new ArrayList<Bag>();
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("JSESSIONID")) {
				
			} else {
				bags.add(bagDao.findOne(Integer.parseInt(cookie.getValue())));
			}
		}
		return bags;
	}

	public void getOrder(Principal principal, String id, Cookie[] cookies, HttpServletResponse response) {
		User user = userDao.fetchUserWithBag(Integer.parseInt(principal.getName()));
		Bag bag = bagDao.findOne(Integer.parseInt(id));
		user.getBags().add(bag);

		sortCookie(cookies, id, response);
	}

	public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
        sortCookie(cookies, id, response);
	}
	
	public void sortCookie(Cookie[] cookies, String id, HttpServletResponse response) {
        for (int i = 0; i < cookies.length; i++) {
            if (id.equals(cookies[i].getValue())) {
                Cookie cookie = new Cookie(cookies[i].getName(), null);
				cookie.setHttpOnly(true);
				cookie.setPath("/");
				cookie.setValue(null);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
	}

	@Transactional
	public void join(int idUser, int idBag) {
		User user = userDao.findOne(idUser);
		Bag bag = bagDao.findOne(idBag);

		user.getBags().add(bag);

	}
	
	public Cookie intoOrder(int id, HttpServletRequest request, HttpServletResponse response) {
		request.getSession(false);
		Bag bag = bagDao.findOne(id);

		Cookie cookieBag =
				new Cookie(bag.getName(), String.valueOf(bag.getId()));
		cookieBag.setMaxAge(24 * 60 * 60 * 60);
		cookieBag.setHttpOnly(true);
		cookieBag.setPath("/");

		response.addCookie(cookieBag);
		return cookieBag;
	}

}
