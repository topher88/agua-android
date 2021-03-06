package com.rieder.christopher.aguaapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rieder.christopher.aguaapp.domain.DetalleVenta;
import com.rieder.christopher.aguaapp.domain.Venta;

import java.util.ArrayList;

public class VentaFragment extends Fragment {

    private Venta venta;

    public VentaFragment() {
        //empty fragment
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_venta, container, false);

        // set datos del cliente
        TextView venta_nombre_cliente = rootView.findViewById(R.id.venta_nombre_cliente);
        TextView venta_domicilio_cliente = rootView.findViewById(R.id.venta_domicilio_cliente);
        venta_nombre_cliente.setText(this.venta.getCliente().getNombre());
        venta_domicilio_cliente.setText(this.venta.getCliente().getDomicilio());

        final ArrayList<DetalleVenta> detallesVenta = venta.getDetallesVenta();
        RecyclerView recyclerView = rootView.findViewById(R.id.venta_recycler_view);
        recyclerView.setAdapter(new DetalleVentaListAdapter(this.getContext(), detallesVenta));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        FloatingActionButton fab = rootView.findViewById(R.id.venta_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, venta.getClienteLocation());
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        return rootView;
    }
}
