package motor;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * Clase objetivo encargada de abrir el navegador en una página con un
 * demo de managed bean
 * @author Adrián
 *
 */
public class Interfaz {

	public void ejecutar(double peticion) {
		String url = "http://localhost:8080/practica1DSS/faces/home.xhtml";

        if (Desktop.isDesktopSupported()) {
            // Windows
            try {
				Desktop.getDesktop().browse(new URI(url));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            // Ubuntu
            Runtime runtime = Runtime.getRuntime();
            try {
				runtime.exec("/usr/bin/firefox -new-window " + url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

	}
	
}
