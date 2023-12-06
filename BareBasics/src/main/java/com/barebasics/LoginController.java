/*
 * Copyright (c) 2023.
 */

package com.barebasics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Hyperlink admin_client_hyperlink;

    @FXML
    private Hyperlink admin_employee_hyperlink;

    @FXML
    private AnchorPane admin_form;

    @FXML
    private Button admin_loginbtn;

    @FXML
    private PasswordField admin_password;

    @FXML
    private TextField admin_username;

    @FXML
    private Hyperlink customer_admin_hyperlink;

    @FXML
    private Hyperlink customer_employee_hyperlink;

    @FXML
    private AnchorPane customer_form;

    @FXML
    private Button customer_loginbtn;

    @FXML
    private PasswordField customer_password;

    @FXML
    private TextField customer_username;

    @FXML
    private Hyperlink employee_admin_hyperlink;

    @FXML
    private Hyperlink employee_customer_hyperlink;

    @FXML
    private AnchorPane employee_form;

    @FXML
    private Button employee_loginbtn;

    @FXML
    private PasswordField employee_password;

    @FXML
    private TextField employee_username;

    public void close(){
        System.exit(0);
    }

//    DATABASE TOOS
    private Connection connect;
    private ResultSet result;
    private PreparedStatement prepare;

    public void customerLogin(){
        String employeeData = "SELECT * FROM customer WHERE customer_id = ? and password = ?";

        connect = database.connectDb();

        try {
            Alert alert;
            prepare = connect.prepareStatement(employeeData);

            if (customer_username.getText().isEmpty() ||
                    customer_password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mensaje de error");
                alert.setHeaderText(null);
                alert.setContentText("Por favor llena todos los campos vacíos");
                alert.showAndWait();
            } else {
                prepare.setString(1, customer_username.getText());
                prepare.setString(2, customer_password.getText());

                result = prepare.executeQuery();

                if (result.next()){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Mensaje informativo");
                    alert.setHeaderText(null);
                    alert.setContentText("Ha iniciado sesión exitosamente");
                    alert.showAndWait();

                    customer_loginbtn.getScene().getWindow().hide();

                    Parent root = FXMLLoader.load(getClass().getResource("customerDashboard.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Mensaje de error");
                    alert.setHeaderText(null);
                    alert.setContentText("ID de Socio / Contraseña errónea");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void employeeLogin(){
        String employeeData = "SELECT * FROM employee WHERE employee_id = ? and password = ?";

        connect = database.connectDb();

        try {
            Alert alert;
            prepare = connect.prepareStatement(employeeData);

            if (employee_username.getText().isEmpty() ||
            employee_password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mensaje de error");
                alert.setHeaderText(null);
                alert.setContentText("Por favor llena todos los campos vacíos");
                alert.showAndWait();
            } else {
                prepare.setString(1, employee_username.getText());
                prepare.setString(2, employee_password.getText());

                result = prepare.executeQuery();

                if (result.next()){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Mensaje informativo");
                    alert.setHeaderText(null);
                    alert.setContentText("Ha iniciado sesión exitosamente");
                    alert.showAndWait();

                    employee_loginbtn.getScene().getWindow().hide();

                    Parent root = FXMLLoader.load(getClass().getResource("employeeDashboard.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Mensaje de error");
                    alert.setHeaderText(null);
                    alert.setContentText("ID de Empleado / Contraseña errónea");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void adminLogin() {
        String adminData = "SELECT * FROM admin WHERE username = ? and password = ?";

        connect = database.connectDb();

        try {
            Alert alert;

//            Check if the textfields are empty or not
            if (admin_username.getText().isEmpty()
            || admin_password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mensaje de error");
                alert.setHeaderText(null);
                alert.setContentText("Por favor llene todos los campos en blanco");
                alert.showAndWait();
            }

            prepare = connect.prepareStatement(adminData);
            prepare.setString(1, admin_username.getText());
            prepare.setString(2, admin_password.getText());

            result = prepare.executeQuery();

            if (result.next()){
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje informativo");
                alert.setHeaderText(null);
                alert.setContentText("Inicio de sesión exitoso");
                alert.showAndWait();

                admin_loginbtn.getScene().getWindow().hide();

                Parent root = FXMLLoader.load(getClass().getResource("adminDashboard.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mensaje de error");
                alert.setHeaderText(null);
                alert.setContentText("Usuario o contraseña no son correctos");
                alert.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchForm(ActionEvent event){
        if (event.getSource() == admin_client_hyperlink) {
            admin_form.setVisible(false);
            customer_form.setVisible(true);
        } else if (event.getSource() == admin_employee_hyperlink){
            admin_form.setVisible(false);
            employee_form.setVisible(true);
        } else if (event.getSource() == employee_admin_hyperlink) {
            employee_form.setVisible(false);
            admin_form.setVisible(true);
        } else if (event.getSource() == employee_customer_hyperlink) {
            employee_form.setVisible(false);
            customer_form.setVisible(true);
        } else if (event.getSource() == customer_admin_hyperlink) {
            customer_form.setVisible(false);
            admin_form.setVisible(true);
        } else if (event.getSource() == customer_employee_hyperlink) {
            customer_form.setVisible(false);
            employee_form.setVisible(true);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}