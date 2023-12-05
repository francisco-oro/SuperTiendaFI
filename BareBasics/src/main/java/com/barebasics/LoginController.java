/*
 * Copyright (c) 2023.
 */

package com.barebasics;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}