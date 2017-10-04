/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author daniel.uribeg
 */
public abstract class ClienteRMI implements CuentaRemota{

    public static void main(String args[]) throws Exception{
        CuentaRemota c1=(CuentaRemota)Naming.lookup("//localhost/cuenta1");
        CuentaRemota c2=(CuentaRemota)Naming.lookup("//localhost/cuenta2");
        c1.ingreso(1000);
        c1.transferencia(c2,400);
        System.out.println("saldo cuenta 1:"+ c1.mostrarSaldo()+ "\nsaldo Cuenta 2" +c2.mostrarSaldo());
    }
    
}
