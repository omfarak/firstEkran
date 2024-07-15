package adminNew.firstEkran.controller;

import adminNew.firstEkran.entity.Ogrenci;
import adminNew.firstEkran.service.OgrenciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



import java.util.List;

@Controller
public class OgrenciController {


    @Autowired
    private OgrenciService ogrenciService;



    @GetMapping("/ogrenciler")
    public ModelAndView ogrenciler(){
        List<Ogrenci> list = ogrenciService.getAllOgrenci();
        ModelAndView m = new ModelAndView();
        return new ModelAndView("ogrenciler","ogrenci",list);
    }
    @GetMapping("/addOgrenci")
    public String addOgrenci(){
        return "addOgrenci";
    }
    @GetMapping("/okullar")
    public String okullar(){
        return "okullar";
    }
    @GetMapping("/sinavlar")
    public String sinavlar(){
        return "sinavlar";
    }

    @PostMapping("/save")
    public String ogrenciAdd(@ModelAttribute Ogrenci o, BindingResult result){
//        if (result.hasErrors()) {
//            return "addOgrenci";
//        }
        ogrenciService.save(o);
        return "redirect:/ogrenciler";
    }

    @RequestMapping("/deleteOgrenci/{id}")
    public String deleteMyList(@PathVariable("id") int id){
        ogrenciService.deleteById(id);
        return "redirect:/ogrenciler";
    }

    @RequestMapping("/editOgrenci/{id}")
    public String editMyList(@PathVariable("id") int id, Model model){
        Ogrenci o = ogrenciService.getOgrenciById(id);
        model.addAttribute("ogrenci",o);
        return "ogrenciEdit";
    }

}
