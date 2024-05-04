package domain;

public class Colaboradores {
    private String id_colab;
    private String nombre_colab;
    private String apellido_colab;
    private String direccion_colab;
    private String telefono_colab;

    public Colaboradores() {
    }

    @Override
    public String toString() {
        return "Colaboradores{" + "id_colab=" + id_colab + ", nombre_colab=" + nombre_colab + ", apellido_colab=" + apellido_colab + ", direccion_colab=" + direccion_colab + ", telefono_colab=" + telefono_colab + '}';
    }

    public String getId_colab() {
        return id_colab;
    }

    public void setId_colab(String id_colab) {
        this.id_colab = id_colab;
    }

    public String getNombre_colab() {
        return nombre_colab;
    }

    public void setNombre_colab(String nombre_colab) {
        this.nombre_colab = nombre_colab;
    }

    public String getApellido_colab() {
        return apellido_colab;
    }

    public void setApellido_colab(String apellido_colab) {
        this.apellido_colab = apellido_colab;
    }

    public String getDireccion_colab() {
        return direccion_colab;
    }

    public void setDireccion_colab(String direccion_colab) {
        this.direccion_colab = direccion_colab;
    }

    public String getTelefono_colab() {
        return telefono_colab;
    }

    public void setTelefono_colab(String telefono_colab) {
        this.telefono_colab = telefono_colab;
    }

    public Colaboradores(String id_colab, String nombre_colab) {
        this.id_colab = id_colab;
        this.nombre_colab = nombre_colab;
    }

    public Colaboradores(String id_colab, String nombre_colab, String apellido_colab, String direccion_colab, String telefono_colab) {
        this.id_colab = id_colab;
        this.nombre_colab = nombre_colab;
        this.apellido_colab = apellido_colab;
        this.direccion_colab = direccion_colab;
        this.telefono_colab = telefono_colab;
    }
   
}
