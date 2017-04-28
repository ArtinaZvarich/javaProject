package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Bag;


public interface BagDao extends JpaRepository<Bag, Integer> {

    @Query("select b from Bag b where b.name LIKE CONCAT('%',:search,'%')")
    List<Bag> liveSearch(@Param("search") String search);

    @Query("select b from Bag b left join fetch b.bagImages where b.id =:id")
    Bag bagWithimages(@Param("id") int id);

    @Query("select b from Bag b left join fetch b.bagImages")
    List<Bag> bagImges();
    
    
/////////////////////
   

}
