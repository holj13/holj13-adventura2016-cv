package cz.vse.java.holj13.adventura.logika;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {


    private IHra hra;

    public Label jmenoLokace;
    public Label popisLokace;
    public ImageView obrazekLokace;


    public void setHra(IHra hra) {
        this.hra = hra;
        HerniPlan herniPlan = hra.getHerniPlan();
        Prostor aktualniProstor = herniPlan.getAktualniProstor();

        popisLokace.setText(aktualniProstor.getPopis());
        jmenoLokace.setText(aktualniProstor.getNazev());

        String nazevObrazku = "/" + aktualniProstor.getNazev() + ".jpg";
        Image image = new Image(getClass().getResourceAsStream(nazevObrazku));
        obrazekLokace.setImage(image);
    }

}

