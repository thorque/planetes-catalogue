/**
 * 
 */
package de.planetes.catalogue.ri.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author kamann
 *
 */
@Aspect
public class CatalogDBAspect {

	@Pointcut("execution(* de.planetes.catalogue.ri.service.repository.*.find*(..))")
	public void find() {
	}

	@Around("find() ")
	public Object profile(ProceedingJoinPoint call) throws Throwable {
		System.out.println(call);
		return call.proceed();
	}
}
