package Modelo;

/**
 *
 * @author thoma
 */
public class Centro {
    
    private int id;
    private int id_administrador;
    private String nombre;
    private float max_procesamiento;
    private int max_cola;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getMax_procesamiento() {
        return max_procesamiento;
    }

    public void setMax_procesamiento(float max_procesamiento) {
        this.max_procesamiento = max_procesamiento;
    }

    public int getMax_cola() {
        return max_cola;
    }

    public void setMax_cola(int max_cola) {
        this.max_cola = max_cola;
    }
}
