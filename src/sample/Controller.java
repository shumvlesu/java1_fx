package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Random;

public class Controller {

    @FXML
    private TextField numberImputField;

    @FXML
    private Label randomNumberLabel;

    //если надо выполнить какое-то событие при открытие окна то используем зарезервированое initialize()
    @FXML
    public void initialize() {

    }

    //наш обработчик события
    @FXML
    void doRandomAction() {
        Random random = new Random();
        String message = numberImputField.getText(); //получаю значение в виде текста из поля с id numberImputField
        numberImputField.clear();

        if (!message.isBlank()) {
            try {
                int number = Integer.parseInt(message); //преобразую из строки в тип int
                int randomNumber = random.nextInt(number + 1);
                randomNumberLabel.setText(String.valueOf(randomNumber));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                var alert = new Alert(Alert.AlertType.ERROR,"Введите число!");
                alert.setTitle("Ошибка ввода данных");
                alert.show();
            }
        }

    }

}
