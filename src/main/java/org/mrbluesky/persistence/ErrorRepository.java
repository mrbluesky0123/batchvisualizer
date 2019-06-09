package org.mrbluesky.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.mrbluesky.vo.entity.Error;

@Repository
public interface ErrorRepository extends JpaRepository<Error, String> {

  Error findByErrorCode(String errorCode);

}
