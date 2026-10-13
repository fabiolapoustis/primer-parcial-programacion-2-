package com.mycompany.sistematransporteturistico;

public class VanEjecutiva extends Vehiculo {

    private boolean aireAcondicionado;

    public VanEjecutiva(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public VanEjecutiva() {
        super();
    }

    public VanEjecutiva(String patente, String marca,
                        int capacidadPasajeros, int anioFabricacion,
                        boolean aireAcondicionado) {

        super("Van ejecutiva", patente, marca,
              capacidadPasajeros, anioFabricacion);

        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }
}
