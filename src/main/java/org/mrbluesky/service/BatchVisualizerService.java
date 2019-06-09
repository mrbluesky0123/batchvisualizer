package org.mrbluesky.service;

import java.util.List;
import org.mrbluesky.persistence.BatchFileRepository;
import org.mrbluesky.persistence.BatchProgramRepository;
import org.mrbluesky.persistence.ErrorRepository;
import org.mrbluesky.vo.entity.Error;
import org.mrbluesky.vo.entity.BatchProgram;
import org.mrbluesky.vo.entity.BatchProgramId;
import org.mrbluesky.vo.output.BatchSelectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchVisualizerService {

  private BatchFileRepository batchFileRepository;
  private BatchProgramRepository batchProgramRepository;
  private ErrorRepository errorRepository;

  @Autowired
  public BatchVisualizerService(BatchFileRepository batchFileRepository,
      BatchProgramRepository batchProgramRepository, ErrorRepository errorRepository){

    this.batchFileRepository = batchFileRepository;
    this.batchProgramRepository = batchProgramRepository;
    this.errorRepository = errorRepository;

  }


  public BatchSelectResponse batchVisualizerService(String system, Integer seq, String batchName){

    Error error;
    List<BatchProgram> batches;
    BatchSelectResponse batchSelectResponse = null;
    String errorCode = "";

    if(seq == null && system == null && batchName == null) {
      batches = batchProgramRepository.findAll();
    } else if(seq != null && system != null && batchName != null) {
      batches = batchProgramRepository.findByBatchProgramId(new BatchProgramId(system, seq, batchName));
      if(batches.size() == 0){
        errorCode = "1001";
        error = errorRepository.findByErrorCode(errorCode);
        batchSelectResponse = new BatchSelectResponse(error, null);
        return batchSelectResponse;
      }
    } else {
      errorCode = "1003";
      error = errorRepository.findByErrorCode(errorCode);
      batchSelectResponse = new BatchSelectResponse(error, null);
      return batchSelectResponse;
    }

    errorCode = "0000";
    error = errorRepository.findByErrorCode(errorCode);
    batchSelectResponse = new BatchSelectResponse(error, batches);
    return batchSelectResponse;

  }

}
