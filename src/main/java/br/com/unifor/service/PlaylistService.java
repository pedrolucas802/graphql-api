package br.com.unifor.service;

import br.com.unifor.domain.PlaylistEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PlaylistService {

    @Inject
    EntityManager em;

    public List<PlaylistEntity> list() {
        return em.createQuery("SELECT p FROM PlaylistEntity p", PlaylistEntity.class).getResultList();
    }

    @Transactional
    public PlaylistEntity create(PlaylistEntity playlist) {
        em.persist(playlist);
        return playlist;
    }

    @Transactional
    public PlaylistEntity update(PlaylistEntity playlist) {
        return em.merge(playlist);
    }

    public PlaylistEntity findById(Long id) {
        return em.find(PlaylistEntity.class, id);
    }

    @Transactional
    public boolean delete(Long id) {
        PlaylistEntity playlist = findById(id);
        if (playlist != null) {
            em.remove(playlist);
            return true;
        }
        return false;
    }
}
