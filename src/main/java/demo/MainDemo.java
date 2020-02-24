package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@ComponentScan // initialisation du conteneur
@Configuration// Pour marquer les classes qui declarent des fabrique de bean
@PropertySource("application.properties")// utilise le fichier applic.prop qui permet de remplacer les injection de valeurs (@value..)

@EnableAspectJAutoProxy//activer le tisseur d'aspect 
public class MainDemo {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MainDemo.class);
		
		Musicien musicien = ctx.getBean("musicien",Musicien.class);//nom bean = nom classe ave premiere lettre en miniscule
		
		musicien.jouer();
		
		System.out.println(musicien);
		
		Musicien musicien2 = ctx.getBean("musicien",Musicien.class);//permis grace à @Scope("prototype") qui différentie les instances
			
		System.out.println(musicien2);
	}
	
	@Bean
	@Primary// primary ou quaifier necessaire si deux fabriques renvoient le même type
	public String partitionR() {
		return "Au clair de jsais pas";
	}
	
	@Bean
	public String partition2() {
		return "Au clair du satellite naturel de la terre";
	}


}
