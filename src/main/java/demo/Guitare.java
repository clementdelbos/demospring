package demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // priorise une classe lorqsqu'il n'y a pas de qualifier dans les propriétés de musicien                                   (les qualifier ont la priorité)
public class Guitare implements Instrument {


	@Override
	public void jouer() {
		System.out.println("Cling Clang Clang");
	}

}
