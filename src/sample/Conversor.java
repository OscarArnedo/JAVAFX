package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.concurrent.CountDownLatch;

public class Conversor extends Application {

  public static final CountDownLatch latch = new CountDownLatch(1);
  public static Conversor startUpTest = null;

  public static Conversor waitForStartUpTest() {
    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return startUpTest;
  }

  public static void setStartUpTest(Conversor startUpTest0) {
    startUpTest = startUpTest0;
    latch.countDown();
  }

  public Conversor() {
    setStartUpTest(this);
  }

  public void printSomething() {
    System.out.println("----------Abriendo conversor de moneda----------");
  }

  @Override
  public void start(Stage stage) throws Exception {
    Parent arrel = FXMLLoader.load(getClass().getResource("Conversor.fxml"));

    stage.setTitle("Conversor");
    stage.setScene(new Scene(arrel));
    stage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }

}