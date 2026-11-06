/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author INFFORMATICA
 */
import java.sql.Date;

public class TestCotizacion {
    public static void main(String[] args) {
        CotizacionDB db = new CotizacionDB();

        if (db.abrir()) System.out.println("Se abrio con exito la db");
        else System.out.println("No fue posible abrir la db");

        if (db.cerrar()) System.out.println("Se cerro con exito");
        else System.out.println("No fue posible cerrar");

        Date fec = new Date(System.currentTimeMillis());

        Cotizacion cot = new Cotizacion();
        cot.setIdCotizacion(14);
        cot.setNumCotizacion("001");
        cot.setDescripcion("Yaris 2026");
        cot.setPrecio(5000f);
        cot.setPorcentaje(20f);
        cot.setFecha(fec);
        cot.setPlazos(36);
        cot.setStatus(0);

        int id = 0;
        id = db.insertar(cot);

        if (id > 0) System.out.println("Se agrego con exito el registro");
        else System.out.println("No fue posible agregar el registro");

        cot.setIdCotizacion(3);
        cot.setPlazos(60);
        cot.setPrecio(40000f);

        id = 0;
        id = db.actualizar(cot);

        if (id > 0) System.out.println("Se Actualizo con exito el registro");
        else System.out.println("No fue actualizar el registro");

        if (id == -1) System.err.println("Surgio un error");
    }
}