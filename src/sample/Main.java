package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.models.Conexion;
import sample.ui.Memorama;
import sample.ui.Dashboard;
import sample.ui.Taquimecanografo;

public class Main extends Application implements EventHandler {

    private VBox vPrincipal;

    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, menCompetencia2, menSalir;
    private MenuItem itmMemorama, itmPractica2, itmRestaurante, itmterminar;//Opciones especificas del menu
    private Scene escena;

    private ToolBar tlbMenu;
    //private ToolBar tlbMenu2;
    private Button btnToolbar1;
    //private Button btnToolbar2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Conexion.crearConexion();
        CrearUI();
        primaryStage.setTitle("Práctica de Topicos 2020");
        primaryStage.setMaximized(true);
        primaryStage.setScene(escena);//Muestra los menus
        primaryStage.addEventHandler(WindowEvent.WINDOW_HIDDEN, this);
        primaryStage.show();


        //new Hilo("Sonic").start();
        //new Hilo("Sonic").start();
        //new Hilo("Sonic").start();
    }

    private void CrearUI() {

        mnbPrincipal = new MenuBar();
        //Creación de los menus principales
        menCompetencia1 = new Menu("Competencia 1");
        menCompetencia2 = new Menu("Competencia 2");
        menSalir = new Menu("Salir");

        //Cargar los menus a la barra de menus
        mnbPrincipal.getMenus().addAll(menCompetencia1, menCompetencia2, menSalir);//Es importante el orden

        //Creamos el primer menu Item para el menu de la primera competencia.
        itmMemorama = new MenuItem("Memorama");
        itmMemorama.setOnAction(event -> opcionMenu(1));//Acción para el evento memorama //Ayuda a saber que vento se crea

        //Segundo menu Item de la primera competencia
        itmPractica2 = new MenuItem("Taquimecanográfo");
        itmPractica2.setOnAction(event -> opcionMenu(2));

        itmRestaurante = new MenuItem("Restaurante");
        itmRestaurante.setOnAction(event -> opcionMenu(3));

        itmterminar = new MenuItem("Hasta pronto :)");
        itmterminar.setOnAction(event -> {System.exit(0);});//Hace que la aplicación termine correctamente (El cero indica que termina por petición del usuario)

        //Cargar el Item Memorama al menu competencia 1
        menCompetencia1.getItems().addAll(itmMemorama, itmPractica2);//Muestra el boton para el memorama
        menCompetencia2.getItems().addAll(itmRestaurante);
        menSalir.getItems().add(itmterminar);

        //Cear barra de herramientas (opciones del menu con icónos)
        tlbMenu = new ToolBar();
        btnToolbar1 = new Button();//Se le va a cargar una imagen
        btnToolbar1.setOnAction(event -> opcionMenu(1));//Se manda llamar al memorama (Se duplica la acción)
        btnToolbar1.setPrefSize(35, 50);//Tamaño de la imagen

        //Asignamos la imagen al botón dentro del toolbar
        Image img = new Image("sample/assets/GAME.jpg");//Ruta de imagen para el nodo
        ImageView imv = new ImageView(img);
        imv.setFitHeight(50);
        imv.setPreserveRatio(true);
        btnToolbar1.setGraphic(imv);

        tlbMenu.getItems().add(btnToolbar1);//Definimos el boton


        /*//Cear barra de herramientas (opciones del menu con icónos)
        tlbMenu2 = new ToolBar();
        btnToolbar2 = new Button();//Se le va a cargar una imagen
        btnToolbar2.setOnAction(event -> opcionMenu(2));//Se manda llamar al memorama (Se duplica la acción)
        btnToolbar2.setPrefSize(35, 35);//Tamaño de la imagen

        //Asignamos la imagen al botón dentro del toolbar
        Image img2 = new Image("sample/assets/CARPETA.png");//Ruta de imagen para el nodo
        ImageView imv2 = new ImageView(img);
        imv.setFitHeight(35);
        imv.setPreserveRatio(true);
        btnToolbar2.setGraphic(imv);

        tlbMenu2.getItems().add(btnToolbar2);//Definimos el boton*/

        vPrincipal = new VBox();
        vPrincipal.getChildren().addAll(mnbPrincipal, tlbMenu);//Se agrupan los menus en un contenedor vBox
        escena = new Scene(vPrincipal);//Contiene la agrupación de los menus
        escena.getStylesheets().add("sample/assets/CSS/main_styles.css");
    }

    private void opcionMenu(int opc) {
        //Ayuda a la navegación dentro de la aplicación
        switch (opc){
            case 1:
                new Memorama();
            break;
            case 2:
                new Taquimecanografo();
            break;
            case 3:
                new Dashboard();
            break;

        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        System.out.println("Se esta mostrando la pantalla");
    }
}
