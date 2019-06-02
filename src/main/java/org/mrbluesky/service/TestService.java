package org.mrbluesky.service;

import java.util.List;
import org.mrbluesky.persistence.BatchFileRepository;
import org.mrbluesky.persistence.BatchProgramRepository;
import org.mrbluesky.vo.entity.BatchProgram;
import org.mrbluesky.vo.output.BatchSelectTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

  private BatchFileRepository batchFileRepository;
  private BatchProgramRepository batchProgramRepository;

  @Autowired
  public TestService(BatchFileRepository batchFileRepository, BatchProgramRepository batchProgramRepository){

    this.batchFileRepository = batchFileRepository;
    this.batchProgramRepository = batchProgramRepository;

  }


  public BatchSelectTestResponse testService(String batchName){

    List<BatchProgram> batches = null;
    if(batchName == null) {
      batches = batchProgramRepository.findAll();
    } else {
      batches = batchProgramRepository.findByBatchName(batchName);
    }

    return new BatchSelectTestResponse(batches);

  }

}
