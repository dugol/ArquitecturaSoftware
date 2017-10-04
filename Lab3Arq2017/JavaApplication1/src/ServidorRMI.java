import java.rmi.Naming;

/**
 *
 * @author daniel.uribeg
 */
public class ServidorRMI {


    public static void main(String arg[])throws Exception{
        Cuenta c1= new Cuenta();
        Naming.rebind("cuenta1", c1);
        Cuenta c2 = new Cuenta();
        Naming.rebind("cuenta2", c2);
        
    }
}
