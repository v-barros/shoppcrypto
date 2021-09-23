package com.shoppcrypto.shoppcrypto.persistence.repository;

import com.shoppcrypto.shoppcrypto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
