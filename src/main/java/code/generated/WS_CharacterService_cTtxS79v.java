package code.generated;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import code.generated.RequestCharacter;
import code.generated.GetData;

public class WS_CharacterService_cTtxS79v {
    public static void main(String[] args) {
        String studentCode = "B23DCCN025";
        String qCode = "cTtxS79v";
        try {
            SoapCharacterService port = new CharacterService().getSoapCharacterServicePort();
            List<Integer> data = port.requestCharacter(studentCode, qCode);
            System.out.println("Data: " + data);
            int k = data.get(0);
            List<Integer> rotated = new ArrayList<>(data);
            Collections.rotate(rotated, k);
            System.out.println("Rotated: " + rotated);
            port.submitCharacterCharArray(studentCode, qCode, rotated);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
