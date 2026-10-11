package code;

import code.generated.DataService;
import code.generated.SoapDataService;

import java.util.ArrayList;
import java.util.List;

public class WS_DataService_weXES1GN {
    public static void main(String[] args) {
        String studentCode = "B23DCCN025";
        String qCode = "weXES1GN";

        try {
            SoapDataService port = new DataService().getSoapDataServicePort();

            List<Integer> data = port.getData(studentCode, qCode);
            System.out.println("Data: " + data);

            List<String> parts = new ArrayList<>();
            for (Integer n : data) {
                parts.add(String.valueOf(n));
            }
            parts.sort((a, b) -> (b + a).compareTo(a + b));

            StringBuilder sb = new StringBuilder();
            for (String s : parts) {
                sb.append(s);
            }
            String result = sb.toString();
            System.out.println("Result: " + result);

            port.submitDataString(studentCode, qCode, result);
            System.out.println("Submitted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}