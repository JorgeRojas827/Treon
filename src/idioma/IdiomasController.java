package idioma;

import models.Idioma;
import modulo.ModulosController;

import java.io.File;
import static java.lang.Math.floor;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import usuarios.UsuariosController;

public class IdiomasController {
    IdiomasView vista;
    ArrayList<Idioma> listaIdiomas;
    
    public IdiomasController(){
        System.out.println("> Abriendo lista de Idiomas para elegir");
        
        listarIdiomas();
        vista = new IdiomasView();
        addBtnsIdiomas();
        vista.btnVolver.addActionListener((e) -> {
            
            UsuariosController usuarioController = new UsuariosController();
            vista.f.dispose();
            
        });
        
    }
    
    //Accede a los archivos, y lista los idiomas guardados
    private void listarIdiomas(){
        listaIdiomas = new ArrayList<>();
        
        //Crear una lista de instancias idiomas
        File carpetaIdiomas = new File("Idiomas");
        
        //Recorrer los elementos dentro de la carpeta idiomas, y que solo se añadan aquellos que son directorios
        for( File x: carpetaIdiomas.listFiles() ){
            if (x.isDirectory()){
                
                listaIdiomas.add( new Idioma( x.getName(), x.getPath()+"/imagen.png" ) );
                //System.out.println(x.getName());     
                //System.out.println(""+x.getPath()+"/imagen.png");     PA DEBUG
            }
        }
        
    }
    
    //Agregar los botones a la pantalla
    public void addBtnsIdiomas(){      
        
        //Se crean los botones de acuerdo a cada elemento de la lista
        
        //La variable i es un parametro para la ubicacion de los botones
        int i = 0;
        for (Idioma x: listaIdiomas){
            JButton boton = new JButton();
            
            //Asignar nombre e imagen de acuerdo a los datos de la lista
            boton.setText( x.getNombre() );
            boton.setIcon(new ImageIcon( x.getImagen() ));
            
            //Ubicar el boton en pantalla
            boton.setBounds( (225*i)%450+50, (int) (150*floor(i/2))+50, 175, 100);
            
            //Ubicar el texto en medio de la imagen
            boton.setIconTextGap(-105);
            
            //Darle funcionalidad al boton
            boton.addActionListener((e) -> {
                
                //Crear una pantalla de modulo
                ModulosController moduloController = new ModulosController( x.getNombre() );
                //Eliminar la actual
                vista.f.dispose();
                
            });
            
            //Se añade el boton a la lista de la pantalla y a la pantalla
            vista.listaBotones.add(boton);
            vista.f.add(boton);
            i += 1;
        }
        
    }
    

    
}
