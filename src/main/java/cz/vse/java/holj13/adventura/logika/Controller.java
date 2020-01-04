package cz.vse.java.holj13.adventura.logika;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller {
    public static final int SIRKA_IKONY = 45;
    public static final int VYSKA_IKONY = 30;

    @FXML
    public VBox seznamVychodu;
    @FXML
    public VBox seznamPredmetuVMistnosti;
    @FXML
    public VBox seznamPredmetuVBatohu;
    private IHra hra;

    @FXML
    public Label jmenoLokace;
    @FXML
    public Label popisLokace;

    public ImageView obrazekLokace;


    public void setHra(IHra hra) {
        this.hra = hra;
        HerniPlan herniPlan = hra.getHerniPlan();
        Prostor aktualniProstor = herniPlan.getAktualniProstor();
        zmenProstor(aktualniProstor);
    }

    private void zmenProstor(Prostor prostor){
        hra.zpracujPrikaz("jdi" + prostor.getNazev());
        System.out.println(hra.getHerniPlan().getAktualniProstor().getNazev());

        popisLokace.setText(prostor.getPopis());
        jmenoLokace.setText(prostor.getNazev());

        String nazevObrazku = "/" + prostor.getNazev() + ".jpg";
        Image image = new Image(getClass().getResourceAsStream(nazevObrazku));
        obrazekLokace.setImage(image);

        pridejPredmety(prostor);
        pridejVychody(prostor);
    }

    private void pridejPredmety(Prostor prostor){
        seznamPredmetuVMistnosti.getChildren().clear();

        for (Vec vec : prostor.getSeznamVeci()) {
            pridejPredmetDoMisnosti(vec);
        }
    }

    private void pridejVychody(Prostor prostor){
        seznamVychodu.getChildren().clear();

        for (Prostor p : prostor.getVychody()){
            HBox vychod = new HBox();
            vychod.setSpacing(10);
            Label nazevProstoru = new Label(p.getNazev());

            ImageView vychodImageView = new ImageView();
            Image vychodImage = new Image(getClass().getClassLoader().getResourceAsStream(p.getNazev() + ".jpg"));
            vychodImageView.setFitHeight(VYSKA_IKONY);
            vychodImageView.setFitWidth(SIRKA_IKONY);
            vychodImageView.setImage(vychodImage);

            vychod.getChildren().addAll(vychodImageView, nazevProstoru);

            seznamVychodu.getChildren().add(vychod);
            vychod.setOnMouseClicked(event ->{
                zmenProstor(p);
            });
        }

    }

    //sdffsdfdsgndsknwegwe54444444

    private void pridejPredmetDoMisnosti(Vec vec){
        Label nazevVeci = new Label(vec.getJmeno());
        seznamPredmetuVMistnosti.getChildren().add(nazevVeci);
        nazevVeci.setOnMouseClicked(event -> {
            if (vec.jePrenositelna()) {
                hra.zpracujPrikaz("seber" + vec.getJmeno());
                Label vecVBatohu = new Label(vec.getJmeno());
                seznamPredmetuVBatohu.getChildren().add(vecVBatohu);
                seznamPredmetuVMistnosti.getChildren().remove(nazevVeci);

                vecVBatohu.setOnMouseClicked(event1 -> {
                    hra.zpracujPrikaz("poloz" + vec.getJmeno());
                    seznamPredmetuVBatohu.getChildren().remove(vecVBatohu);
                    pridejPredmetDoMisnosti(vec);
                });
            }
        });

    }

}

