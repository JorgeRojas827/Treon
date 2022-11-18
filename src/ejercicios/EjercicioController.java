package ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JPanel;
import models.Ejercicio;

public abstract class EjercicioController {
    
    Ejercicio data;
    ArrayList<String[]> opciones;
    int idOpcionClave;
    int idioma;
    String opcionClave;
    String rptaIn;
    
    public EjercicioController(Ejercicio data){
        System.out.println("Creando ejercicio de id: "+data.getId());
        this.data = data;
        
        //Inicializar las variables necesarias
        this.opciones = new ArrayList<>();
    }
    
    public abstract void recibirCambiar(JPanel panel);
    
    public void elegirIdioma(){
        Random ran = new Random();
        idioma = ran.nextInt(2);
    }
    
    //Elige la opcion clave, la correcta
    //Como tambien guarda y desordena las opciones alternativa (en la ArrayList opciones)
    public void elegirOpcionClave(){
        Random ran = new Random();
        
        //Definir las opciones a elegir
        //Se crean 3 int aleatorios diferentes
        int[] numAleatorios = {0,0,0};
        
        numAleatorios[0] = ran.nextInt(data.getOpciones().size() );
        
        while (numAleatorios[1]==0){
            numAleatorios[1] = ran.nextInt(data.getOpciones().size() );
            if (numAleatorios[0]==numAleatorios[1]){
                numAleatorios[1]=0;
            }
        }
        while (numAleatorios[2]==0){
            numAleatorios[2] = ran.nextInt(data.getOpciones().size() );
            if (numAleatorios[0]==numAleatorios[2] || numAleatorios[1]==numAleatorios[2]){
                numAleatorios[2]=0;
            }
        }
        
        //Se selecciona y guarda la opcion clave entre los 3
        idOpcionClave = numAleatorios[0];
        opcionClave = data.getOpciones().get(idOpcionClave)[idioma];
        
        //Finalmente agrega las opciones a la lista
        opciones.add(data.getOpciones().get(numAleatorios[0]) );
        opciones.add(data.getOpciones().get(numAleatorios[1]) );
        opciones.add(data.getOpciones().get(numAleatorios[2]) );
        
        //Shuffle a la lista
        Collections.shuffle(opciones);
    }
    
    //Desordena la lista de opciones
    public void shuffleOpciones(){
        System.out.println("Por ahora nada de funcion shuffle sola");
    }
    
    
    //Revisa que la opcion clave guardada sea la misma que la rptaInput
    public boolean calificarEjercicio(){
        
        //Evaluar si la rpta ingresada es la misma que:
        //                          la opcion del idioma contrario con la opcionClave del ejercicio
        if (this.rptaIn == this.data.getOpciones().get(idOpcionClave)[1-idioma]){
            System.out.println(" - Se compara " + this.opcionClave + " con " + this.rptaIn + " devuelve true"); //Debug
            return true;
        } else {
            System.out.println(" - Se compara " + this.opcionClave + " con " + this.rptaIn + " devuelve false");//Debug
            return false;
        }
        
    }
    
}
