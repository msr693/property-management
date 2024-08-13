package com.mycompany.property_management.repository;

import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

    @Query("SELECT u from USER_TABLE u where u.ownerEmail =?1 and password=?2")
    Optional<UserEntity> findByOwnerEmailAndPassword(String email, String password);

}
