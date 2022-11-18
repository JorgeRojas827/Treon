package usuarios;

import models.Constantes;
import javax.swing.JButton;
import javax.swing.JFrame;

public class UsuariosView {
    JFrame f;
    JButton btnPaseIdioma;
    
    public UsuariosView(){
        f = new JFrame("Seleccion de Usuario");
        
        
        
        f.setLayout(null);
        f.setVisible(true);
        f.setSize( Constantes.SIZE_PANTALLA[0], Constantes.SIZE_PANTALLA[1] );
        f.setDefaultCloseOperation(3);
    }
    
}
