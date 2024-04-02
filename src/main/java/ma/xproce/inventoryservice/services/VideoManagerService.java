package ma.xproce.inventoryservice.services;

import jakarta.transaction.Transactional;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideoManagerService implements VideoManager {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    @Transactional
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @Override
    @Transactional
    public Video addVideo(Video video) {
        return videoRepository.save(video);
    }



    @Override
    @Transactional
    public Video updateVideo(Video video) {
        // Implémenter la logique de mise à jour de la vidéo
        return null;
    }

    @Override
    @Transactional
    public void deleteVideo(Integer id) {
        videoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Video getVideoById(Integer id) {
        return videoRepository.findById(id).orElse(null);
    }
}