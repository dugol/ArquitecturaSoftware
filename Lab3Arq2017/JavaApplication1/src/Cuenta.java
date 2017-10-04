/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;

/**
 *
 * @author daniel.uribeg
 */
public class Cuenta extends java.rmi.server.UnicastRemoteObject implements CuentaRemota{

    private long saldo;
    private long numero;
    private static long numCuentas;
    
    Cuenta() throws java.rmi.RemoteException{
        numero=++numCuentas;
    }
    
    
    public long mostrarSaldo() throws RemoteException {
        return saldo;
    }

    
    public void ingreso(long importe) throws RemoteException {
        saldo+=importe;
    }

    
    public void reintegro(long importe) throws RemoteException {
        saldo+=importe;
    }

    
    public void transferencia(CuentaRemota cuenta, long importe) throws RemoteException {
       reintegro (importe);
       cuenta.ingreso(importe);
    }
    
}
