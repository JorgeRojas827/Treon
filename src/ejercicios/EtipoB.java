package ejercicios;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Ejercicio;

public class EtipoB extends EjercicioController{
    ArrayList<String[]> opcionesApoyo;
    
    
    public EtipoB(Ejercicio data){
        super(data);
        opcionesApoyo = new ArrayList<>();
        System.out.println(" - Preparandolo en tipo >B<");
    }
    
    public void recibirCambiar(JPanel panel){
        
        //Para crear el ejercicio de tipo A es necesario hacer primero
        //las siguientes funciones de la clase padre
        elegirIdioma();
        elegirOpcionClave(); //Este no es necesario del todo, pero el shuffle final es util
        
        //Las opciones del otro idioma hay que pasarlo a la lista secundaria
        for (String[] x: opciones){
            opcionesApoyo.add(x);
        }
        Collections.shuffle(opcionesApoyo);
        
        //Agregar los elementos necesarios respectivos
        JLabel lblEnunciado = new JLabel("¡Conecta las opciones iguales!" );
        lblEnunciado.setBounds(50, 50, 200, 20);
        panel.add(lblEnunciado);        
        
        //Botones de idiomaNativo [0]
        JButton bt1 = new JButton();
        bt1 = configurarBoton(bt1, 0, opciones.get(0)[0], 0);
        panel.add(bt1);
        
        JButton bt2 = new JButton();
        bt2 = configurarBoton(bt2, 1, opciones.get(1)[0], 0);
        panel.add(bt2);
        
        JButton bt3 = new JButton();
        bt3 = configurarBoton(bt3, 2, opciones.get(2)[0], 0);
        panel.add(bt3);
        
        
        /*
                            RETO
                POR SI QUIERES ANADIR 4 OPCIONES ACA
        */
        
        //JButton bt4 = new JButton();
        //bt4 = configurarBoton(bt4, 3, opciones.get(2)[0], 0);
        //panel.add(bt4);
        
        
        //Botones de IdiomaExtranjero[1]
        JButton bt5 = new JButton();
        bt5 = configurarBoton(bt5, 0, opcionesApoyo.get(0)[1], 1);
        panel.add(bt5);
        
        JButton bt6 = new JButton();
        bt6 = configurarBoton(bt6, 1, opcionesApoyo.get(1)[1], 1);
        panel.add(bt6);
        
        JButton bt7 = new JButton();
        bt7 = configurarBoton(bt7, 2, opcionesApoyo.get(2)[1], 1);
        panel.add(bt7);
        
        /*
                    DEL RETO
        */
        //JButton bt8 = new JButton();
        //bt8 = configurarBoton(bt8, 3, opcionesApoyo.get(2)[1], 1);
        //panel.add(bt8);
        
    }
    
    
    //Controla las configuraciones necesrias de cada Boton
    //Recibe el Boton mismo, su nro, la opcion de encima y el idioma (o sea la columna que pertenece)
    private JButton configurarBoton(JButton btn, int pos, String rpta, int idioma){
        
        //Agregar el texto
        btn.setText(rpta);
        
        //Cada que se aprete el boton, ____________
        btn.addActionListener((e) -> {    
            
            
            
        });
        
        //Le pone backgroundColor
        if (idioma==1){
            btn.setBackground(Color.ORANGE);
        } else {
            btn.setBackground(Color.red);
        }
        
        
        //Funcion de posicion Y: a+(pos*b)
        //      a:posicion del primer boton 0;   b:separacion entre botones del mismo idioma
        //Funcion de posicion X: a+(idioma*b)
        //      a:posicion del primer boton 0;   b:separacion entre botones de distinto idioma
        btn.setBounds((180*idioma)+80, 150+(pos*80), 120, 50);
        
        return btn;
    }
    
    @Override
    public boolean calificarEjercicio() {
        
        //          CAMBIAR ESTO
        
        if (true){
            return true;    
        } else {
            return false;
        }
        
    }
    
    
    
}
