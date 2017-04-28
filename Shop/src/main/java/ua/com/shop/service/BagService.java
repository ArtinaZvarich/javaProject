package ua.com.shop.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.entity.Bag;

public interface BagService {
	List<Bag> findAll();

	void save(Bag bag, MultipartFile imge);
	Bag findOne(int id);
	void delete(int id);

	List<Bag> liveSearch(String search);

    void save(Bag bag);

	List<Bag> bagImges();

}
