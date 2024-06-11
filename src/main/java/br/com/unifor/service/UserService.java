package br.com.unifor.service;

import br.com.unifor.domain.UserEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    EntityManager em;

    public List<UserEntity> list() {
        return em.createQuery("SELECT u FROM UserEntity u", UserEntity.class).getResultList();
    }

    @Transactional
    public UserEntity create(UserEntity user) {
        em.persist(user);
        return user;
    }

    @Transactional
    public UserEntity update(UserEntity user) {
        return em.merge(user);
    }

    public UserEntity findById(Long id) {
        return em.find(UserEntity.class, id);
    }

    @Transactional
    public boolean delete(Long id) {
        UserEntity user = findById(id);
        if (user != null) {
            em.remove(user);
            return true;
        }
        return false;
    }
}
