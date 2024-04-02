package ma.xproce.inventoryservice.controllers;



import org.springframework.ui.Model;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.services.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/videos")
@Controller
@RequestMapping("/videos")
public class VideoController {

//    @Autowired
//    private VideoManager videoManager;
//
//    @GetMapping("/videos")
//    public List<Video> getAllVideos() {
//        return videoManager.getAllVideos();
//    }
//
//    @PostMapping("/addVideo")
//    public Video addVideo(@RequestBody Video video) {
//        return videoManager.addVideo(video);
//    }
//
//    @PutMapping("/")
//    public Video updateVideo(@RequestBody Video video) {
//        return videoManager.updateVideo(video);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteVideo(@PathVariable Integer id) {
//        videoManager.deleteVideo(id);
//    }
    @Autowired
    private VideoManager videoManager;

    // Afficher la liste des vidéos
    @GetMapping("/list")
    public String listVideos(Model model) {
        List<Video> videos = videoManager.getAllVideos();
        model.addAttribute("videos", videos);
        return "listVideos";
    }

    // Afficher le formulaire d'ajout de vidéo
    @GetMapping("/add")
    public String showAddVideoForm(Model model) {
        model.addAttribute("video", new Video());
        return "addVideo";
    }

//    // Ajouter une nouvelle vidéo
    @PostMapping("/add")
    public String saveVideo(@ModelAttribute("video") Video video) {
        videoManager.addVideo(video);
        return "redirect:/videos/list";
    }

    // Afficher la vue de confirmation pour supprimer une vidéo
    @GetMapping("/delete/{id}")
    public String showDeleteVideoForm(@PathVariable("id") Integer id, Model model) {
        Video video = videoManager.getVideoById(id);
        model.addAttribute("video", video);
        //return "confirmDeleteVideo";
        return "deleteVideo";
    }

    // Supprimer une vidéo
    @PostMapping("/delete/{id}")
    public String deleteVideo(@PathVariable("id") Integer id) {
        videoManager.deleteVideo(id);
        return "redirect:/videos/list";
    }
}