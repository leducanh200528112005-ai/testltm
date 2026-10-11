package code;

import code.generated.Customer;
import code.generated.ObjectService;
import code.generated.SoapObjectService;

import java.util.List;

public class WS_ObjectService_omBsbpKP {
    public static void main(String[] args) {
        String studentCode = "B23DCCN025";
        String qCode = "omBsbpKP";

        SoapObjectService port =
                new ObjectService().getSoapObjectServicePort();

        List<Customer> data =
                port.requestListCustomer(studentCode, qCode);

        data.removeIf(c ->
                c.getTotalSpent() <= 500
                        || c.getPurchaseCount() < 3
        );

        port.submitListCustomer(studentCode, qCode, data);
    }
}