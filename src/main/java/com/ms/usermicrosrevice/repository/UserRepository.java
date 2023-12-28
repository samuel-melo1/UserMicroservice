package com.ms.usermicrosrevice.repository;

import com.ms.usermicrosrevice.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
