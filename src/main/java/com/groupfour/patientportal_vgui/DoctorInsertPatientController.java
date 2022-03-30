/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.groupfour.patientportal_vgui;

import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Angie
 */
public class DoctorInsertPatientController implements Initializable {
    
    
    @FXML
    private TextField textField_firstName;

    @FXML
    private TextField textField_insuranceCo;

    @FXML
    private TextField textField_insuranceID;

    @FXML
    private TextField textField_lastName;

    @FXML
    private TextField textField_patientID;
    
     @FXML
    private TextField textField_email;

    @FXML
    private TextField textField_phone;
    
    @FXML
    private TextField textField_street;
    
    @FXML
    private TextField textField_city;
    
    @FXML
    private TextField textField_zip;
    
    @FXML
    private TextField textField_state;
    
    //String query = null;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps;
    PatientTable table = null;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void handleButton_save() {
       // String 
       con = DatabaseConnection.connectDB();
       String firstname = textField_firstName.getText();
       String lastname = textField_lastName.getText();
       String phone = textField_phone.getText();
       String email = textField_email.getText(); 
       String street = textField_street.getText();
       String city = textField_city.getText();
       String zip = textField_zip.getText();
       String state = textField_state.getText();
       //String insuranceid = String.valueOf(textField_insuranceID);
       String insuranceid = textField_insuranceID.getText();
       String insurance = textField_insuranceCo.getText();
       
       if (firstname.isEmpty() || lastname.isEmpty() || phone.isEmpty() || email.isEmpty() || street.isEmpty()
               || city.isEmpty() || zip.isEmpty() || state.isEmpty() || insuranceid.isEmpty() || insurance.isEmpty()) {
           JOptionPane.showMessageDialog(null, "Please fill in all information.");
       } else {
           getQuery();
           //insert();
       }
    }
    
    @FXML
    void handleButton_clear() {
        
    }

    private void getQuery() {
        
        try {
        System.out.println("WE made it yesssir lets go love the mets");
        con = DatabaseConnection.connectDB();
        Statement stmt = con.createStatement();
        
      String query = "INSERT INTO PATIENT" + "(PatientID, PFirstName, PLastName, PPhone, PEmail, Street, City, Zip, State, InsuranceID, Insurance, PrimaryDoctor)" + 
              "values (?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
  
            int ID = Integer.parseInt(textField_patientID.getText());
            String fname = textField_firstName.getText();
            String lName = textField_lastName.getText();
            String pNum =  textField_phone.getText();
            String email = textField_email.getText();
            String street = textField_street.getText();
            String city = textField_city.getText();
            String zip = textField_zip.getText();
            String state =  textField_state.getText();
            int insID =  Integer.parseInt(textField_insuranceID.getText());
            String insur =  textField_insuranceCo.getText();    
            int prim = 10001;
            
            query = "INSERT INTO PATIENT" + "(PatientID, PFirstName, PLastName, PPhone, PEmail, Street, City, Zip, State, InsuranceID, Insurance, PrimaryDoctor)" + 
              "values (" + ID +", '" + fname + "', '" + lName + "', '" + pNum + "', '" + email + "', '" + street +"',  '"+ city +"', '" + zip + "', '" + state + "', " + insID + ", '" + insur + "', " + prim +");";
            
            
            query = "UPDATE PATIENT " + 
              "SET  pFirstName ='" + fname + "', PLastName = '" + lName + "', PPhone = '" + pNum + "', PEmail = '" + email + "', Street = '" + street +"', City = '"+ city +"', Zip = '" + zip + "', State = '" + state + "', InsuranceID = " + insID + ", Insurance = '" + insur + "', PrimaryDoctor = " + prim +
                    " WHERE PatientID = " + ID + ";";
            
            System.out.println(query);
            
            ResultSet rs = stmt.executeQuery(query);
            
            
            
            JOptionPane.showMessageDialog(null,"Saved");
    } catch (Exception e) {
        
    }
    }


    
}