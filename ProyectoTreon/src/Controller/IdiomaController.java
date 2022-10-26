package Controller;
import Model.Idioma;
import View.IdiomaView;
import java.io.File;
import java.util.ArrayList;

public class IdiomaController {
    
    IdiomaView idiomaView = new IdiomaView();
    
    public IdiomaController(IdiomaView idiomaView){
        this.idiomaView = new IdiomaView();
        
    }
    
    public void mostrarPantalla(){
        //Manda crear pantalla al 
        idiomaView.crearPantalla();
        
        //Añade botones a la pantalla, de acuerdo a la lista
        ArrayList<Idioma> listaIdiomas = listarIdiomas();
        idiomaView.addBtnsIdiomas(listaIdiomas);
        
        //Manda mostrar la pantalla al view
        idiomaView.showPantalla();
    }
    
    
    private ArrayList<Idioma> listarIdiomas(){
        ArrayList<Idioma> listaIdiomas = new ArrayList<>();
        
        //Crear una lista de instancias idiomas
        File carpetaIdiomas = new File("Idiomas");
        
        //Recorrer los elementos dentro de la carpeta idiomas, y que solo se añadan aquellos que son directorios
        for( File x: carpetaIdiomas.listFiles() ){
            if (x.isDirectory()){
                
                listaIdiomas.add( new Idioma( x.getName(), ""+x.getPath()+"/imagen.png" ) );
                System.out.println(x.getName());
                System.out.println(""+x.getPath()+"/imagen.png");
            }
        }
        
        return listaIdiomas;
        
    }

    
}
