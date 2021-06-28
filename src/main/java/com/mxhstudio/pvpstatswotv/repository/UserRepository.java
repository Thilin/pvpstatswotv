package com.mxhstudio.pvpstatswotv.repository;

import com.mxhstudio.pvpstatswotv.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
