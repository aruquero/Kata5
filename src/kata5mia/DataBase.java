
package kata5mia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataBase {
    private String url;
    Connection connection = null;

    public DataBase(String url) {
        this.url = url;
    }

    void close() {
        if(this.connection!= null){
            try {
                this.connection.close();
                System.out.println("Base de datos cerrada...");
            } catch (SQLException exception) {
                System.out.println("Error DataBase::close (SQLException "+ exception);
            }
        }
    }

    void open() {
        try {
            this.connection = DriverManager.getConnection(this.url);
            System.out.println("Base de datos abierta...");
        } catch (SQLException exception) {
            System.out.println("Error DataBase::open (SQLException "+ exception);
        }
    }

    void insert_PERSONAS(People people) {
        String SQL= "INSERT INTO Personas(Nombre, Apellidos, Departamento) VALUES (?,?,?)";
        
        try {
            PreparedStatement preparedstatement = this.connection.prepareStatement(SQL);
            preparedstatement.setString(1, people.getNombre());
            preparedstatement.setString(2, people.getApellido());
            preparedstatement.setString(3, people.getDepartamento());
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void select_PERSONAS() {
        String SQL= "SELECT * FROM Personas";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            
            System.out.println("Id \t Nombre \t Apellidos\t Departamento");
            System.out.println("-- \t ------ \t --------- \t ------------");
            while(resultset.next()){
                System.out.println(resultset.getInt("Id")+"\t "+
                        resultset.getString("Nombre")+"\t "+
                        resultset.getString("Apellidos")+"\t "+
                        resultset.getString("Departamento")+"\t ");
            }
        } catch (SQLException exception) {
            System.out.println("Error DataBase::Select_PERSONAS (SQLException "+ exception);

        }
        
        
    }
    
        
    
}
