package sample.ui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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

    private int noPares;
    private Scene escena;

    public Memorama(){

        CrearUI();
        this.setTitle("Memorama :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        lblTarjetas = new Label("Número de pares: ");
        txtNoTarjetas = new TextField();
        btnAceptar = new Button("Voltear y Revolver");
        //btnAceptar2 = new Button("Nuevo mensaje"); Botón de prueba
        btnAceptar.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
        //btnAceptar2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventosMemorama(2));
        /*btnAceptar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Tercer evento desde una clase anonima");
            }
        });*/
        hBox = new HBox();
        hBox.getChildren().addAll(lblTarjetas, txtNoTarjetas, btnAceptar/*btnAceptar2 */);
        hBox.setSpacing(10);
        gdpMesa = new GridPane();
        vBox = new VBox();
        vBox.getChildren().addAll(hBox, gdpMesa);

        escena = new Scene(vBox, 500, 500);
    }

    @Override
    public void handle(Event event) {
        noPares = Integer.parseInt(txtNoTarjetas.getText());

        vBox.getChildren().remove(gdpMesa);

        gdpMesa = new GridPane();
        arAsignacion = new String[2][noPares]; //Asignación para la cara principal de las tarjetas
        revolver();

        arTarjetas = new Button[2][noPares];
        for(int i=0; i<2; i++){
            for(int j=0; j<noPares; j++){
                Image img = new Image("sample/assets/CARTA BASE.jpg");//Ruta de imagen para el nodo
                ImageView imv = new ImageView(img);//Instancia de la carta trasera
                imv.setFitHeight(100);//Altura de la imagen
                imv.setPreserveRatio(true);

                arTarjetas[i][j] = new Button();
                int finalI = i;
                int finalJ = j;
                arTarjetas[i][j].setOnAction(event1 -> verTarjeta(finalI, finalJ));
                arTarjetas[i][j].setGraphic(imv);//Le agregamos el noto (la imagen)
                arTarjetas[i][j].setPrefSize(120,100);//Tamaño de la imagen

                gdpMesa.add(arTarjetas[i][j], j, i);
            }
        }
        vBox.getChildren().add(gdpMesa);
    }

    private void verTarjeta(int finalI, int finalJ) {
        Image img = new Image("sample/assets/" + arAsignacion[finalI][finalJ]);//Se conbierte en dinamico y la extención jpg se concatena.
        ImageView imv = new ImageView(img);//Instancia de la carta trasera
        imv.setFitHeight(100);//Altura de la imagen
        imv.setFitWidth(120);
        imv.setPreserveRatio(true);

        arTarjetas[finalI][finalJ].setGraphic(imv);
    }


    private void revolver() {
        //Va a manipular el arreglo de inmagenes, va a revolver las imagenes aleatoriamente
        for(int i=0; i<2; i++){
            for(int j=0; j<noPares; j++){
                arAsignacion[i][j] = new String();

            }

        }

        int posx, posy, cont = 0;
        for (int i=0; i<noPares;) {
            posx = (int) (Math.random() * 2);//posx hace referencia a algo aleatorio
            posy = (int) (Math.random() * noPares);
            //Verificar si la posición esta vacia
            if (arAsignacion[posx][posy].equals("")){
                arAsignacion[posx][posy] = arImagenes[i];
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
