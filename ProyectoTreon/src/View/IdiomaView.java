package View;

import Model.Idioma;
import static java.lang.Math.floor;
import javax.swing.*;
import java.util.ArrayList;

public class IdiomaView {
    
    JFrame f;
    ArrayList<JButton> listaBotones;
    
    public IdiomaView(){
        listaBotones = new ArrayList<>();
    }
    
    public void crearPantalla(){
        
        f = new JFrame("Idiomas");
        f.setSize(500,700);
        f.setLayout(null);
        f.setDefaultCloseOperation(3);                  //CAMBIAR ESTO PARA EL FINAL
        
    }
    
    public void addBtnsIdiomas( ArrayList<Idioma> listaIdiomas ){      
        
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
            
            //Se añade el boton a la lista de la pantalla y a la pantalla
            listaBotones.add(boton);
            f.add(boton);
            i += 1;
        }
        
    }
    
    public void showPantalla(){
        f.setVisible(true);
    }
    
}
