package com.org.data.authenticator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.org.data.authenticator.entity.User;

/**
 * 
 * @author Kishore Hebbar
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
