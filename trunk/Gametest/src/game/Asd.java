package game;

import java.net.URI;
import java.net.URISyntaxException;

public class Asd {
	
	public Asd(){
		URI uri;
		try {
			uri = new URI(getClass().getResource("../../resources/menu/menu.PNG").toString());
			System.out.println(uri.toString());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		 new Asd();
	}

}
