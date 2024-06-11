package br.com.unifor.service;

import br.com.unifor.domain.MusicEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class MusicService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public MusicEntity create(MusicEntity music) {
        entityManager.persist(music);
        return music;
    }

    @Transactional
    public MusicEntity update(MusicEntity music) {
        return entityManager.merge(music);
    }

    public List<MusicEntity> list() {
        return entityManager.createQuery("from MusicEntity", MusicEntity.class).getResultList();
    }

    public MusicEntity findById(Long id) {
        return entityManager.find(MusicEntity.class, id);
    }

    @Transactional
    public boolean delete(Long id) {
        MusicEntity music = entityManager.find(MusicEntity.class, id);
        if (music != null) {
            entityManager.remove(music);
            return true;
        }
        return false;
    }
}
