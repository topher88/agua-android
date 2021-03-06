package com.rieder.christopher.aguaapp.domain;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public final class Recorrido {

    private final String nombre;
    private final String fecha;
    private final int repartidorID;
    private final int cantidadEnvasesLlenosInicial;
    private final int cantidadEnvasesVaciosInicial;
    private int cantidadEnvasesLlenosFinal = 0;
    private int cantidadEnvasesVaciosFinal = 0;
    private ArrayList<Venta> ventas;

    public Recorrido(String nombre, String fecha, int repartidorID, int cantidadEnvasesLlenosInicial, int cantidadEnvasesVaciosInicial) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.repartidorID = repartidorID;
        this.cantidadEnvasesLlenosInicial = cantidadEnvasesLlenosInicial;
        this.cantidadEnvasesVaciosInicial = cantidadEnvasesVaciosInicial;
    }

    public void setCantidadEnvasesLlenosFinal(int cantidadEnvasesLlenosFinal) {
        this.cantidadEnvasesLlenosFinal = cantidadEnvasesLlenosFinal;
    }

    public void setCantidadEnvasesVaciosFinal(int cantidadEnvasesVaciosFinal) {
        this.cantidadEnvasesVaciosFinal = cantidadEnvasesVaciosFinal;
    }

    public void buildVentas(List<Cliente> clientes) {
        this.ventas = new ArrayList<>();
        for (Cliente cliente : clientes) {
            Venta v = new Venta(cliente);
            this.ventas.add(v);
        }
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public String getNombre() {
        return nombre;
    }
}