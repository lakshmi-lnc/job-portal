package com.jobportal.server.repository;

import com.jobportal.server.entity.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchListRepository extends JpaRepository<WatchList, Long> {
}
