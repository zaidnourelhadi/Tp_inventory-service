package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import ma.xproce.inventoryservice.services.CreatorManager;
import ma.xproce.inventoryservice.services.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;
import java.util.List;

import static graphql.Assert.assertNotNull;

@SpringBootApplication
public class InventoryServiceApplication  {
    @Autowired
    private CreatorRepository creatorRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private VideoManager videoManager;

    @Autowired
    private CreatorManager creatorManager;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);}

    @Bean
    CommandLineRunner start() {
        return args -> {
            transactionTemplate.execute(status -> {
                Creator creator =new Creator();
                creator.setName("alex");
                creator.setEmail("alex@gmail.com");
                creatorRepository.save(creator);
                Video video =new Video();
                video.setName("Vd_1");
                video.setUrl("no url");
                video.setDatePublication(new Date());
                video.setDescription("vloging video");
                video.setCreator(creator);

                videoRepository.save(video);



                Creator creator2 = new Creator();
                creator2.setName("Test Creator");
                creator2.setEmail("test@example.com");
                creatorManager.addCreator(creator2);

                // Création d'une vidéo
                Video video2 = new Video();
                video2.setName("Test Video");
                video2.setUrl("http://example.com/test");
                video2.setDescription("Test video description");
                video2.setDatePublication(new Date());
                video2.setCreator(creator2);

                Video savedVideo = videoManager.addVideo(video2);


                // Vérification que la vidéo ajoutée est non nulle et contient l'ID attribué
                assertNotNull(savedVideo.getId());

                // Récupérer la liste des vidéos
                List<Video> videos = videoManager.getAllVideos();
                System.out.println("Liste des vidéos :");
                for (Video v : videos) {
                    System.out.println(v);
                }

                List<Creator> creators = creatorManager.getAllCreators();
                System.out.println("Liste des créateurs :");
                for (Creator c : creators) {
                    System.out.println(c);
                }
                return null;
            });
        };

    }





}
