/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.vse.java.holj13.adventura.main;



import cz.vse.java.holj13.adventura.logika.Hra;
import cz.vse.java.holj13.adventura.logika.IHra;
import cz.vse.java.holj13.adventura.uiText.TextoveRozhrani;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/*******************************************************************************
 * Třída {@code Start} je hlavní třídou projektu,
 * který ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class Start extends Application
{
    /***************************************************************************
     * Metoda, prostřednictvím níž se spouští celá aplikace.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
        
      //  IHra hra = new Hra();
      //  TextoveRozhrani ui = new TextoveRozhrani(hra);
      //  ui.hraj();
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.show();
    }
}
