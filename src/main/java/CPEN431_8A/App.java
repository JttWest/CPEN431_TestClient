package CPEN431_8A;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws
            IOException,
            ServerNodes.InvalidServerFileException
    {
        ConcurrentHashMap<Integer, ServerNodes.Node> nodes =
                ServerNodes.generateNodesMap("servers.txt");

        // IsAlive Test
        Transport transport = new Transport();

        for (ServerNodes.Node node : nodes.values()) {
            Request isAliveRequest = new Request();
            isAliveRequest.command = Enums.CommandCode.IS_ALIVE;

            Response response = transport.sendRequest(node, isAliveRequest, 1);

            if (response == null) {
                System.out.printf("IS_ALIVE request to %s (%d) timeout.\n",
                        node.address.getHostName(),
                        node.id);
            } else {
                System.out.printf("%s (%d) is ALIVE\n",
                        node.address.getHostName(),
                        node.id);
            }
        }
    }
}
