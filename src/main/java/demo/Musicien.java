package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") //permet de s'affranchir de l'aspect singleton --> permet d'instancier plusierus obkets
public class Musicien {

//	//Autowire faisable directement dans le constructeur
//	public Musicien(@Autowired @Qualifier("ukulele") Instrument instrument, @Autowired String partition) {
//	super();
//	this.instrument = instrument;
//	this.partition = partition;
//     }
	
	
		@Autowired
		@Qualifier("ukulele")//necessaire a partir du moment où deux instruments implementent la meme interface/ On peut aussi la mettre sur le setter
		private Instrument instrument;
		


		@Autowired // on peut faire ca grace a la fabrique de bean quon a mis dans le main//On peut aussi mettre @Value("tnt") si il n'ya a pas de fabrique de bean
		@Value("${musicien.partition}")//permet de lier l'application.properties
		private String partition;
		
		public void jouer() {
			System.out.println("partition : "+partition);
			instrument.jouer();
		}
		
}
