package reporte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JOptionPane;

/**
 * PgConexion implementa la coneccion con base de datos postgresql
 */
public class PgConexion{

    private Connection conexion;
    private Statement statement;
    private String driver = "postgresql";
    private String servidor = "localhost";
    private String database = "sistemacomercial";
    private String esquema = "public";
    private String user = "postgres";
    private String password = "123";

    /**
     * Creates a new instance of Conexion por defecto:
     *  servidor = localhost"; database = "informacion"; esuqema = "public";
     *  user = "postgres"; password = "admpg";
     * 
     * @see conectar();
     */
    public PgConexion() {
    }  // end Conexion()

    /**
     * Creates a new instance of Conexion por defecto:
     *  user = "postgres"; password = "admpg";
     * 
     * @see conectar();
     */
    public PgConexion(String servidor, String database, String esquema) {
        this.servidor = servidor;
        this.database = database;
        this.esquema = esquema;
    }  // end Conexion()

    /**
     * Creates a new instance of Conexion
     * @param String servidor, String database,
     *        String user, String password
     * @see conectar();
     */
    public PgConexion(String servidor, String database, String esquema,
            String user, String password) {
        this.servidor = servidor;
        this.database = database;
        this.esquema = esquema;
        this.user = user;
        this.password = password;
    }  // end Conexion()

    /**
     * Crea coneccion a la base de datos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void conectar() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://" + servidor + ":5432/" + database;
            conexion = DriverManager.getConnection(url, user, password);
            statement = conexion.createStatement();
        } catch (ClassNotFoundException ex) {
            System.err.println("No encuentra Clase Driver Base de Datos.");
            System.err.println(ex);
            JOptionPane.showMessageDialog(null,
                    "Error Driver Base de Datos...", "ADVERTENCIA",
                    JOptionPane.ERROR_MESSAGE);
            throw (ex);
        } catch (SQLException ex) {
            System.err.println("No puede conectar a la Base de Datos.");
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Usuario Invalido...",
                    "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
            throw (ex);
        }
    }  // end conectar()

   
    /**
     * Obtener coneccion
     * @return Connection
     */
    public Connection getConexion() {
        return conexion;
    } // end getConexion()

    /**
     * Obtener base de dato
     * @return String
     */
    public String getDatabase() {
        return database;
    } // end getDatabase()

    /**
     * Obtener driver
     * @return String
     */
    public String getDriver() {
        return driver;
    } // end getDriver()

    /**
     * Obtener esquema
     * @return String
     */
    public String getEsquema() {
        return esquema;
    } // end getEsquema()

    /**
     * Obtener servidor
     * @return String
     */
    public String getServidor() {
        return servidor;
    } // end getServidor()

    /**
     * Obtener sentencia
     * @return Statement
     */
    public Statement getStatement() {
        return statement;
    } // end getStatement()

    /**
     * Obtener usuario
     * @return String
     */
    public String getUser() {
        return user;
    } // end getUser()
} // end Conexion
