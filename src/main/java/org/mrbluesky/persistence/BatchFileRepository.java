package org.mrbluesky.persistence;

import org.mrbluesky.vo.entity.BatchFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchFileRepository extends JpaRepository<BatchFile, String> {
}
