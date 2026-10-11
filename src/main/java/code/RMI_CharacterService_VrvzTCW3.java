package code;

import RMI.CharacterService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMI_CharacterService_VrvzTCW3 {
    public static String toRoman(int n) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (n >= values[i]) {
                result.append(symbols[i]);
                n -= values[i];
            }
        }
        return result.toString();
    }
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String studentCode = "B23DCCN025";
        String qCode = "VrvzTCW3";

        try {
            CharacterService service = (CharacterService) Naming.lookup("rmi://36.50.135.242/RMICharacterService");

            String data = service.requestCharacter(studentCode, qCode);
            System.out.println("data: " + data);

            String result = toRoman(Integer.parseInt(data));

            service.submitCharacter(studentCode, qCode, result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
