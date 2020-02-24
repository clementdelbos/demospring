package demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component// on peut aussi creer une fabrique dans le main (return Fonction) 
public class Fonction {


	@Before("execution(* demo.Musicien.jouer(..))")
	public void prendrePlace() {
		
		System.out.println("ils prennent place");
		
	}
	
	@Around("execution(* demo.Musicien.jouer(..))")//avant et apres
	public void mesure(ProceedingJoinPoint pjp) throws Throwable
	{
		long start = System.nanoTime();
		
		pjp.proceed();
		
		long stop = System.nanoTime();
		
		System.out.println("Temps d'execution en ns : "+(stop-start));
	}
	
	@After("execution(* demo.Musicien.jouer(..))")
	public void applaudir() {
		
		System.out.println("tro bien ouaiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		
	}
	
}

