package usuarios;

public class UsuariosController {
    UsuariosView vista;
    
    public UsuariosController(){
        System.out.println("> Abriendo lista de usuarios a elegir");
        vista = new UsuariosView();
    }
    
}
