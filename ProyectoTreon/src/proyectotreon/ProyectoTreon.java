package proyectotreon;

import Controller.IdiomaController;
import Model.Idioma;
import View.IdiomaView;

public class ProyectoTreon {

    public static void main(String[] args) {
        
        IdiomaView idiomaView = new IdiomaView();
        IdiomaController controllerIdioma = new IdiomaController(idiomaView);
        
        controllerIdioma.mostrarPantalla();
        
        
    }
    
}
