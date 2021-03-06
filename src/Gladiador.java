
import java.util.Random;


public class Gladiador {
    private String nombre;
    private String estado = "En guardia";
    private int energia = 1000;
    private int fuerza;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public int getEnergia() {
        return energia;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    
    
    //metodo que va a generar numeros aleatorios
    public int atacar(){
        Random rnd = new Random();
        int danoTotal = 0;
        danoTotal = this.fuerza * rnd.nextInt(50);
        return danoTotal;
    }
    
    public void recibirDano (int danoRecibido){
        this.energia = this.energia - danoRecibido;
        if(this.energia <= 0){
            this.estado = "Derrotado";
        }
    }
}
