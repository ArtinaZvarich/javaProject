package ua.com.shop.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.entity.BagImage;

public interface BagImageService {

	void save(BagImage bagImage);
    List<BagImage> findAll();
    BagImage findOne(int id);
    void delete(int id);

    void saveImage(int idBag, MultipartFile [] multipartFiles);
}
