package com.furquan.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furquan.ecommerce.entity.User;

import java.util.Optional;

/**
 * Spring Data JPA Repository for {@link User} entity
 *
 * @author furquan
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a User through the given username.
     *
     * @param username the username to look for
     * @return the User that was found (if any)
     */
    Optional<User> findByUsername(String username);

}
