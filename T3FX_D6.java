package t3FX_D6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T3FX_D6 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Label lbl = new Label("Wählen Sie den Typ aus");
		lbl.setPrefWidth(150);

		ComboBox<String> cb = new ComboBox<>();
		cb.getItems().addAll("Limousine", "SUV", "Sportwagen");
		cb.setVisibleRowCount(3);

		ListView<Auto> autoListView = new ListView<>();
		ObservableList<Auto> sportwagenAutos = FXCollections.observableArrayList(
				new Auto("Lamborghini Huracan", 9400, 640, 309800.0, "4/2018", "Top gepflegt", ".\\resources\\lamborghini.jpg"),
				new Auto("Ferrari 812 Superfast", 12000, 800, 449880.0, "7/2020", "Top gepflegt", ".\\resources\\ferrari.jpg"),
				new Auto("Mercedes AMG GT", 22000, 480, 162900.0, "7/2017", "Sehr gut zustand", ".\\resources\\mercedes.jpg"));
		ObservableList<Auto> limousineAutos = FXCollections.observableArrayList(
				new Auto("Model X", 19400, 440, 109800.0, "8/2019", "Nett", ".\\resources\\limo1.jpg"),
				new Auto("Model Y", 16700, 300, 149880.0, "11/2020", "Top gepflegt", ".\\resources\\limo2.jpg"),
				new Auto("Model Z", 220000, 280, 102900.0, "12/2019", "Sehr gut zustand", ".\\resources\\limo3.jpg"));
		ObservableList<Auto> suvAutos = FXCollections.observableArrayList(
				new Auto("SUV TX", 40000, 440, 61800.0, "1/2016", "Top gepflegt", ".\\resources\\suv1.jpg"),
				new Auto("SUV BMX", 100000, 510, 80880.0, "3/2020", "Top gepflegt", ".\\resources\\suv2.jpg"),
				new Auto("SUV GT", 12700, 360, 92900.0, "7/2021", "Gut zustand", ".\\resources\\suv3.jpg"));

		cb.setOnAction(e -> {
			String selectedType = cb.getValue();
			System.out.println(selectedType);
			switch (selectedType) {
				case "Limousine":
					autoListView.setItems(limousineAutos);
					break;
				case "SUV":
					autoListView.setItems(suvAutos);
					break;
				case "Sportwagen":
					autoListView.setItems(sportwagenAutos);
					break;
				default:
					autoListView.setItems(FXCollections.emptyObservableList());
			}
		});

		autoListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				new Details(newValue).showAndWait();
			}
		});

		VBox vb = new VBox(10, lbl, cb, autoListView);
		vb.setPadding(new Insets(5));
		arg0.setScene(new Scene(vb));
		arg0.setTitle("T3FX_D6");
		arg0.show();
	}

}
