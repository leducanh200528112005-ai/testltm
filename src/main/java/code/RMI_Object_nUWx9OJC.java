package code;

import RMI.ObjectService;
import RMI.TicketSla;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Objects;

public class RMI_Object_nUWx9OJC {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String studentCode = "B23DCCN025";
        String qCode = "nUWx9OJC";

        ObjectService service = (ObjectService) Naming.lookup("rmi://36.50.135.242/RMIObjectService");

        TicketSla data = (TicketSla) service.requestObject(studentCode, qCode);

        String priority = data.getPriority();
        int opened = data.getOpenedHoursAgo();

        data.setAction("MONITOR");
        if (priority.equals("CRITICAL") && opened > 2) {
            data.setBreached(true);
            data.setAction("ESCALATE_L2");
        } else if (priority.equals("HIGH") && opened > 8) {
            data.setBreached(true);
            if (opened > 96) {
                data.setAction("ESCALATE_L2");
            } else {
            data.setAction("ESCALATE_L1"); }
        }
        else if (priority.equals("MEDIUM") && opened > 24) {
            data.setBreached(true);
            data.setAction("ESCALATE_L1");
            if (opened > 96) {
                data.setAction("ESCALATE_L2");
            } else {
                data.setAction("ESCALATE_L1"); }
        }
        else if (priority.equals("LOW") && opened > 72) {
            data.setBreached(true);
            data.setAction("ESCALATE_L1");
            if (opened > 96) {
                data.setAction("ESCALATE_L2");
            } else {
                data.setAction("ESCALATE_L1"); }
        }
        service.submitObject(studentCode, qCode, data);
    }
}
