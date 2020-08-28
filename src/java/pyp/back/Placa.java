/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.back;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Pancho
 */
public class Placa {

    private String placaparte1;
    private String placaparte2;
    private String Fecha;
    private String Hora;
    private String Minutos;
    
    public void setPlacaparte1(String placaparte1) {
        this.placaparte1 = placaparte1;
    }

    public void setPlacaparte2(String placaparte2) {
        this.placaparte2 = placaparte2;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }


    public void setMinutos(String Minutos) {
        this.Minutos = Minutos;
    }


    
        public boolean validarplacaletras(){
        char primera_letra=placaparte1.charAt(0);
            System.out.println(primera_letra);
        if(primera_letra == 'd' || primera_letra == 'D' || primera_letra == 'f' || primera_letra == 'F' || primera_letra == 'r' || primera_letra == 'R'){
            return false;
        }
        else{
            return true;
        }
    }
        
    public boolean validarFecha() {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(Fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
        
   
    
    public String validarSiPuedeSalir() throws ParseException
    {
        SimpleDateFormat formatoFecha1 = new SimpleDateFormat("dd/MM/yyyy");
        Date myDate = formatoFecha1.parse(Fecha);
        formatoFecha1.applyPattern("EEE, d MMM yyyy");
        String Fecha_letras = formatoFecha1.format(myDate);
        String Fecha_dia = Fecha_letras.substring(0,3);
        int ultimo_digito=Character.getNumericValue(placaparte2.charAt(placaparte2.length()-1));
        String dia_placa = "";
        switch(ultimo_digito){
            case 0:
                dia_placa = "vie";
                break;  
            case 1:
                dia_placa = "lun";
                break;
            case 2:
                dia_placa = "lun";
                break;
            case 3:
                dia_placa = "mar";
                break;
            case 4:
                dia_placa = "mar";
                break;
            case 5:
                dia_placa = "miÃ©";
                break;
            case 6:
                dia_placa = "miÃ©";
                break;
            case 7:
                dia_placa = "jue";
                break;
            case 8:
                dia_placa = "jue";
                break;
            case 9:   
                dia_placa = "vie";
                break;
        }
        
        if(dia_placa.equals(Fecha_dia)){
            int hora_ent = Integer.parseInt(Hora);
            int min_ent = Integer.parseInt(Minutos);
            String salida= "";
            if((hora_ent == 9 && min_ent >=0 && min_ent <= 30)||(hora_ent == 19 && min_ent >=0 && min_ent <= 30)) {
                System.out.println(+hora_ent+ " "+ dia_placa+ " "+ dia_placa); 
                return "Su vehículo no puede circular";
            }
            if(((hora_ent >= 7 && hora_ent < 9) || (hora_ent >= 16 && hora_ent < 19))){
                System.out.println(+hora_ent+ " "+ dia_placa+ " "+ dia_placa); 
                return "Su vehículo no puede circular";
            }
            else{
                System.out.println(+hora_ent+ " "+ min_ent+ " "+ dia_placa); 
                return "Puede circular en esta hora, pero cuidado que hoy su automóvil tiene restricción en ciertas horas";
            }  
        }
        else{
            System.out.println(" "+ dia_placa+ " "+ Fecha_dia); 
            return "Puede circular sin ningún problema";
        }
        
        
        
        
    }
    
    
}
