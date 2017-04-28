package ua.com.shop.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.entity.Bag;
import ua.com.shop.entity.BagImage;
import ua.com.shop.dao.BagDao;
import ua.com.shop.dao.BagImageDao;
import ua.com.shop.service.BagImageService;

@Service
public class BagImageServiceImpl implements BagImageService {
	
	   @Autowired
	    private BagImageDao bagImageDao;
	    @Autowired
	    private BagDao bagDao;

	public void save(BagImage bagImage) {
		 bagImageDao.save(bagImage);
		
	}

	public List<BagImage> findAll() {
		return bagImageDao.findAll();
	}

	public BagImage findOne(int id) {
		return bagImageDao.findOne(id);
	}

	public void delete(int id) {
		 bagImageDao.delete(id);
		
	}

	public void saveImage(int idBag, MultipartFile[] multipartFiles) {
        Bag bag = bagDao.bagWithimages(idBag);

        for (MultipartFile multipartFile : multipartFiles) {


            String path = System.getProperty("catalina.home") + "/resources/" + bag.getName() + "/"
                    + multipartFile.getOriginalFilename();

            BagImage bagImage = new BagImage("resources/" + bag.getName() + "/"
            		
            		+ multipartFile.getOriginalFilename());

            bagImage.setBag(bag);


            File file = new File(path);

            try {
                file.mkdirs();
                multipartFile.transferTo(file);
            } catch (IOException e) {
                System.out.println("error with file");
            }

            bagImageDao.save(bagImage);
        }
		
	}

}
