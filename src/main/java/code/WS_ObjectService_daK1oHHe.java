package code;

import code.generated.EmployeeY;
import code.generated.ObjectService;
import code.generated.SoapObjectService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WS_ObjectService_daK1oHHe {
    public static void main(String[] args) {
        String studentCode = "B23DCCN025";
        String qCode = "daK1oHHe";

        try {
            SoapObjectService port = new ObjectService().getSoapObjectServicePort();
            List<EmployeeY> data = port.requestListEmployeeY(studentCode, qCode);
            data.sort(Comparator.comparing(e -> e.getStartDate().toGregorianCalendar()));

            port.submitListEmployeeY(studentCode, qCode, data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
