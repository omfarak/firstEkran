package adminNew.firstEkran.service;

import adminNew.firstEkran.entity.Ogrenci;
import adminNew.firstEkran.repository.OgrenciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OgrenciService {

    @Autowired
    private OgrenciRepository oRepo;

    public void save(Ogrenci o){
        oRepo.save(o);
    }

    public List<Ogrenci> getAllOgrenci(){
        return oRepo.findAll();
    }

    public void deleteById(int id){
        oRepo.deleteById(id);
    }

    public Ogrenci getOgrenciById(int id){
        return oRepo.findById(id).get();
    }
}
