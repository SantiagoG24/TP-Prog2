package JuegoDeCartas.LasCartas;

import java.util.ArrayList;

public class Carta {
    private ArrayList<Atributo> atributos;
    private String nombre;

    public Carta(String nombre) {
        this.nombre = nombre;
        atributos = new ArrayList<>();

    }
    public Carta(String nombre,ArrayList<Atributo>atributos) {
        this.nombre = nombre;
        this.atributos = atributos;

    }
    public void addAtributo(Atributo nuevo){
        if(!atributos.contains(nuevo)){
            atributos.add(nuevo);
        }
    }
    public ArrayList<Atributo> getAtributo(){
        ArrayList<Atributo> salida = new ArrayList<>();
        for (Atributo elemento:atributos) {
            if(!salida.contains(elemento))
                salida.add(elemento);
        }
        return salida;
    }

    public String getNombre() {
        return nombre;
    }
    public int getValorAtributo(Atributo filtro){
        for (Atributo aa:atributos) {
            if(aa.equals(filtro))
                return aa.getValor();
        }
        return 0;
    }
    public boolean tenesEstaLista(ArrayList<Atributo> referemcia){
        return referemcia.containsAll(this.getAtributo());
    }
    @Override
    public boolean equals(Object obj) {
        Carta nueva = (Carta) obj;
        return (nombre.equals(nueva.nombre) && atributos.equals(nueva.getAtributo()));
    }


    public String toString(Atributo atributo) {
        Atributo buscado = null;
        for (Atributo item:atributos) {
            if (item.equals(atributo))
                buscado= new Atributo(item);
        }
        return  nombre+buscado.toString();
    }
    public String toString(){
        return " "+nombre +" "+ atributos+" ";
    }
}
