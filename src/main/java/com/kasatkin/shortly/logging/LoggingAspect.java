package com.kasatkin.shortly.logging;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Log4j
public class LoggingAspect {

   private static final String FORMAT_INPUT_ARGS = "%s.%s() INPUT: %s";
   private static final String FORMAT_RETURN_VALUE = "%s.%s() RETURN: %s";

   @Pointcut("@annotation(Loggable)")
   public void setPointCut() {

   }

   @Before("setPointCut()")
   public void logBeforeMethod(JoinPoint jp) throws Throwable {
      String args = Arrays.toString(jp.getArgs());
      args = String.format("{%s}", args.replaceAll(",", "},{"));
      logFormattedString(jp, args, FORMAT_INPUT_ARGS);
   }

   private void logFormattedString(JoinPoint jp, String argument, String format) {
      String className = jp.getTarget().getClass().getSimpleName();
      String methodName = jp.getSignature().getName();
      String formatted = String.format(format, className, methodName, argument);
      log.info(formatted);
   }

   @AfterReturning(pointcut = "setPointCut()", returning = "returnValue")
   public void logAfterMethod(JoinPoint jp, Object returnValue) {
      logFormattedString(jp, returnValue.toString(), FORMAT_RETURN_VALUE);
   }
}
