package metricconverter.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StringUtils;

@Aspect
@Slf4j
public class RestBoundaryLoggerAspect {
    @Around("execution(public * metricconverter.controller.*.*(..))")
    public Object logConvert(ProceedingJoinPoint pjp) throws Throwable {
        String argsPattern = "";
        for (int i = 0; i < pjp.getArgs().length; i++) {
            argsPattern += "{},";
        }

        argsPattern = StringUtils.isEmpty(argsPattern) ? argsPattern : argsPattern.substring(0, argsPattern.length() - 1);

        log.info("Inbound " + pjp.getSignature().getName() + (StringUtils.isEmpty(argsPattern) ? "" : " [args=" + argsPattern + "]"), pjp.getArgs());

        try {
            Object ret = pjp.proceed();
            log.info("Outbound " + pjp.getSignature().getName() + (ret == null ? "" : " [response={}]"), ret);
            return ret;
        } catch (Throwable throwable) {
            log.error("Error in method " + pjp.getSignature().getName(), throwable);
            throw throwable;
        }
    }
}
