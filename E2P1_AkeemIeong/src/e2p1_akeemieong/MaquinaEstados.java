
package e2p1_akeemieong;

import java.util.ArrayList;


public class MaquinaEstados {
    private ArrayList<String> estados=new ArrayList<>();
    private ArrayList<String> estados_aceptacion=new ArrayList<>();
    private ArrayList<String> aristats=new ArrayList<>();
    private String estado_actual=new String();

    public ArrayList<String>Splitstring(String str,char deli){
        ArrayList<String> temporal=new ArrayList<>();
        String[]tokens=str.split(Character.toString(deli));
        for (int i = 0; i <tokens.length; i++) {
            temporal.add(tokens[i]);
        }
        return temporal;
    }
    public void extractAcceptNodes(){
        String cad="";
        
        for (int i = 0; i < estados.size(); i++) {
            if(estados.get(i).contains(".")){
            cad = estados.get(i);
            cad=cad.substring(1);
            estados_aceptacion.add(cad);
            estados.set(i, cad);
        }
    }
        
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }

    public ArrayList<String> getEstados_aceptacion() {
        return estados_aceptacion;
    }

    public void setEstados_aceptacion(ArrayList<String> estados_aceptacion) {
        this.estados_aceptacion = estados_aceptacion;
    }

    public ArrayList<String> getAristats() {
        return aristats;
    }

    public void setAristats(ArrayList<String> aristats) {
        this.aristats = aristats;
    }

    public String getEstado_actual() {
        return estado_actual;
    }

    public void setEstado_actual(String estado_actual) {
        this.estado_actual = estado_actual;
    }

    public MaquinaEstados() {
    }
    public String getArista(String str){
        for (int i = 0; i < aristats.size(); i++) {
            if (aristats.get(i).contains(str)){
            return aristats.get(i);
            }
        }
        return " ";
    }
    public MaquinaEstados(String estados,String aristas){
        this.estados=Splitstring(estados,';');
        extractAcceptNodes();
        this.aristats=Splitstring(aristas,';');
        this.estado_actual=this.estados.get(0);
    }
    public String computeStr(String std) {
        String output = "";
        estado_actual = estados.get(0);
        for (int i = 0; i < std.length(); i++) {
            String ar = getArista(estado_actual+','+std.charAt(i));
            if (!ar.equals("")) {
                estado_actual = ar.split(",")[2];
                output += ar.split(",")[0]+':'+ar.split(",")[1]+"->"+ar.split(",")[2] + "\n";
                
            }
            else {
                output+="Rechazada";
                return output;
            }
        }
        if (estados_aceptacion.contains(estado_actual)) {
            output += "Aceptada";
            return output;
        }
        else 
            output += "Rechazada";
            return output;
    }
}

