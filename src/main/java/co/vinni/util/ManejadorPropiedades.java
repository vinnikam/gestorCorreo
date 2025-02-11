package co.vinni.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ManejadorPropiedades {
    private Properties propiedades = new Properties();
    private String rutArchivo;

    public ManejadorPropiedades(String rutArchivo) {
        this.rutArchivo = rutArchivo;
        try (FileInputStream input = new FileInputStream(rutArchivo)) {
            propiedades.load(input);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public String consultarPropiedad(String propiedad) {
        return propiedades.getProperty(propiedad);
    }

}
