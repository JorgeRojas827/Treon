package inicio;

import models.Constantes;
import javax.swing.JButton;
import javax.swing.JFrame;

public class InicioView {
    //Iniciar variables de pantalla
    JFrame f;
    JButton btnPaseUsuario;
    
    public InicioView(){
        //Configurar elementos de la vista
        f = new JFrame("BIENVENIDO A TREON");
        
        
        btnPaseUsuario = new JButton("Ingresar");
        btnPaseUsuario.setBounds(100, 400, 200, 50);
        f.add(btnPaseUsuario);
        
        
        f.setLayout(null);
        f.setVisible(true);
        f.setSize( Constantes.SIZE_PANTALLA[0], Constantes.SIZE_PANTALLA[1] );
        f.setDefaultCloseOperation(3);
    }
    
}
