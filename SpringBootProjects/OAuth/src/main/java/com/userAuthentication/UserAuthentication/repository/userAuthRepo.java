package com.userAuthentication.UserAuthentication.repository;

import com.userAuthentication.UserAuthentication.entity.UserAuthEntity;
import org.springframework.boot.security.autoconfigure.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface userAuthRepo extends JpaRepository<UserAuthEntity,Long> {
    Optional<UserAuthEntity> findByEmail (String email);

    List<UserAuthEntity> findByRole(String role);

    Optional<UserAuthEntity> findByProviderAndProviderId (String provider, String providerId);
}
