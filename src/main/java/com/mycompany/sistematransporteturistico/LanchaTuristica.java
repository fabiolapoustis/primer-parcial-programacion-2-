
package com.mycompany.sistematransporteturistico;

public class LanchaTuristica extends Vehiculo {

    public enum TipoMotor {
        NAFTA,
        DIESEL,
        ELECTRICO
    }

    private TipoMotor tipoMotor;

    public LanchaTuristica() {
        super();
    }
    public LanchaTuristica(String patente, String marca,
                           int capacidadPasajeros, int anioFabricacion,
                           TipoMotor tipoMotor) {

        super("Lancha turistica", patente, marca,
              capacidadPasajeros, anioFabricacion);

        this.tipoMotor = tipoMotor;
    }
    
    
       public TipoMotor getTipoMotor() {
        return tipoMotor;
    }
}
