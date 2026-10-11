package code;

import RMI.CharacterService;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMI_Character_Zxxv8ECS {
    public static void main(String[] args) {
        String studentCode = "B23DCCN025";
        String qCode = "Zxxv8ECS";

        try {
            CharacterService service = (CharacterService) Naming.lookup("rmi://36.50.135.242/RMICharacterService");
            String data = service.requestCharacter(studentCode, qCode);
            System.out.println("data: " + data);
            String result = new URI(null, null, data, null).toASCIIString();
            service.submitCharacter(studentCode, qCode, result);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
