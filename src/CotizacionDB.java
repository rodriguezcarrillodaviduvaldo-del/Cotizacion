/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pc
 */
import java.sql.*;

public class CotizacionDB implements dbMetodos {
    private String MYSQLDRIVE;
    private String SQLURLDB;
    private Connection conexion;
    private PreparedStatement sqlConsulta;
    private ResultSet registro;
    private String consulta;

    public CotizacionDB() {
        this.MYSQLDRIVE = "com.mysql.jdbc.Driver";
        this.SQLURLDB = this.SQLURLDB = "jdbc:mysql://localhost:3306/sistemas?user=root&password=rayito2481:)";
    }

    @Override
    public boolean abrir() {
        boolean exito = false;
        try {
            Class.forName(this.MYSQLDRIVE);
            this.conexion = DriverManager.getConnection(this.SQLURLDB);
            exito = true;
        } catch (ClassNotFoundException | SQLException e) {
            exito = false;
        }
        return exito;
    }

    @Override
    public boolean cerrar() {
        boolean exito = false;
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                exito = true;
            }
        } catch (SQLException e) {
            exito = false;
        }
        return exito;
    }

    @Override
    public int insertar(Object obj) {
        Cotizacion cot = (Cotizacion) obj;
        int id = 0;
        try {
            this.abrir();
            this.consulta = "INSERT INTO Cotizacion(numCotizacion, descripcion, "
                    + "precio, porcentaje, plazos, fecha, status) "
                    + "VALUES (?,?,?,?,?,?,?)";
            this.sqlConsulta = this.conexion.prepareStatement(this.consulta);

            this.sqlConsulta.setString(1, cot.getNumCotizacion());
            this.sqlConsulta.setString(2, cot.getDescripcion());
            this.sqlConsulta.setFloat(3, cot.getPrecio());
            this.sqlConsulta.setFloat(4, cot.getPorcentaje());
            this.sqlConsulta.setInt(5, cot.getPlazos());
            this.sqlConsulta.setDate(6, cot.getFecha());
            this.sqlConsulta.setInt(7, cot.getStatus());

            id = this.sqlConsulta.executeUpdate();
            this.cerrar();
        } catch (SQLException e) {
            System.out.println("Surgio un error " + e.getMessage());
            id = -1;
        }
        return id;
    }

    @Override
    public int actualizar(Object obj) {
        Cotizacion cot = (Cotizacion) obj;
        int id = 0;
        try {
            this.abrir();
            this.consulta = "UPDATE Cotizacion SET numCotizacion = ?, descripcion = ?, "
                    + "precio = ?, porcentaje = ?, plazos = ?, "
                    + "fecha = ?, status = ? WHERE idCotizacion = ?";
            this.sqlConsulta = this.conexion.prepareStatement(this.consulta);

            this.sqlConsulta.setString(1, cot.getNumCotizacion());
            this.sqlConsulta.setString(2, cot.getDescripcion());
            this.sqlConsulta.setFloat(3, cot.getPrecio());
            this.sqlConsulta.setFloat(4, cot.getPorcentaje());
            this.sqlConsulta.setInt(5, cot.getPlazos());
            this.sqlConsulta.setDate(6, cot.getFecha());
            this.sqlConsulta.setInt(7, cot.getStatus());
            this.sqlConsulta.setInt(8, cot.getIdCotizacion());

            id = this.sqlConsulta.executeUpdate();
            this.cerrar();
        } catch (SQLException e) {
            System.out.println("Surgio un error " + e.getMessage());
            id = -1;
        }
        return id;
    }
}