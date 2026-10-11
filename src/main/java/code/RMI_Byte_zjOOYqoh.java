package code;

import RMI.ByteService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMI_Byte_zjOOYqoh {
    public static void main(String[] args) {
        String studentCode = "B23DCCN025";
        String qCode = "zjOOYqoh";

        try {
            ByteService service = (ByteService) Naming.lookup("rmi://36.50.135.242/RMIByteService");

            byte[] data = service.requestData(studentCode, qCode);

            int[] count = new int[256];
            for (byte b : data) {
                count[b & 0xFF]++;
            }

            int maxCount = Integer.MIN_VALUE;
            int maxValue = 0;

            for (byte b : data) {
                int v = b % 0xFF;
                if (maxCount < count[v]) {
                    maxCount = count[v];
                    maxValue = v;
                }
            }
            byte[] result = new byte[]{(byte) maxValue, (byte) maxCount};
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
