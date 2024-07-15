package adminNew.firstEkran.repository;

import adminNew.firstEkran.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OgrenciRepository extends JpaRepository <Ogrenci,Integer> {

}
