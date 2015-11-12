/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farid.examen.parcial;

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
         c1.setEmail("farid@unitec.com");
         c1.setNombre("farid");
         c1.setPaterno("salguero");  
         cl.guardar(c1);
         
         Tarjeta ta1=new Tarjeta();
         ta1.setIdCliente(c1);
         ta1.setNombreTarjeta("bancomer");
         ta1.setNumeroTarjeta(23485);
         ta1.setSaldo(10000f);
         ta.guardar(ta1);
         
         Reservacion reservacion=new Reservacion();
         reservacion.setIdCliente(c1);
         reservacion.setIdTarjeta(ta1);
         reservacion.setCiudadDestino("Peru");
          re.guardar(reservacion);
         return "Reservacion guardada!!";   
    
     
     
    }
}