package sample.ui;

import javafx.stage.Stage;
import sample.models.PlatillosDAO;
import javax.swing.text.TabableView;

public class Dashboard extends Stage {

    public Dashboard(){
        CrearUI();
        this.setTitle("Panel de Administración del Restaurante El Antojito :)");
        this.show();

        new PlatilloCRUD();
    }

    private void CrearUI() {

    }
}
