package com.barebasics;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

public class adminDashBoardController implements Initializable {

    @FXML
    private Button addProduct_addBtn;

    @FXML
    private TextField addProduct_amount;

    @FXML
    private TextField addProduct_brand;

    @FXML
    private ComboBox<Category> addProduct_category;

    @FXML
    private Button addProduct_clearBtn;

    @FXML
    private TextField addProduct_code;

    @FXML
    private TableColumn<productData, String> addProduct_col_availableStock;

    @FXML
    private TableColumn<productData, String> addProduct_col_brand;

    @FXML
    private TableColumn<productData, String> addProduct_col_category;

    @FXML
    private TableColumn<productData, String> addProduct_col_code;

    @FXML
    private TableColumn<productData, String> addProduct_col_cost;

    @FXML
    private TableColumn<productData, String> addProduct_col_lastUpdated;

    @FXML
    private TableColumn<productData, String> addProduct_col_name;

    @FXML
    private TextField addProduct_cost;

    @FXML
    private Button addProduct_deleteBtn;

    @FXML
    private AnchorPane addProduct_form;

    @FXML
    private TextField addProduct_name;

    @FXML
    private TextField addProduct_searchBar;

    @FXML
    private TableView<productData> addProduct_tableView;

    @FXML
    private Button addProduct_updateBtn;

    @FXML
    private Button addProducts_btn;

    @FXML
    private FontAwesomeIconView close;

    @FXML
    private Label dashboard_activeEmployees;

    @FXML
    private Button dashboard_btn;

    @FXML
    private AreaChart<?, ?> dashboard_chart;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label dashboard_incomeToday;

    @FXML
    private Label dashboard_incomeTotal;

    @FXML
    private TextField deposit_amount;

    @FXML
    private Button deposit_btn;

    @FXML
    private ComboBox<?> deposit_category;

    @FXML
    private TableColumn<?, ?> deposit_col_amount;

    @FXML
    private TableColumn<?, ?> deposit_col_category;

    @FXML
    private TableColumn<?, ?> deposit_col_date;

    @FXML
    private TableColumn<?, ?> deposit_col_reference;

    @FXML
    private TableColumn<?, ?> deposit_col_username;

    @FXML
    private Button deposit_confirm;

    @FXML
    private DatePicker deposit_date;

    @FXML
    private AnchorPane deposit_form;

    @FXML
    private TextField deposit_referenceNumber;

    @FXML
    private TableView<?> deposit_tableView;

    @FXML
    private Button employees_btn;

    @FXML
    private Button employees_clearBtn;

    @FXML
    private TableColumn<?, ?> employees_co_store;

    @FXML
    private TableColumn<?, ?> employees_col_date;

    @FXML
    private TableColumn<?, ?> employees_col_employeeID;

    @FXML
    private TableColumn<?, ?> employees_col_firstName;

    @FXML
    private TableColumn<?, ?> employees_col_gender;

    @FXML
    private TableColumn<?, ?> employees_col_lastName;

    @FXML
    private TableColumn<?, ?> employees_col_username;

    @FXML
    private Button employees_deleteBtn;

    @FXML
    private TextField employees_employeeID;

    @FXML
    private TextField employees_firstName;

    @FXML
    private AnchorPane employees_form;

    @FXML
    private ComboBox<?> employees_gender;

    @FXML
    private TextField employees_lastName;

    @FXML
    private TextField employees_password;

    @FXML
    private Button employees_saveBtn;

    @FXML
    private ComboBox<?> employees_store;

    @FXML
    private TableView<?> employees_tableView;

    @FXML
    private Button employees_updateBtn;

    @FXML
    private Button logout;

    @FXML
    private Button minimize;

    @FXML
    private Button orders_addProductBtn;

    @FXML
    private Button orders_btn;

    @FXML
    private Button orders_cancelBtn;

    @FXML
    private Button orders_clearProductBtn;

    @FXML
    private TableColumn<?, ?> orders_col_date;

    @FXML
    private TableColumn<?, ?> orders_col_employee;

    @FXML
    private TableColumn<?, ?> orders_col_orderId;

    @FXML
    private TableColumn<?, ?> orders_col_status;

    @FXML
    private TableColumn<?, ?> orders_col_store;

    @FXML
    private Button orders_confirmBtn;

    @FXML
    private Button orders_deleteProductBtn;

    @FXML
    private AnchorPane orders_form;

    @FXML
    private TableView<?> orders_newOrder__TableView;

    @FXML
    private TableColumn<?, ?> orders_newOrder__col_amount;

    @FXML
    private TableColumn<?, ?> orders_newOrder__col_availableStock;

    @FXML
    private TableColumn<?, ?> orders_newOrder__col_name;

    @FXML
    private TableColumn<?, ?> orders_newOrder__col_orderId;

    @FXML
    private TextField orders_productAmount;

    @FXML
    private TextField orders_productId;

    @FXML
    private TextField orders_productName;

    @FXML
    private Button orders_saveProductBtn;

    @FXML
    private ComboBox<?> orders_store;

    @FXML
    private TableView<?> orders_tableView;

    @FXML
    private Button profile_btn;

    @FXML
    private TextField profile_email;

    @FXML
    private TextField profile_firstName;

    @FXML
    private AnchorPane profile_form;

    @FXML
    private TextField profile_lastName;

    @FXML
    private PasswordField profile_password;

    @FXML
    private TextField profile_phone;

    @FXML
    private Button profile_updateBtn;

    @FXML
    private PasswordField profile_username;

    @FXML
    private Button sales_btn;

    @FXML
    private BarChart<?, ?> sales_chart_TotalSales;

    @FXML
    private BarChart<?, ?> sales_chart_salesPerPerson;

    @FXML
    private BarChart<?, ?> sales_chart_salesPerProduct;

    @FXML
    private BarChart<?, ?> sales_chart_salesPerStore;

    @FXML
    private AnchorPane sales_form;

    @FXML
    private Button store_addBtn;

    @FXML
    private TextField store_address;

    @FXML
    private Button store_clearBtn;

    @FXML
    private TableColumn<?, ?> store_col_address;

    @FXML
    private TableColumn<?, ?> store_col_delete;

    @FXML
    private TableColumn<?, ?> store_col_email;

    @FXML
    private TableColumn<?, ?> store_col_name;

    @FXML
    private TableColumn<?, ?> store_col_phone;

    @FXML
    private TextField store_email;

    @FXML
    private AnchorPane stores_form;

    @FXML
    private TextField store_name;

    @FXML
    private TextField store_phone;

    @FXML
    private Button store_removeBtn;

    @FXML
    private TableView<?> store_tableView;

    @FXML
    private Button store_updateBtn;

    @FXML
    private Button stores_btn;

    @FXML
    private Label username;

    @FXML
    private TextField withdrawal_amount;

    @FXML
    private TextField withdrawal_availableAmount;

    @FXML
    private Button withdrawal_btn;

    @FXML
    private ComboBox<?> withdrawal_category;

    @FXML
    private TableColumn<?, ?> withdrawal_col_Date;

    @FXML
    private TableColumn<?, ?> withdrawal_col_amount;

    @FXML
    private TableColumn<?, ?> withdrawal_col_authorizationNumber;

    @FXML
    private TableColumn<?, ?> withdrawal_col_categoryNumber;

    @FXML
    private TableColumn<?, ?> withdrawal_col_username;

    @FXML
    private Button withdrawal_confirmBtn;

    @FXML
    private AnchorPane withdrawal_form;

    @FXML
    private TableView<?> withdrawal_tableView;

    @FXML
    private AnchorPane main_form;

    private double x = 0;
    private double y = 0;
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public ObservableList<productData> addProductsListData() {
        ObservableList<productData> prodList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM product as p inner join category c on p.category_id = c.Id";

        connect = database.connectDb();

        try {
            productData prod;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                prod = new productData(result.getString("product_id"),
                        result.getString("brand"),
                        result.getString("product_name"),
                        result.getString("categoryName"),
                        result.getInt("category_id"),
                        result.getDouble("price"),
                        result.getInt("units")
                        );
                prodList.add(prod);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return prodList;
    }

    public ObservableList<Category> categoryListData() {
        ObservableList<Category> catList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM category";

        connect = database.connectDb();

        try {
            Category category;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                category = new Category(result.getInt("Id"),
                        result.getString("categoryName"));
                catList.add(category);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return catList;
    }

    private ObservableList<productData> addProductsList;
    private ObservableList<Category> categoryList;
//    shows the data in a table view
    public void addProductsShowData() {
        addProductsList = addProductsListData();
        categoryList = categoryListData();
        addProduct_col_code.setCellValueFactory(new PropertyValueFactory<>("productId"));
        addProduct_col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        addProduct_col_name.setCellValueFactory(new PropertyValueFactory<>("productName"));
        addProduct_col_category.setCellValueFactory(new PropertyValueFactory<>("Category"));
        addProduct_col_cost.setCellValueFactory(new PropertyValueFactory<>("price"));
        addProduct_col_availableStock.setCellValueFactory(new PropertyValueFactory<>("units"));

        addProduct_category.setItems(categoryList);

        addProduct_tableView.setItems(addProductsList);
    }

    public void addProductsSelect() {
        productData prod = addProduct_tableView.getSelectionModel().getSelectedItem();
        int num = addProduct_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addProduct_code.setText(prod.getProductId());
        addProduct_brand.setText(prod.getBrand());
        addProduct_name.setText(prod.getProductName());
        addProduct_cost.setText(prod.getPrice().toString());
        addProduct_category.setValue(prod.getCategory());
    }
    public void logout(){
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mensaje de confirmación");
            alert.setHeaderText(null);
            alert.setContentText("¿Deseas salir de la cuenta?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            } else return;
        } catch (Exception e) { e.printStackTrace();}
    }

//    Switching navbar buttons
    public void switchForm(ActionEvent event) {
        if(event.getSource() == dashboard_btn) {
            switchVisibility(dashboard_form, addProduct_form, employees_form, orders_form, withdrawal_form, deposit_form, sales_form, stores_form, profile_form);
            switchStyle(dashboard_btn, addProducts_btn, employees_btn, orders_btn, withdrawal_btn, deposit_btn, sales_btn, stores_btn, profile_btn);

        } else if (event.getSource() == addProducts_btn) {
            switchVisibility(addProduct_form, employees_form, orders_form, withdrawal_form, deposit_form, sales_form, stores_form, profile_form, dashboard_form);
            switchStyle(addProducts_btn, dashboard_btn, employees_btn, orders_btn, withdrawal_btn, deposit_btn, sales_btn, stores_btn, profile_btn);
            addProductsShowData();
        } else if (event.getSource() == employees_btn) {
            switchVisibility(employees_form, addProduct_form, orders_form, withdrawal_form, deposit_form, sales_form, stores_form, profile_form, dashboard_form);
            switchStyle(employees_btn, addProducts_btn, dashboard_btn, orders_btn, withdrawal_btn, deposit_btn, sales_btn, stores_btn, profile_btn);

        } else if (event.getSource() == orders_btn) {
            switchVisibility(orders_form, employees_form, addProduct_form, withdrawal_form, deposit_form, sales_form, stores_form, profile_form, dashboard_form);
            switchStyle(orders_btn, addProducts_btn, dashboard_btn, employees_btn, withdrawal_btn, deposit_btn, sales_btn, stores_btn, profile_btn);

        } else if (event.getSource() == withdrawal_btn) {
            switchVisibility( withdrawal_form, employees_form, addProduct_form, orders_form, deposit_form, sales_form, stores_form, profile_form, dashboard_form);
            switchStyle(withdrawal_btn, addProducts_btn, dashboard_btn, employees_btn, orders_btn, deposit_btn, sales_btn, stores_btn, profile_btn);

        } else if (event.getSource() == deposit_btn) {
            switchVisibility(deposit_form, employees_form, addProduct_form, orders_form, withdrawal_form, sales_form, stores_form, profile_form, dashboard_form);
            switchStyle(deposit_btn, addProducts_btn, dashboard_btn, employees_btn, orders_btn, withdrawal_btn, sales_btn, stores_btn, profile_btn);

        } else if (event.getSource() == sales_btn) {
            switchVisibility(sales_form, employees_form, addProduct_form, orders_form, withdrawal_form, deposit_form, stores_form, profile_form, dashboard_form);
            switchStyle(sales_btn, addProducts_btn, dashboard_btn, employees_btn, orders_btn, withdrawal_btn, deposit_btn, stores_btn, profile_btn);

        } else if (event.getSource() == stores_btn) {
            switchVisibility(stores_form, employees_form, addProduct_form, orders_form, withdrawal_form, deposit_form, sales_form, profile_form, dashboard_form);
            switchStyle(stores_btn, dashboard_btn, addProducts_btn, employees_btn, orders_btn, withdrawal_btn, deposit_btn, sales_btn, profile_btn);

        } else if (event.getSource() == profile_btn) {
            switchVisibility(profile_form, stores_form, employees_form, addProduct_form, orders_form, withdrawal_form, deposit_form, sales_form, dashboard_form);
            switchStyle(profile_btn, dashboard_btn, addProducts_btn, employees_btn, orders_btn, withdrawal_btn, deposit_btn, sales_btn, stores_btn);
        }
    }

//    The first parameter is the one to be visible. The rest of them will become invisible.
    private void switchVisibility(AnchorPane... forms) {
        forms[0].setVisible(true);
        for (int i = 1; i < forms.length; i++) {
            forms[i].setVisible(false);
        }
    }
    private void switchStyle(Button... buttons) {
        buttons[0].setStyle("-fx-background-color: linear-gradient(to top right, #11895d, #32ce7d);");
        for (int i = 1; i < buttons.length; i++) {
            buttons[i].setStyle("-fx-background-color: transparent");
        }
    }

    public void close(){
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage)main_form.getScene().getWindow();
        stage.setIconified(true);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addProductsShowData();
    }
}
