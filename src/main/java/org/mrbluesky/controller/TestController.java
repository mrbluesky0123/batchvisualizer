package org.mrbluesky.controller;

import java.util.List;
import org.mrbluesky.service.TestService;
import org.mrbluesky.vo.output.BatchSelectTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/batch")
public class TestController {

  private TestService testService;

  @Autowired
  public TestController(TestService testService){
    this.testService = testService;
  }

  @GetMapping(value = {"/", "/{batchName}"})
  public BatchSelectTestResponse testController(@PathVariable(required = false) String batchName){

    return testService.testService(batchName);

  }
}
