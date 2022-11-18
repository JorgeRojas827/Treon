package sesion;

import ejercicios.EjercicioController;
import ejercicios.EtipoA;
import java.util.Stack;
import models.Ejercicio;

public class SesionController {
    SesionView vista;
    Stack<EjercicioController> listaControllers;
    
    public SesionController(){
        System.out.println("Abriendo sesion del modulo " + " del idioma ");
        listaControllers = new Stack<>();
        vista = new SesionView();
        
        //Agregar la funcionalidad del botonEvaluar
        vista.btnEvaluar.addActionListener((e) -> {
            
            //Si el stack aun tiene elementos
            if ( !listaControllers.empty() ){

                //Agarra el ultimo elemento de la pila y manda calificarse
                listaControllers.firstElement().calificarEjercicio();

                //Elimina ese elemento


                //Pasa al siguiente panel


                //Cambia el label de PROGRESO(????
            
            //Si ya no hay elementos
            } else {
                //Que se cree la pantalla de puntaje
                
            }
            
            
            
        });
        
        
        iniciarSesion();
        
    }
    
    
    private void iniciarSesion(){
        
                                //EJERCICIO PARA PRUEBAS
        //Crear el objeto con el cual jugar
        String [][] opciones = { {"rojo" , "red"}, {"azul", "blue"}, {"verde", "green"}, {"naranja", "orange"} };
        String [] tipos = {"A","B","C"};
        Ejercicio objPruebas = new Ejercicio( "idUno", false );
        objPruebas.agregarOpcion( opciones[0] );
        objPruebas.agregarOpcion( opciones[1] );
        objPruebas.agregarOpcion( opciones[2] );
        objPruebas.agregarOpcion( opciones[3] );
        
        objPruebas.agregarTipo(tipos[0]);
        objPruebas.agregarTipo(tipos[1]);
        objPruebas.agregarTipo(tipos[2]);
                                //EJERCICIO PARA PRUEBAS

                                
        //Elegir 4 ejercicios
        
        
        //Por cada ejercicio, asignarle un controlador de acuerdo a sus tipos
        
        
        EtipoA controladorEj1 = new EtipoA( objPruebas );
        
        
        controladorEj1.recibirCambiar(vista.p1);
        
        listaControllers.add(controladorEj1);
    }
    
    //Dependiendo del nP ingresado, se muestra el panelN respectivo
    public void cambiarPanel(int nP){
        
        if (nP==1){
            vista.p1.setVisible(true);
            vista.p2.setVisible(false);
            vista.p3.setVisible(false);
            vista.p4.setVisible(false);
        }
        if (nP==2){
            vista.p1.setVisible(false);
            vista.p2.setVisible(true);
            vista.p3.setVisible(false);
            vista.p4.setVisible(false);
        }
        if (nP==3){
            vista.p1.setVisible(false);
            vista.p2.setVisible(false);
            vista.p3.setVisible(true);
            vista.p4.setVisible(false);
        }
        if (nP==4){
            vista.p1.setVisible(false);
            vista.p2.setVisible(false);
            vista.p3.setVisible(false);
            vista.p4.setVisible(true);
        }
        
    }
    
}
