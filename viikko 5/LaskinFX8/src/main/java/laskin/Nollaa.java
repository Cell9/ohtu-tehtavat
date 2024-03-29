package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        sovellus.nollaa();

        int tulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + tulos);

        nollaa.disableProperty().set(true);
    }

    @Override
    public void peru() {

    }
}