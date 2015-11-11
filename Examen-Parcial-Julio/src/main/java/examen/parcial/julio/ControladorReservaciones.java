/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.parcial.julio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reservaciones")
public class ControladorReservaciones {
    @RequestMapping("/guardar")
    @ResponseBody String guardar() throws Exception{
         DAOReservacion re=new DAOReservacion();
         DAOCliente cl=new DAOCliente();
         DAOTarjeta ta=new DAOTarjeta();
         Cliente c1=new Cliente();
         c1.setEmail("julio@outlook.com");
         c1.setNombre("julio");
         c1.setPaterno("hernandez");  
         cl.guardar(c1);
         
         Tarjeta ta1=new Tarjeta();
         ta1.setIdCliente(c1);
         ta1.setNombreTarjeta("banamex");
         ta1.setNumeroTarjeta(12345);
         ta1.setSaldo(25000f);
         ta.guardar(ta1);
         
         Reservacion reservacion=new Reservacion();
         reservacion.setIdCliente(c1);
         reservacion.setIdTarjeta(ta1);
         reservacion.setCiudadDestino("España");
          re.guardar(reservacion);
         return "Reservacion guardada con exito";   
    
     
     
    }
}
