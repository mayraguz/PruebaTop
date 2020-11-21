package sample.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.PlatillosDAO;
import sample.models.TipoPlatilloDAO;

public class FrmTipoPlatillos extends Stage {

    private TextField txtTipoPlatillo;
    private ComboBox<TipoPlatilloDAO> cbxTipo;
    private Button btnGuardar;
    private VBox vBox;
    private Scene escena;
    private TipoPlatilloDAO objTipoPlatillo;
    private TableView<TipoPlatilloDAO> tbvTipoPlatillos;

    public FrmTipoPlatillos(TableView<TipoPlatilloDAO> tbvTipoPlatillos, TipoPlatilloDAO objTipoPlatillo){

        if( objTipoPlatillo != null )
            this.objTipoPlatillo = objTipoPlatillo;
        else
            this.objTipoPlatillo = new TipoPlatilloDAO();

        CrearUI();
        this.setTitle("Gestión de Platillos");
        this.setScene(escena);
        this.show();

        this.tbvTipoPlatillos = tbvTipoPlatillos;
    }

    private void CrearUI() {
        txtTipoPlatillo = new TextField();
        txtTipoPlatillo.setText(objTipoPlatillo.getDsc_tipo());

        btnGuardar = new Button("Guardar el Tipo de Platillo");
        btnGuardar.setOnAction(event -> Guardar());
        vBox = new VBox();
        vBox.getChildren().addAll(txtTipoPlatillo,btnGuardar);
        escena = new Scene(vBox,250,250);

    }

    private void Guardar() {

        objTipoPlatillo.setDsc_tipo(txtTipoPlatillo.getText());

        if( objTipoPlatillo.getId_tipo() >= 1 ) { // PROCESO DE NUEVO PLATILLO
            objTipoPlatillo.updTipo();
        }else {                     // PROCESO PARA ACTUALIZAR EL PLATILLO
            objTipoPlatillo.updTipo();
        }

        tbvTipoPlatillos.setItems(objTipoPlatillo.getAllTipo());
        tbvTipoPlatillos.refresh();
        this.close();

    }

}
