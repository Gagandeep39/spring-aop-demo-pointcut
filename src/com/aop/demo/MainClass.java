/**
 * Gagandeep
 * 1:10:23 pm
 * 11-Apr-2020
 */
package com.aop.demo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.aop.config.AppConfig;
import com.aop.dao.AccountDao;
import com.aop.entity.Account;
/**
 * 
 * Spring application to demonstrate AOP conceepts such as Afvice, Pointcit etc
 * Uses Jars
 * Spring 5.0.7
 * AspectJweaver
 *
 */
public class MainClass {
	
	public static void main(String[] args) {
		
		/**
		 * Initializing Annoation based ncfiguration
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		

		
		/*
		 * DEMO 1
		 * Using PointCut exression
		 */
		AccountDao dao = context.getBean("accountDao", AccountDao.class);
		System.out.println("\n\n***********DEMO 1***********");
		dao.addAccount();
		dao.addAccount(new Account());
		
		/**
		 * Method with this expression WOnt be executed for getter and settot methods 
		 * Below line won be printed for set ID
		 * ----------Method with no getter/sette and all other method----------
		 * @Before("pointCutMethodExceptGetterAndSetter()")
		 */
		System.out.println("\n\n************DEMO 2***********");
		dao.setId(12);
		
		dao.addAccount();
		
		/**
		 * DEMO 3
		 * Below method returns a string, we will be intercepting the data using @AfterReturning
		 */
		System.out.println("\n\n************DEMO 3***********");
		String output = dao.addDebit();
		
		
		/**
		 * DEMO 4
		 * Interceotion an post processing a maethodnamed returnAcount()
		 * ONly below aspect will be executed for the method
		 * @AfterReturning(pointcut = "execution(* com.aop.*.*.return*())", returning = "result")
		 */
		System.out.println("\n\n************DEMO 4***********");
		
		Account account = dao.returnAccount();
		System.out.println(account);
		
		
		/**
		 * DEMO 5
		 * Executed after an exception is thrown
		 */
		System.out.println("\n\n************DEMO 5***********");
		try {
			dao.throwsException();
		} catch (Exception e) {
		}
		
		context.close();
	}

}
