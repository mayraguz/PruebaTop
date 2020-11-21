package sample.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.components.ButtonCustome;
import sample.components.ButtonCustomeT;
import sample.models.PlatillosDAO;
import sample.models.TipoPlatilloDAO;

public class TipoPlatilloCRUD extends Stage {
    private VBox vBox;
    private TableView<TipoPlatilloDAO> tbvTipoplatillos;
    private Button btnNuevo;
    private Scene escena;
    private TipoPlatilloDAO objTPDAO;

    public TipoPlatilloCRUD(){
        objTPDAO = new TipoPlatilloDAO();
        CrearUI();

        this.setTitle("Administración de Platillos");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        tbvTipoplatillos = new TableView<>();
        CrearTabla();
        btnNuevo = new Button("Nuevo Platillo");
        btnNuevo.setOnAction(event -> AgregarTipoPlatillo());
        vBox = new VBox();
        vBox.getChildren().addAll(tbvTipoplatillos, btnNuevo);
        escena = new Scene(vBox, 300, 250);

    }

    private void AgregarTipoPlatillo() {
    }

    private void CrearTabla() {
        TableColumn<TipoPlatilloDAO, Integer> tbcIdTipo = new TableColumn<>("ID");
        tbcIdTipo.setCellValueFactory(new PropertyValueFactory<>("id_tipo"));//Es el elemnto que se mostrará en la columna

        TableColumn<TipoPlatilloDAO, String> tbcDscTipo = new TableColumn<>("Tipo Platillo");
        tbcDscTipo.setCellValueFactory(new PropertyValueFactory<>("dsc_tipo"));

        TableColumn<TipoPlatilloDAO, String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(
            new Callback<TableColumn<TipoPlatilloDAO, String>, TableCell<TipoPlatilloDAO, String>>() {
                @Override
                public TableCell<TipoPlatilloDAO, String> call(TableColumn<TipoPlatilloDAO, String> param) {
                    return new ButtonCustomeT();
                }
            }
        );

        TableColumn<TipoPlatilloDAO, String> tbcBorrar = new TableColumn<>("Borrar");
        tbcBorrar.setCellFactory(
            new Callback<TableColumn<TipoPlatilloDAO, String>, TableCell<TipoPlatilloDAO, String>>() {
                @Override
                public TableCell<TipoPlatilloDAO, String> call(TableColumn<TipoPlatilloDAO, String> param) {
                    return new ButtonCustomeT();
                }
            }
        );

        tbvTipoplatillos.getColumns().addAll(tbcIdTipo, tbcDscTipo, tbcEditar, tbcBorrar);
        tbvTipoplatillos.setItems(objTPDAO.getAllTipo());
    }

}
