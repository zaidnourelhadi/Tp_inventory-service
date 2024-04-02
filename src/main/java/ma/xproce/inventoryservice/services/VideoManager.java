package ma.xproce.inventoryservice.services;

import ma.xproce.inventoryservice.dao.entities.Video;

import java.util.List;

public interface VideoManager {
    List<Video> getAllVideos();



    Video addVideo(Video video);




    Video updateVideo(Video video);

    void deleteVideo(Integer id);

    Video getVideoById(Integer id);
}
