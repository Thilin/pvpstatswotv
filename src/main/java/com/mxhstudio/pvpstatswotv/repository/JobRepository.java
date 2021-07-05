package com.mxhstudio.pvpstatswotv.repository;

import com.mxhstudio.pvpstatswotv.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
