package code;

import RMI.DataService;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

public class RMI_Data_ASg0jY70 {
    public static void main(String[] args) {
        String studentCode = "B23DCCN025";
        String qCode = "ASg0jY70";
        try {
            DataService service = (DataService) Naming.lookup("rmi://36.50.135.242:1099/RMIDataService");

            int[] arr = service.requestData(studentCode, qCode);   // nếu probe ra List<Integer> thì sửa dòng này
            System.out.println("Data: " + java.util.Arrays.toString(arr));

            List<Integer> peaks = new ArrayList<>();
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                boolean leftOk  = (i == 0)     || arr[i] > arr[i - 1];
                boolean rightOk = (i == n - 1) || arr[i] > arr[i + 1];
                if (leftOk && rightOk) peaks.add(i + 1);           // chỉ số 1-based
            }
            System.out.println("Peaks: " + peaks);

            service.submitData(studentCode, qCode, peaks);
            System.out.println("Submitted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}