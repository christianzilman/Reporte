/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

/**
 *
 * @author juliozilman
 */
public class Reporte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            PgConexion conexion = new PgConexion();
            conexion.conectar();
            String reportFile = "./reportes/parametros.jasper";
            HashMap misParametros;
            //Preparacion del reporte (en esta etapa se inserta el valor del query en el reporte).
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile, null, conexion.getConexion());
            JasperPrintManager.printReport(jasperPrint,true);
            //JasperViewer.viewReport(jasperPrint, false);
            //JasperPrintManager.printReport( jasperPrint, true);
        } catch (JRException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
