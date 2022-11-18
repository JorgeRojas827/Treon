package sesion;

import ejercicios.EtipoA;
import models.Ejercicio;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utils.JSONReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SesionController {
    SesionView vista;
    
    public SesionController(){
        vista = new SesionView();
        iniciarSesion();
        
        
    }
    
    
    private void iniciarSesion(){
        
        //EJERCICIO PARA PRUEBAS
        JSONReader jsonReader = new JSONReader();
        JSONArray listEjercicios = jsonReader.getJSONbyPath("Ejercicios/ejercicio.json");
        //Crear el objeto con el cual jugar
        int index = new Random().nextInt(listEjercicios.size());
        JSONObject ejercicio = (JSONObject) listEjercicios.get(index);

        JSONArray opciones = (JSONArray) ejercicio.get("opciones");
        List<String[]> opcionesMatrix = new ArrayList<>();
        for( int i=0; i < opciones.size(); i++ ){
            String[] list = new String[opciones.size()];
            JSONArray opcion = (JSONArray) opciones.get(i);
            for( int k=0; k < opcion.size(); k++ ){
                list[k] = (String) opcion.get(k);
            }
            opcionesMatrix.add(list);
        }
        List<String> arrayTipos = new ArrayList<>();
        JSONArray tipos = (JSONArray) ejercicio.get("tipos");

        for( int i=0; i < tipos.size(); i++ ){
            arrayTipos.add((String) tipos.get(i));
        }

        Ejercicio objPruebas = new Ejercicio((String) ejercicio.get("id"), (ArrayList<String[]>) opcionesMatrix, (ArrayList<String>) arrayTipos, (Boolean) ejercicio.get("isFrase"));

        
        EtipoA controladorEj1 = new EtipoA( objPruebas );
        
        controladorEj1.recibirCambiar(vista.p1);
        
    }
    
}
