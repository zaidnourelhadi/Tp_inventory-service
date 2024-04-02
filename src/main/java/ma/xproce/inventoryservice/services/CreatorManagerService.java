package ma.xproce.inventoryservice.services;

import jakarta.transaction.Transactional;
import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CreatorManagerService implements CreatorManager {

    @Autowired
    private CreatorRepository creatorRepository;
    @Override
    @Transactional
    public List<Creator> getAllCreators() {
        return creatorRepository.findAll();
    }
    @Override
    @Transactional
    public Creator addCreator(Creator creator) {
        return creatorRepository.save(creator);
    }
    @Override
    @Transactional
    public Creator updateCreator(Creator creator) {
        // Implémenter la logique de mise à jour du créateur
        return null;
    }
    @Override
    @Transactional
    public void deleteCreator(Integer id) {
        creatorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Creator getCreatorById(Integer id) {
        return creatorRepository.findById(id).orElse(null);
    }
}