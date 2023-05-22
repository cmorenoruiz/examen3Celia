
package ejerciciosExamen;

/**
 *
 * @author DAW
 */
public class Aparcamiento {
    //atributos
   private String id ="";
   private String nombre="";
   private String tipo = "";
   private int plazasRot=0;
   private int plazasResid=0;
   private int plazasDis=0;
   private String distrito="";

   
   
   
   //constructores
    public Aparcamiento() {
    }
    
    public Aparcamiento(String id, String nombre, String tipo, int plazasRot, int plazasResid, int plazasDis, String distrito) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.plazasRot = plazasRot;
        this.plazasResid = plazasResid;
        this.plazasDis=plazasDis;
        this.distrito=distrito;
    }

    
    
    
    //funciones, getters y setters
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("aparcamiento{id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", tipo=").append(tipo);
        sb.append(", plazasRot=").append(plazasRot);
        sb.append(", plazasResid=").append(plazasResid);
        sb.append(", plazasDis=").append(plazasDis);
        sb.append(", distrito=").append(distrito);
        sb.append('}');
        return sb.toString();
    }

    
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPlazasRot() {
        return plazasRot;
    }

    public void setPlazasRot(int plazasRot) {
        this.plazasRot = plazasRot;
    }

    public int getPlazasResid() {
        return plazasResid;
    }

    public void setPlazasResid(int plazasResid) {
        this.plazasResid = plazasResid;
    }

    public int getPlazasDis() {
        return plazasDis;
    }

    public void setPlazasDis(int plazasDis) {
        this.plazasDis = plazasDis;
    }

    public int getPlazasTotales(){
        return getPlazasDis()+getPlazasResid()+getPlazasRot();
    }
    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
   
   
    
}
