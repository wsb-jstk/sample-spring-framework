package com.capgemini.sample.sf.infrastruture.aspect;

import lombok.Builder;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Aspect
@Component
public class LogInputArgumentsAspect {

    @Before(value = "@annotation(LogInputArguments)")
    public void logMethodArgumentsAndValues(final JoinPoint joinPoint) {
        final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        final String[] argumentNames = signature.getParameterNames();
        final Object[] arguments = joinPoint.getArgs();
        final Class<?>[] argumentClasses = signature.getParameterTypes();
        final List<ArgumentInfo> listOfArguments = new ArrayList<>();
        for (int i = 0; i < argumentNames.length; i++) {
            final ArgumentInfo ai = ArgumentInfo.builder().name(argumentNames[i]).type(argumentClasses[i]).value(arguments[i]).build();
            listOfArguments.add(ai);
        }
        final String className = signature.getDeclaringType().getName();
        final String methodName = signature.getMethod().getName();
        log.info("{}.{}() called with arguments: {}", className, methodName, listOfArguments);
    }

    @Value
    @Builder
    private static class ArgumentInfo {
        Class<?> type;
        String name;
        Object value;
    }

}
