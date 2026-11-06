
import java.sql.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author INFFORMATICA
 */
public class Cotizacion {
    private int idCotizacion ;
    private String numCotizacion;
    private String descripcion;
    private float porcentaje;
    private float precio;
    private int plazos;
    private java.sql.Date fecha;
    private int status;
    
    // constructor 

    public Cotizacion() {
        this.idCotizacion = 0;
        this.numCotizacion = "";
        this.descripcion ="";
        this.porcentaje = 0.0f;
        this.precio = 0.0f;
        this.plazos = 0;
        
    }

    public Cotizacion(int idCotizacion, String numCotizacion, String descripcion, float porcentaje, float precio, int plazos) {
        this.idCotizacion = idCotizacion;
        this.numCotizacion = numCotizacion;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
        this.precio = precio;
        this.plazos = plazos;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getNumCotizacion() {
        return numCotizacion;
    }

    public void setNumCotizacion(String numCotizacion) {
        this.numCotizacion = numCotizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getPlazos() {
        return plazos;
    }

    public void setPlazos(int plazos) {
        this.plazos = plazos;
    }
    //metodo de comportamiento 
    
    public float calcularPagoInicial (){
        
        float pagoInicial = 0.0f;
        pagoInicial = precio * (this.porcentaje/100);
        return pagoInicial;
    }
    public float calcularTotalFin(){
        float total = 0.0f;
        total = this.precio - this.calcularPagoInicial();
        return total;
    }
    public float calculePagoMensual(){
        float pagoMensual = 0.0f;
        pagoMensual = this.calcularTotalFin()/this.plazos;
        return pagoMensual;
        
    }

    Date getFecha() {
    return this.fecha;
   }

    int getStatus() {
return this.status;    }

  public void setFecha(Date fec) {
    this.fecha = fec;
}

public void setStatus(int i) {
    this.status = i;
}
}
