package com.hernandez;

public class CuentaLargoPlazo extends Cuenta {

    public final double PENALTY = .05;

    public boolean retirar(double monto){
        monto += (monto * PENALTY);

        return super.retirar(monto);
    }
}
