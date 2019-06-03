package org.mrbluesky.persistence;

import java.util.List;
import org.mrbluesky.vo.entity.BatchProgram;
import org.mrbluesky.vo.entity.BatchProgramId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchProgramRepository extends JpaRepository<BatchProgram, BatchProgramId> {

  List<BatchProgram> findByBatchProgramId(BatchProgramId batchProgramId);

}
