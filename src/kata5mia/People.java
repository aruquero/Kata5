
package kata5mia;

class People {
    private String Nombre;
    private String Apellido;
    private String Departamento;

    People(String Nombre, String Apellido, String Departamento) {
        this.Nombre=Nombre;
        this.Apellido=Apellido;
        this.Departamento=Departamento;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getDepartamento() {
        return Departamento;
    }
    
}
