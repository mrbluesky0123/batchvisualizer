package org.mrbluesky.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mrbluesky.service.BatchVisualizerService;
import org.mrbluesky.vo.input.BatchSelectPostInput;
import org.mrbluesky.vo.output.BatchSelectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping("/batch")
public class BatchVisualizerController {

  private static Logger logger = LogManager.getLogger(BatchVisualizerController.class);
  private BatchVisualizerService batchVisualizerService;

  @Autowired
  public BatchVisualizerController(BatchVisualizerService batchVisualizerService) {
    this.batchVisualizerService = batchVisualizerService;
  }

  @GetMapping(value = {"", "/", "/{systemId}/{seq}/{batchName}"})
  public BatchSelectResponse getBatchInformation(@PathVariable(required = false) String systemId,
                                                @PathVariable(required = false) Integer seq,
                                                @PathVariable(required = false) String batchName) {

    return batchVisualizerService.batchVisualizerService(systemId, seq, batchName);

  }

  @PostMapping(path = "/{batchName}", consumes = "application/json", produces = "application/json")
  public BatchSelectResponse getBatchInformationPost(
                                          @PathVariable(required = true) String batchName,
                                          @RequestBody BatchSelectPostInput batchSelectPostInput) {

    HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//    String ip = req.getHeader("X-FORWARDED-FOR");

    logger.info("Client IP: " + req.getRemoteAddr());

    if(!batchName.equals(batchSelectPostInput.getBatName())) {
      return null;
    }

    String msg = "Data1 : " + batchSelectPostInput.getSystemId() + ", Data2 : " +
        batchSelectPostInput.getBatchSeqeunce() + ", Data3 : " + batchSelectPostInput.getBatName();
    logger.info(msg);

    BatchSelectResponse pointSaveOut = this.batchVisualizerService
        .batchVisualizerService(batchSelectPostInput.getSystemId(),
                                batchSelectPostInput.getBatchSeqeunce(),
                                batchSelectPostInput.getBatName());

    return pointSaveOut;

  }

}
