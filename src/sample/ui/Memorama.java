package sample.ui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.events.EventosMemorama;

import java.util.ArrayList;
import java.util.Random;

public class Memorama extends Stage implements EventHandler {

    private String[] arImagenes = {"AMSTERDAM.jpg", "BARCELONA.jpg", "BRUSELAS.jpg", "BUENOS AIRES.jpg", "CDMX.jpg", "CHICAGO.jpg", "DELHI.jpg", "FRANKFURT.jpg", "LIMA.jpg", "LONDRES.jpg", "MILÁN.jpg", "MOSCÚ.jpg", "NEW YORK.jpg", "PARIS.jpg", "ROMA.jpg", "RÍO DE JANEIRO.jpg", "SHANGAI.jpg", "TOKIO.jpg", "TORONTO.jpg", "YACARTA.jpg"};

    private Label lblTarjetas;
    private TextField txtNoTarjetas;
    private Button btnAceptar, btnAceptar2;
    private HBox hBox;
    private VBox vBox;
    private GridPane gdpMesa;
    private Button[][] arTarjetas;
    private String[][] arAsignacion;
    private Label lblIntentos;
    private Label lblPares;
    //private Alert alert;

    private int noPares;
    private Scene escena;
    int contI = 0, contP = 0;

    public Memorama() {

        CrearUI();
        this.setTitle("Memorama :)");//Muestra el nombre del programa en la parte superior del stage (ventana)
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        lblTarjetas = new Label("Número de pares: ");
        txtNoTarjetas = new TextField();

        lblIntentos = new Label("Número de intentos" + contI);
        lblIntentos = new Label("Número de intentos" + contP);

        btnAceptar = new Button("Voltear y Revolver");
        btnAceptar.addEventHandler(MouseEvent.MOUSE_CLICKED, this);

        hBox = new HBox();
        hBox.getChildren().addAll(lblTarjetas, txtNoTarjetas, btnAceptar /*lblIntentos, lblPares, btnAceptar2 */);//Enlistado horizontal de los datos
        hBox.setSpacing(10);
        gdpMesa = new GridPane();
        vBox = new VBox();
        vBox.getChildren().addAll(hBox, gdpMesa);

        escena = new Scene(vBox, 1200, 300);
    }

    @Override
    public void handle(Event event) {
        noPares = Integer.parseInt(txtNoTarjetas.getText());

        if (noPares <= 10 && noPares > 1) {

            vBox.getChildren().remove(gdpMesa);
            //System.out.println((noPares*2)/(noPares/2));
            gdpMesa = new GridPane();
            //arAsignacion = new String[2][noPares]; //Asignación para la cara principal de las tarjetas
            arAsignacion = new String[noPares*2][noPares/2];
            revolver();
            //compararImg();

           //arTarjetas = new Button[2][noPares];
            arTarjetas = new Button[noPares/2][noPares];
            //for (int i = 0; i < 2; i++) {
            for (int i=0; i<noPares/2; i++) {
                //for (int j = 0; j < noPares; j++) {
                for (int j=0; j<(noPares*2)/(noPares/2); j++) {
                    Image img = new Image("sample/assets/CARTA BASE.jpg");//Ruta de imagen para el nodo
                    ImageView imv = new ImageView(img);//Instancia de la carta trasera
                    imv.setFitHeight(100);//Altura de la imagen
                    imv.setPreserveRatio(true);

                    arTarjetas[i][j] = new Button();
                    int finalI = i;
                    int finalJ = j;
                    arTarjetas[i][j].setOnAction(event1 -> verTarjeta(finalI, finalJ));
                    arTarjetas[i][j].setGraphic(imv);//Le agregamos el noto (la imagen)
                    arTarjetas[i][j].setPrefSize(100, 100);//Tamaño de la imagen

                    gdpMesa.add(arTarjetas[i][j], j, i);
                }
            }
            vBox.getChildren().add(gdpMesa);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Número invalido");
            alert.setContentText("Ingrese un numero de pares menor a 10 y mayor a 1");
            alert.showAndWait();
        }

    }

    private void verTarjeta(int finalI, int finalJ) {

        Image img = new Image("sample/assets/" + arAsignacion[finalI][finalJ]);//Se conbierte en dinamico y la extención jpg se concatena
        ImageView imv = new ImageView(img);//Instancia de la carta trasera
        imv.setFitHeight(100);//Altura de la imagen
        imv.setFitWidth(100);
        imv.setPreserveRatio(true);

        arTarjetas[finalI][finalJ].setGraphic(imv);
        /*
        Encontre que si imprimia en consola el arreglo de asignaciones, entonces e imprimia el nombre de la imagen, que era lo que principalmente estaba buscando
        sout(arAsignacion[finalI][finalJ]); -> Imprime el nombre de la imagen
        Despues ya teniendo identificada donde se localizar la posición donde se encuentra el nombre de la imagen, ya podía hacer una comparación
        asignando cada nombre en un Arraylist y así comparando las posiciones

        Implementamos un ArrayList
        ArrayList<String> nombres = new ArrayList<String>();

        nombres.add(arTarjetas[finalI][finalJ]);//Primera tarjeta
        nombres.add(arTarjetas[finalI][finalJ]);//Primera tarjeta
        /*if(nombres.get(0) = nombres.get(1)){
            contP = contP + 1;
        }
        else{
            arTarjetas[finalI][finalJ] = img;
        }
        contI = contI + 1;

       */
        if(contP == noPares){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fin del juego");
            alert.setHeaderText("Felicidades!!!");
            alert.setContentText("Has terminado el Memorama con un numero de intentos: " + contI);
            alert.showAndWait();
        }

    }

    private void revolver() {
        ArrayList <String> nombres = new ArrayList<String>();
        int n =0;
        //Va a manipular el arreglo de inmagenes, va a revolver las imagenes aleatoriamente
        for(int i=0; i<2; i++){
            for(int j=0; j<noPares; j++){
                arAsignacion[i][j] = new String();
                nombres.add(arAsignacion[i][j]);
            }
            System.out.println(nombres.get(0));
        }

        int posx, posy, cont = 0, as;
        for (int i=0; i<noPares;) {
            posx = (int) (Math.random() * 2);//posx hace referencia a algo aleatorio
            posy = (int) (Math.random() * noPares);
            //Verificar si la posición esta vacia
            if (arAsignacion[posx][posy].equals("")){
                arAsignacion[posx][posy] = arImagenes[i];
                /*Para hacer las tarjetas aleatorias, intente cambiar la linea 136, con:
                as = (int) (Math.random() * i);
                arAsignacion[posx][posy] = arImagenes[as];
                Esto me mostraba la misma imagen en todas las cartas.
                 */
                cont++;
            }
            //Comprueba que la imagen se asigno dos veces
            if(cont == 2){
                i++;
                cont = 0;
            }
        }
    }
}
