package net.minhtlab.tinyurl.dao;

import net.minhtlab.tinyurl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}