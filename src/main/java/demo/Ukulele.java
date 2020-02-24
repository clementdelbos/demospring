package demo;

import org.springframework.stereotype.Component;

@Component("ukulele")
public class Ukulele implements Instrument {

	@Override
	public void jouer() {
		System.out.println("Lé Lé Uk Uk");
	}
	
}
