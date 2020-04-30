package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class ConversorController implements Initializable {

  @FXML
  private TableView<Dada> taula;

  @FXML
  private TextField entrada;

  @FXML
  protected void operar(ActionEvent event) {
    ObservableList<Dada> dades = taula.getItems();
    String euros = entrada.getText();
    double e = Double.parseDouble(euros);
    double dolares = e * 1.12;
    double libras = e * 0.86;
    dades.add(new Dada("€", euros));
    dades.add(new Dada("$", String.valueOf(dolares)));
    dades.add(new Dada("£", String.valueOf(libras)));
    entrada.setText("");
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }
}