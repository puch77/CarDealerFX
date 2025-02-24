package t3FX_D6;

import java.net.URI;
import java.nio.file.Path;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Details extends Dialog<ButtonType>{

	private Label modell = new Label("Modell");
	private Label km = new Label("km");
	private Label ersatzzulassung = new Label("Ersatzzulassung");
	private Label ps = new Label("PS");
	private Label preis = new Label("Preis");
	private Label bemerkung = new Label("Bemerkung");
	
	public Details(Auto auto) {
		this.setTitle("Details des Auto");
		Label modellDetails = new Label();
		modellDetails.setText(auto.getModell());
		Label kmDetails = new Label();
		kmDetails.setText(String.valueOf(auto.getKm()));
		Label ersatzzulassungDetails = new Label();
		ersatzzulassungDetails.setText(auto.getErstZulassung());
		Label psDetails = new Label();
		psDetails.setText(String.valueOf(auto.getPs()));
		Label preisDetails = new Label();
		preisDetails.setText(String.valueOf(auto.getPreis()));
		Label bemerkungDetails = new Label();
		bemerkungDetails.setText(auto.getBemerkung());
		
		Label lblBild = new Label();
		URI uri = Path.of(auto.getBildPfad()).toUri();
		ImageView iv = new ImageView(uri.toString());
		iv.setFitWidth(450);
		iv.setPreserveRatio(true);
		lblBild.setGraphic(iv);
		
		VBox vb = new VBox(10, modell, km, ersatzzulassung, ps, preis, bemerkung);
		vb.setPadding(new Insets(5));
		
		VBox vbData = new VBox(10, modellDetails, kmDetails, ersatzzulassungDetails, psDetails, preisDetails, bemerkungDetails);
		vbData.setPadding(new Insets(5));
		
		HBox hb = new HBox(10, lblBild, vb, vbData);
		hb.setPadding(new Insets(5));
		

		this.getDialogPane().setContent(hb);
		this.getDialogPane().getButtonTypes().
			add(new ButtonType("Beenden", ButtonData.CANCEL_CLOSE));
	}
}
