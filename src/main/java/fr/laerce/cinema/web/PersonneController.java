package fr.laerce.cinema.web;

import fr.laerce.cinema.dao.ImageManager;
import fr.laerce.cinema.dao.PersonneDao;
import fr.laerce.cinema.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping(value = "/person")
public class PersonneController {
    @Autowired
    PersonneDao personneDao;

/*    @Autowired
    ImageManager imm;*/

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("personnes", personneDao.getAll());
        return "person/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") long id, Model model){
        model.addAttribute("personne", personneDao.getById(id));
        return "person/detail";
    }

    @GetMapping("/mod/{id}")
    public String mod(@PathVariable("id")long id, Model model){
        Personne p = personneDao.getById(id);
        System.out.println(p);
        model.addAttribute("personne", p);
        return "person/form";
    }

    @GetMapping("/add")
    public String add(Model model){
        Personne personne = new Personne();
        model.addAttribute("personne",personne);
        return "person/form";
    }


/*    @PostMapping("/add")
    public String submit(@RequestParam("photo") MultipartFile file, @ModelAttribute Personne personne){
        System.out.println(file.getOriginalFilename()+" --- "+file.getContentType() + " --- "+file.getSize());
        if(file.getContentType().equalsIgnoreCase("image/jpeg")){
            try{
                imm.savePhoto(personne, file.getInputStream());
            } catch (IOException ioe){
                System.out.println("Erreur lecture: "+ioe.getMessage());
            }
        }
        personneDao.save(personne);
        return "redirect:/person/list";
    }*/


    @PostMapping("/add")
    public String submit(@ModelAttribute Personne personne){
        personneDao.save(personne);
        return "redirect:/person/list";
    }

/*    @GetMapping("/del")
    public String remove(Model model){
        Personne personne = new Personne();
        model.addAttribute("personne",personne);
        return "person/formdel";
    }*/

    @GetMapping("/del/{id}")
    public String remove(@PathVariable("id")long id, Model model){
/*        Personne personne = new Personne();
        model.addAttribute("personne",personne);*/
        model.addAttribute("personnedel", personneDao.getById(id));
        personneDao.delete(id);
        System.out.println("personne supprimée: " +  personneDao.getById(id));
        return "person/formdel";
    }

}
