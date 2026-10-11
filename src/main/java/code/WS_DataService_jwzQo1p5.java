package code;

import code.generated.DataService;
import code.generated.SoapDataService;

import java.util.List;

public class WS_DataService_jwzQo1p5 {
    public static void main(String[] args) {
        String studentCode = "B23DCCN025";
        String qCode = "jwzQo1p5";

        try {
            SoapDataService port = new DataService().getSoapDataServicePort();

            List<Integer> data = port.getData(studentCode, qCode);
            System.out.println("Data: " + data);
            int sum = 0;
            for (Integer n : data) {
                sum += n;
            }
            System.out.println("Sum: " + sum);
            port.submitDataInt(studentCode, qCode, sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
