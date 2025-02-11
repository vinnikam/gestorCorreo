package co.vinni.comunicaciones;

import co.vinni.datos.DatosCorreo;
import co.vinni.util.ManejadorPropiedades;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Servidor {
    private final Properties props = new Properties();
    private final String usuario;
    private final String clave;
    public Servidor(){
        String rutaArchivo = "datos.conexion";
        ManejadorPropiedades manejadorPropiedades = new ManejadorPropiedades(rutaArchivo);
        usuario = manejadorPropiedades.consultarPropiedad("usuario");
        clave = manejadorPropiedades.consultarPropiedad("clave");

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    }
    public String enviarCorreo (DatosCorreo datosCorreo){
        if (usuario != null && clave != null) {
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(usuario, clave);
                }
            });

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(usuario));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(datosCorreo.getDestinatario()));
                message.setSubject(datosCorreo.getAsunto());
                message.setText(datosCorreo.getMensaje());

                Transport.send(message);
                return "Mensaje enviado. ";

            } catch (MessagingException e) {
                return "Error al enviar correo : "+e.getMessage();
            }
        }else{
            return "Los datos de autenticacion son incorrectos";
        }

    }
}
