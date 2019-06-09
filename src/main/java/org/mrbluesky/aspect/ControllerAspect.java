package org.mrbluesky.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.mrbluesky.vo.output.CommonResponse;
import org.mrbluesky.vo.output.IResponse;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Aspect
@Component
public class ControllerAspect {

  Logger logger =  LogManager.getLogger(ControllerAspect.class);

  @Around("execution(* org.mrbluesky.controller.BatchVisualizerController.get*(..))")
  public CommonResponse response(ProceedingJoinPoint pjp) throws Throwable {

    CommonResponse commonResponse = new CommonResponse();
    commonResponse.setStatus("true");
    commonResponse.setStatusMessage("aaaaaaa");
    logger.info("asdasd");
    Object result = pjp.proceed();
    commonResponse.setBusinessResponse((IResponse)result);
    logger.info("asdaqqqqq");

    return commonResponse;

  }

}
