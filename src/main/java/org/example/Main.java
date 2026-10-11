package code;

import code.generated.DataService;
import code.generated.SoapDataService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String studentCode = "B22DCCN001";
        String qCode = "YOUR_QCODE";

        try {
            // Khởi tạo SOAP service
            DataService service = new DataService();

            // Lấy port để gọi các phương thức
            SoapDataService port = service.getSoapDataServicePort();

            // Lấy danh sách số nguyên
            List<Integer> numbers = port.getData(studentCode, qCode);

            System.out.println("Du lieu nhan duoc: " + numbers);

            // Sắp xếp để tạo chuỗi số lớn nhất
            numbers.sort((a, b) ->
                    (b.toString() + a).compareTo(a.toString() + b)
            );

            // Ghép các số
            StringBuilder result = new StringBuilder();

            for (Integer number : numbers) {
                result.append(number);
            }

            String data = result.toString();

            System.out.println("Ket qua: " + data);

            // Gửi kết quả
            port.submitDataString(studentCode, qCode, data);

            System.out.println("Da gui ket qua!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}