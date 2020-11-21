package sample.components;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.models.TipoPlatilloDAO;

public class ButtonCustomeT extends TableCell<TipoPlatilloDAO, String> {
    private Button btnCelda;

    public ButtonCustomeT(){
        btnCelda = new Button("Editar");
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty){
            setGraphic(btnCelda);
        }
    }
}