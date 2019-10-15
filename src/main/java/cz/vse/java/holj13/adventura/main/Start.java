/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.vse.java.holj13.adventura.main;



import cz.vse.java.holj13.adventura.logika.Hra;
import cz.vse.java.holj13.adventura.logika.IHra;
import cz.vse.java.holj13.adventura.logika.Controller;
import cz.vse.java.holj13.adventura.uiText.TextoveRozhrani;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.InputStream;

import java.net.URL;


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
        if(args.length > 0 && args[0].equals("text")) {
            IHra hra = new Hra();
            TextoveRozhrani ui = new TextoveRozhrani(hra);
            ui.hraj();
        } else {
            launch(args);
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/scena.fxml"));
        Parent rootComponent = loader.load();

        Scene scene = new Scene(rootComponent);
        primaryStage.setScene(scene);

        IHra hra = new Hra();
        Controller controller = loader.getController();
        controller.setHra(hra);

        primaryStage.setTitle("Karkulčino dobrodružství");
        InputStream iconStream = getClass().getResourceAsStream("/4.png");
        Image icon = new Image(iconStream);
        primaryStage.getIcons().add(icon);
        primaryStage.show();
    }
}
