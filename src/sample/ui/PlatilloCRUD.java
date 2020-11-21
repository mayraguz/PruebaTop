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
import sample.models.PlatillosDAO;


public class PlatilloCRUD extends Stage {

    private VBox vBox;
    private TableView<PlatillosDAO> tbvplatillos;
    private Button btnNuevo;
    private Scene escena;
    private PlatillosDAO objPDAO;

    public PlatilloCRUD(){
        objPDAO = new PlatillosDAO();
        CrearUI();

        this.setTitle("Administración de Platillos");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        tbvplatillos = new TableView<>();
        CrearTabla();
        btnNuevo = new Button("Nuevo Platillo");
        btnNuevo.setOnAction(event -> AgregarPlatillo());
        vBox = new VBox();
        vBox.getChildren().addAll(tbvplatillos, btnNuevo);
        escena = new Scene(vBox, 300, 250);
    }

    private void AgregarPlatillo() {
    }

    private void CrearTabla() {
        //Aqui hacermos la estructura grafica para que se almacenen los datos desde la Base de Datos
        TableColumn<PlatillosDAO, Integer> tbcIdPlatillo = new TableColumn<>("ID");
        tbcIdPlatillo.setCellValueFactory(new PropertyValueFactory<>("id_platillo"));//Es el elemnto que se mostrará en la columna

        TableColumn<PlatillosDAO, String> tbcNomPlatillo = new TableColumn<>("Nombre Platillo");
        tbcNomPlatillo.setCellValueFactory(new PropertyValueFactory<>("nombre_paltillo"));

        TableColumn<PlatillosDAO, Float> tbcPrecioPlatillo = new TableColumn<>("Precio");
        tbcPrecioPlatillo.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<PlatillosDAO,String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(
            new Callback<TableColumn<PlatillosDAO, String>, TableCell<PlatillosDAO, String>>() {
                @Override
                public TableCell<PlatillosDAO, String> call(TableColumn<PlatillosDAO, String> param) {
                    return new ButtonCustome();
                }
            }
        );

        TableColumn<PlatillosDAO,String> tbcBorrar = new TableColumn<>("Borrar");
        tbcBorrar.setCellFactory(
            new Callback<TableColumn<PlatillosDAO, String>, TableCell<PlatillosDAO, String>>() {
                @Override
                public TableCell<PlatillosDAO, String> call(TableColumn<PlatillosDAO, String> param) {
                    return new ButtonCustome();
                }
            }
        );

        tbvplatillos.getColumns().addAll(tbcIdPlatillo, tbcNomPlatillo, tbcPrecioPlatillo, tbcEditar, tbcBorrar);
        tbvplatillos.setItems(objPDAO.getAllPlatillo());
    }
}
