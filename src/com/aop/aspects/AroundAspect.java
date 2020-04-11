/**
 * Gagandeep
 * 11:04:30 pm
 * 11-Apr-2020
 */
package com.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Methods here will be executed before and after target method edxecution
 * 
 * Order of Execiton
 * 
 * @Before
 * @Around (start) targetmethod
 * @Around (end)
 * @AfterReturning/ @AfterThrowing
 * @After
 *
 */
@Aspect
@Component
public class AroundAspect {

	@Around("within(*)")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		long begin = System.currentTimeMillis();
		System.out.println("--------@Around advice----------");
		Object result = joinPoint.proceed();
		long end = System.currentTimeMillis();
		System.out.println("--------@Around advice----------Duration: " + (end - begin));
		return result;
	}
}
