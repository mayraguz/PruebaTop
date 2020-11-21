package sample.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static String server = "127.0.0.1";//También puede ser "127.0.0.1", Conetar al servidor, se utiliza esta dorma por que el servidor está en el mismo equipo.
    private static String user = "topicos2020"; //Usuario a conectar
    private static String pwd = "covi2020"; //contraseña
    private static String db = "restaurante"; //base de datos

    public static Connection con; //La libreria de importación es general, se abre un streaming
    //Se va a conectar directamente a la base de datos
    public static void crearConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, user, pwd);
            System.out.println("La conexión esta establecida");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
