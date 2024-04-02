package ma.xproce.inventoryservice.services;

import jakarta.transaction.Transactional;
import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;

import java.util.List;

public interface CreatorManager {
    List<Creator> getAllCreators();

    Creator addCreator(Creator creator);

    Creator updateCreator(Creator creator);

    void deleteCreator(Integer id);

    Creator getCreatorById(Integer id);
}
