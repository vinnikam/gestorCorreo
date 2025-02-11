package co.vinni.interaccion;

import co.vinni.comunicaciones.Servidor;
import co.vinni.datos.DatosCorreo;
import co.vinni.util.Utilidad;


public class GestorConsola {
    public void enviarCorreo(){
        boolean finalizar = false;
        Servidor s = new Servidor();
        while (!finalizar){
            System.out.println("Inicio proceso para enviar correo");
            String destinatario = Utilidad.leerCadena("Escriba el correo del destinatario");
            String asunto = Utilidad.leerCadena("Escriba el asunto");
            String mensaje = Utilidad.leerCadena("Escriba el mensaje");
            DatosCorreo datosCorreo = new DatosCorreo();
            datosCorreo.setDestinatario(destinatario);
           datosCorreo.setAsunto(asunto);
           datosCorreo.setMensaje(mensaje);

            String rtaCorreo =  s.enviarCorreo(datosCorreo);
            System.out.println(rtaCorreo);

            String rta = Utilidad.leerCadena("Desea continuar S/N ?");
            if (rta.equalsIgnoreCase("N")){
                finalizar = true;
                System.out.println("PROGRAMA FINALIZADO");
            }
        }
    }

}
