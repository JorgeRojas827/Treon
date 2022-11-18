package modulo;

import models.Idioma;
import models.Modulo;
import idioma.IdiomasController;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ModulosController {
    ModulosView vista;
    ArrayList<Modulo> listaModulos;
    String idioma;
    
    public ModulosController(String idiomaEntrada){
        System.out.println("> Abriendo Modulos del idioma " + idiomaEntrada);
        this.idioma = idiomaEntrada;
        vista = new ModulosView();
        
        listarModulos();
        addBtnsModulos();
        
        
        vista.btnVolver.addActionListener((e) -> {
            
            IdiomasController idiomasController = new IdiomasController();
            vista.f.dispose();
            
        });
    }
    
    
    //Accede a los archivos, el idioma de parametro,  y lista los modulos del interior
    private void listarModulos(){
        listaModulos = new ArrayList<>();
        
        //Crear una lista de instancias idiomas
        File carpetaIdiomas = new File("Idiomas/"+idioma);
        
        //Recorrer los elementos dentro de la carpeta idiomas, y que solo se añadan aquellos que son directorios
        for( File x: carpetaIdiomas.listFiles() ){
            if (x.isDirectory()){
                
                listaModulos.add( new Modulo( x.getName(), x.getPath()+"/imagen.png" ) );
                //System.out.println(x.getName());     
                //System.out.println(""+x.getPath()+"/imagen.png");    // PA DEBUG
            }
        }
        
    }
    
    
    //Agregar los botones a la lista, de acuerdo a las carpetas en archivo
    public void addBtnsModulos(){      
        
        //Se crean los botones de acuerdo a cada elemento de la lista
        
        //La variable i es un parametro para la ubicacion de los botones
        int i = 0;
        for (Modulo x: listaModulos){
            JButton boton = new JButton();
            
            //Asignar nombre e imagen de acuerdo a los datos de la lista
            boton.setText( x.getNombre() );
            boton.setIcon(new ImageIcon( x.getImagen() ));
            
            //Ubicar el boton en pantalla
            boton.setBounds( 50, 150*(i+1), 175, 100 );
            //                  REESCRIBIR FORMULA (225*i)%450+50, (int) (150*floor(i/2))+50, 175, 100
            
            //Ubicar el texto en medio de la imagen
            boton.setIconTextGap(-105);
            
            //Darle funcionalidad al boton
            boton.addActionListener((e) -> {
                
                /*
                AGREGAR LA FUNCIONALIDAD AL BOTON
                AGREGAR LA FUNCIONALIDAD AL BOTON
                AGREGAR LA FUNCIONALIDAD AL BOTON
                AGREGAR LA FUNCIONALIDAD AL BOTONAGREGAR LA FUNCIONALIDAD AL BOTONAGREGAR LA FUNCIONALIDAD AL BOTON
                
                
                
                AGREGAR LA FUNCIONALIDAD AL BOTON
                
                        AGREGAR LA FUNCIONALIDAD AL BOTON
                AGREGAR LA FUNCIONALIDAD AL BOTON
                        AGREGAR LA FUNCIONALIDAD AL BOTONAGREGAR LA FUNCIONALIDAD AL BOTON
                AGREGAR LA FUNCIONALIDAD AL BOTON
                AGREGAR LA FUNCIONALIDAD AL BOTON
                AGREGAR LA FUNCIONALIDAD AL BOTON
                
                
                */
                
            });
            
            //Se añade el boton a la lista de la pantalla y a la pantalla
            vista.listaModulos.add(boton);
            
            vista.f.add(boton);
            i += 1;
        }
        
    }
    

}
