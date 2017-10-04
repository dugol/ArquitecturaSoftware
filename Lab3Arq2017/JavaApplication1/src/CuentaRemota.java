/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.Remote;

/**
 *
 * @author daniel.uribeg
 */
public interface CuentaRemota extends java.rmi.Remote {
     public long mostrarSaldo() throws java.rmi.RemoteException;
    public void ingreso (long importe) throws java.rmi.RemoteException;
    public void reintegro (long importe) throws java.rmi.RemoteException;
    public void transferencia (CuentaRemota cuenta, long importe)throws java.rmi.RemoteException;
}
