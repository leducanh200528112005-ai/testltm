package code;

import RMI.ByteService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMI_Byte_T4mLDW78 {
    public static void main(String[] args) {
        String studentCode = "B23DCCN025";
        String qCode = "T4mLDW78";

        try {
            ByteService service = (ByteService) Naming.lookup("rmi://36.50.135.242:1099/RMIByteService");

            byte[] data = service.requestData(studentCode, qCode);

            int[] count = new int[256];
            for (byte b: data) {
                count[b & 0xFF]++;
            }
            int minCount = Integer.MAX_VALUE;
            int minValue = 0;
            for (byte b : data) {
                int v = b % 0xFF;
                if (count[v] < minCount) {
                    minCount = count[v];
                    minValue = v;
                }
            }
            byte[] result = new byte[]{(byte) minValue, (byte) minCount};
            service.submitData(studentCode, qCode, result);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
