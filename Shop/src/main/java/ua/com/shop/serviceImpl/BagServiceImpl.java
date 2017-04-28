package ua.com.shop.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.dao.BagDao;
import ua.com.shop.entity.Bag;
import ua.com.shop.service.BagService;

@Service
public class BagServiceImpl implements BagService {
	
	@Autowired
	private BagDao bagDao;
	

	public List<Bag> findAll() {
		return bagDao.findAll();
	}

	@Transactional
	public void save(Bag bag, MultipartFile image) {
		


		String path = System.getProperty("catalina.home") + "/resources/" + bag.getName() + "/"
				
				+ image.getOriginalFilename();

		

		File file = new File(path);

		try {
			file.mkdirs();
			bagDao.save(bag);
			bag.setBagImage("resources/" + bag.getName() + "/"
					
					+ image.getOriginalFilename());
			image.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}

		
	}

	public Bag findOne(int id) {
		return bagDao.findOne(id);
	}

	public void delete(int id) {
		bagDao.delete(id);
	}

	public List<Bag> liveSearch(String search) {
		return bagDao.liveSearch(search);
	}

	public void save(Bag bag) {
		bagDao.save(bag);
	}

	public List<Bag> bagImges() {
		return bagDao.bagImges();
	}

}
