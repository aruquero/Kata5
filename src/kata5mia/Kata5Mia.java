
package kata5mia;


public class Kata5Mia {

    public static void main(String[] args) {
        String url="jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Kata5Mia\\sqlite\\mibase.db";
        
        DataBase database = new DataBase(url);
        database.open();
        
        database.select_PERSONAS();
        
        People people = new People("Santiago","Sancho ","Comercial");
        database.insert_PERSONAS(people);
        
        
        System.out.println("----------------------");
        
        database.select_PERSONAS();
        
        
        database.close();
        
    }
    
}
