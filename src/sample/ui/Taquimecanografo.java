package sample.ui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;//libreria de entrada/salida (Es estandar y/o generico)
import java.io.IOException;

public class Taquimecanografo extends Stage implements EventHandler<KeyEvent> {

    //Bandera para deectar cambios de color en las teclas
    boolean banColor = false;

    //Areglos para etiquetar los botones del teclado
    private String arLblBtn1[] = {"ESC", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12", "Imp Pan", "Pausa", "Insert", "Supr"};
    private String arLblBtn2[] = {" | °  ¬", "  1  ! ", "  2  ´´ ", " 3  # ", " 4  $ ", " 5  % ", " 6  & "," 7  / ", " 8  ( ", " 9  ) ", " 0  = ", " '  ? ", " ¿  ¡ ", "    <-----   "};
    private String arLblBtn3[] = {" -->  <-- ", " Q @ ", "   W  ", "   E  ", "   R  ", "   T  ", "   Y  ", "   U  ", "   I  ", "   O  ", "  P   ", "  ´ ¨  ", "  + * ~  ", "  Intro  "};
    private String arLblBtn4[] = {"  Bloq  Mayús  ", "   A   ", "   S   ", "   D   ", "   F   ", "   G   ", "   H   ", "   J   ", "   K   ", "   L   ", "   Ñ   ", "  {  [  ^  ", "  }  ]  ` "};
    private String arLblBtn5[] = {"   Shift   ", "  <  >  ", "   Z   ", "   X   ", "   C   ", "   V   ", "   B   ", "   N   ", "   M   ", "  ,  ;  ", "  .  :  ", "   - _   ", "       Shift      "};
    private String arLblBtn6[] = {"   Ctrl    ", "   Fn   ", "windows", "  Alt  ", "                          Espace                         ", "  Alt  Gr ", "  Opc  ", "  Ctrl  "};

    //Elementos para el Toolbar
    private ToolBar tlbMenu;
    private Button btnAbrir;

    //Elementos para la escritura
    private TextArea txtContenido, txtEscritura;

    //Elementos para el teclado
    private HBox[] arHBoxTeclas = new HBox[6];//Tecla horizontales
    private VBox vBoxTeclado;//Teclas verticales
    private Button[] arBtnTeclado1 = new Button[17];//Primera linea
    private Button[] arBtnTeclado2 = new Button[14];
    private Button[] arBtnTeclado3 = new Button[14];
    private Button[] arBtnTeclado4 = new Button[13];
    private Button[] arBtnTeclado5 = new Button[13];
    private Button[] arBtnTeclado6 = new Button[8];

    //Elementos de afrupación global
    private VBox vBoxPrincipal;
    private Scene escena;

    public Taquimecanografo(){
        CrearUI();
        this.setTitle("Tutos de taquimecanografía");
        this.setScene(escena);//Crea escena
        this.show();
    }

    private void CrearUI() {
        CrearToolbar();
        CrearEscritura();
        CrearTeclado();

        vBoxPrincipal = new VBox();
        vBoxPrincipal.getChildren().addAll(tlbMenu, txtContenido, txtEscritura, vBoxTeclado);
        vBoxPrincipal.setSpacing(10);//Espaciado
        vBoxPrincipal.setPadding(new Insets(10));//Espacio entre el contenido y el contenedor
        escena = new Scene(vBoxPrincipal, 800, 500);
    }

    private void CrearTeclado() {

        vBoxTeclado = new VBox();
        vBoxTeclado.setSpacing(8);//Espaciado vertical

        for(int i=0; i<arHBoxTeclas.length; i++){//Instacia el arreglo para cada linea
            arHBoxTeclas[i] = new HBox();
            arHBoxTeclas[i].setSpacing(10);//Espaciado Horizontal
        }

        for(int i=0; i<arBtnTeclado1.length; i++) {
            arBtnTeclado1[i] = new Button(arLblBtn1[i]);
            arBtnTeclado1[i].setStyle("-fx-background-color: #FFB6C1;");
            arHBoxTeclas[0].getChildren().add(arBtnTeclado1[i]);
        }
        for(int i=0; i< arBtnTeclado2.length; i++) {
            arBtnTeclado2[i] = new Button(arLblBtn2[i]);
            arBtnTeclado2[i].setStyle("-fx-background-color: #FFB6C1;");
            arHBoxTeclas[1].getChildren().add(arBtnTeclado2[i]);
        }
        for(int i=0; i<arBtnTeclado3.length; i++) {
            arBtnTeclado3[i] = new Button(arLblBtn3[i]);
            arBtnTeclado3[i].setStyle("-fx-background-color: #FFB6C1;");
            arHBoxTeclas[2].getChildren().add(arBtnTeclado3[i]);
        }
        for(int i=0; i<arBtnTeclado4.length; i++) {
            arBtnTeclado4[i] = new Button(arLblBtn4[i]);
            arBtnTeclado4[i].setStyle("-fx-background-color: #FFB6C1;");
            arHBoxTeclas[3].getChildren().add(arBtnTeclado4[i]);
        }
        for(int i=0; i<arBtnTeclado5.length; i++) {
            arBtnTeclado5[i] = new Button(arLblBtn5[i]);
            arBtnTeclado5[i].setStyle("-fx-background-color: #FFB6C1;");
            arHBoxTeclas[4].getChildren().add(arBtnTeclado5[i]);
        }
        for(int i=0; i<arBtnTeclado6.length; i++) {
            arBtnTeclado6[i] = new Button(arLblBtn6[i]);
            arBtnTeclado6[i].setStyle("-fx-background-color: #FFB6C1;");
            arHBoxTeclas[5].getChildren().add(arBtnTeclado6[i]);
        }
        vBoxTeclado.getChildren().addAll(arHBoxTeclas[0], arHBoxTeclas[1], arHBoxTeclas[2], arHBoxTeclas[3], arHBoxTeclas[4], arHBoxTeclas[5]);
    }

    private void CrearEscritura() {
        txtContenido = new TextArea();
        txtContenido.setEditable(false);
        txtContenido.setPrefHeight(6);
        txtEscritura = new TextArea();
        txtEscritura.setPrefRowCount(6);
        txtEscritura.setOnKeyPressed(this);
        txtEscritura.setOnKeyReleased(this);
        addEventHandler(KeyEvent.KEY_TYPED,this);
    }

    private void CrearToolbar() {
        tlbMenu = new ToolBar();
        btnAbrir = new Button();//Se le va a cargar una imagen
        btnAbrir.setOnAction(event -> eventoTaqui(1));
        btnAbrir.setPrefSize(35, 35);//Tamaño de la imagen

        //Asignamos la imagen al botón dentro del toolbar
        Image img = new Image("sample/assets/CARPETA.png");//Ruta de imagen para el nodo
        ImageView imv = new ImageView(img);
        imv.setFitHeight(35);
        imv.setPreserveRatio(true);
        btnAbrir.setGraphic(imv);
        tlbMenu.getItems().addAll(btnAbrir);
    }

    private void eventoTaqui(int opc) {
        switch (opc){
            case 1:
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Abrir archivo....");
                fileChooser.setInitialDirectory(new File("C:\\Users\\yareli\\Documents\\ITC\\QUINTO SEMESTRE\\TOPICOS\\PARCIAL 1\\MEMORAMA\\TAQUIMECANOGRÁFO"));
                File file = fileChooser.showOpenDialog(this);//Recibe caracteristicas del archivo
                //El fileChooser ayuda a abrir las carpetas para encontrar los documentos.
            break;
        }
    }

    @Override
    public void handle(KeyEvent event) {
        //System.out.println(event.getCode().toString());
        //Cambiaos el color de las teclas al ser presionadas
        switch (event.getCode().toString()){
            case "ESCAPE":
                if(banColor == false){
                    arBtnTeclado1[0].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[0].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "F1":
                if(banColor == false){
                    arBtnTeclado1[1].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[1].setStyle("-fx-background-color: FFB6C1;");
                }
            break;
            case "F2":
                if(banColor == false){
                    arBtnTeclado1[2].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[2].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "F3":
                if(banColor == false){
                    arBtnTeclado1[3].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[3].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "F4":
                if(banColor == false){
                    arBtnTeclado1[4].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[4].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "F5":
                if(banColor == false){
                    arBtnTeclado1[5].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[5].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "F6":
                if(banColor == false){
                    arBtnTeclado1[6].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[6].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "F7":
                if(banColor == false){
                    arBtnTeclado1[7].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[7].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "F8":
                if(banColor == false){
                    arBtnTeclado1[8].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[8].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "F9":
                if(banColor == false){
                    arBtnTeclado1[9].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[9].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "F10":
                if(banColor == false){
                    arBtnTeclado1[10].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[10].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "F11":
                if(banColor == false){
                    arBtnTeclado1[11].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[11].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "F12":
                if(banColor == false){
                    arBtnTeclado1[12].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[12].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "PRINTSCREEN":
                if(banColor == false){
                    arBtnTeclado1[13].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[13].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "PAUSE":
                if(banColor == false){
                    arBtnTeclado1[14].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[14].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "INSERT":
                if(banColor == false){
                    arBtnTeclado1[15].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[15].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "DELETE":
                if(banColor == false){
                    arBtnTeclado1[16].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado1[16].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            /*case "UNDEFINED":
                if(banColor == false){
                    arBtnTeclado2[0].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado2[0].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;*/
            case "DIGIT1":
                if(banColor == false){
                    arBtnTeclado2[1].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado2[1].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "DIGIT2":
                if(banColor == false){
                    arBtnTeclado2[2].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado2[2].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "DIGIT3":
                if(banColor == false){
                    arBtnTeclado2[3].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado2[3].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "DIGIT4":
                if(banColor == false){
                    arBtnTeclado2[4].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado2[4].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "DIGIT5":
                if(banColor == false){
                    arBtnTeclado2[5].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado2[5].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "DIGIT6":
                if(banColor == false){
                    arBtnTeclado2[6].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado2[6].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "DIGIT7":
                if(banColor == false){
                    arBtnTeclado2[7].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado2[7].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "DIGIT8":
                if(banColor == false){
                    arBtnTeclado2[8].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado2[8].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "DIGIT9":
                if(banColor == false){
                    arBtnTeclado2[9].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado2[9].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "DIGIT0":
                if(banColor == false){
                    arBtnTeclado2[10].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado2[10].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            case "QUOTE":
                if(banColor == false){
                    arBtnTeclado2[11].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado2[11].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;
            /*case "UNDEFINED":
                if(banColor == false){
                    arBtnTeclado2[1].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado2[1].setStyle("-fx-background-color: #FFB6C1;");
                }
                break;*/
            case "BACK_SPACE":
                if(banColor == false){
                    arBtnTeclado2[13].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado2[13].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "TAB":
                if(banColor == false){
                    arBtnTeclado3[0].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado3[0].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "Q":
                if(banColor == false){
                    arBtnTeclado3[1].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado3[1].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "W":
                if(banColor == false){
                    arBtnTeclado3[2].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado3[2].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "E":
                if(banColor == false){
                    arBtnTeclado3[3].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado3[3].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "R":
                if(banColor == false){
                    arBtnTeclado3[4].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado3[4].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "T":
                if(banColor == false){
                    arBtnTeclado3[5].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado3[5].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "Y":
                if(banColor == false){
                    arBtnTeclado3[6].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado3[6].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "U":
                if(banColor == false){
                    arBtnTeclado3[7].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado3[7].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "I":
                if(banColor == false){
                    arBtnTeclado3[8].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado3[8].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "O":
                if(banColor == false){
                    arBtnTeclado3[9].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado3[9].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "P":
                if(banColor == false){
                    arBtnTeclado3[10].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado3[10].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "DEAD_ACUTE":
                if(banColor == false){
                    arBtnTeclado3[11].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado3[11].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "PLUS":
                if(banColor == false){
                    arBtnTeclado3[12].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado3[12].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "ENTER":
                if(banColor == false){
                    arBtnTeclado3[13].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado3[13].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "CAPS" :
                if(banColor == false){
                    arBtnTeclado4[0].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado4[0].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "A" :
                if(banColor == false){
                    arBtnTeclado4[1].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado4[1].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "S" :
                if(banColor == false){
                    arBtnTeclado4[2].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado4[2].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "D" :
                if(banColor == false){
                    arBtnTeclado4[3].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado4[3].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "F" :
                if(banColor == false){
                    arBtnTeclado4[4].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado4[4].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "G" :
                if(banColor == false){
                    arBtnTeclado4[5].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado4[5].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "H" :
                if(banColor == false){
                    arBtnTeclado4[6].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado4[6].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "J" :
                if(banColor == false){
                    arBtnTeclado4[7].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado4[7].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "K" :
                if(banColor == false){
                    arBtnTeclado4[8].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado4[8].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "L" :
                if(banColor == false){
                    arBtnTeclado4[9].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado4[9].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "Ñ" :
                if(banColor == false){
                    arBtnTeclado4[10].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado4[10].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "BRACELEFT" :
                if(banColor == false){
                    arBtnTeclado4[11].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado4[11].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "BRACERIGHT" :
                if(banColor == false){
                    arBtnTeclado4[12].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado4[12].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "SHIFT" :
                if(banColor == false){
                    arBtnTeclado5[0].setStyle("-fx-background-color: #85D4D6;");
                    arBtnTeclado5[12].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado5[0].setStyle("-fx-background-color: #FFB6C1;");
                    arBtnTeclado5[12].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "LESS" :
                if(banColor == false){
                    arBtnTeclado5[1].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado5[1].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "Z" :
                if(banColor == false){
                    arBtnTeclado5[2].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado5[2].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "X" :
                if(banColor == false){
                    arBtnTeclado5[3].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado5[3].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "C" :
                if(banColor == false){
                    arBtnTeclado5[4].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado5[4].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "V" :
                if(banColor == false){
                    arBtnTeclado5[5].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado5[5].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "B" :
                if(banColor == false){
                    arBtnTeclado5[6].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado5[6].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "N" :
                if(banColor == false){
                    arBtnTeclado5[7].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado5[7].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "M" :
                if(banColor == false){
                    arBtnTeclado5[8].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado5[8].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "COMMA" :
                if(banColor == false){
                    arBtnTeclado5[9].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado5[9].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "PERIOD" :
                if(banColor == false){
                    arBtnTeclado5[10].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado5[10].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "MINUS" :
                if(banColor == false){
                    arBtnTeclado5[11].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado5[11].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "CONTROL" :
                if(banColor == false){
                    arBtnTeclado6[0].setStyle("-fx-background-color: #85D4D6;");
                    arBtnTeclado6[7].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado6[0].setStyle("-fx-background-color: #FFB6C1;");
                    arBtnTeclado6[7].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "WINDOWS" :
                if(banColor == false){
                    arBtnTeclado6[2].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado6[2].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "ALT" :
                if(banColor == false){
                    arBtnTeclado6[3].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado6[3].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "SPACE" :
                if(banColor == false){
                    arBtnTeclado6[4].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado6[4].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
            case "CONTEXT_MENU" :
                if(banColor == false){
                    arBtnTeclado6[6].setStyle("-fx-background-color: #85D4D6;");
                }
                else{
                    arBtnTeclado6[6].setStyle("-fx-background-color: #FFB6C1;");
                }
            break;
        }
        banColor = !banColor;
    }
}
//getCharated -> regresa la letra
//getCode -> Detecta la tecla especifica