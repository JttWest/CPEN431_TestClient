package CPEN431_8A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ConcurrentHashMap;

public class ServerNodes {
    public static ConcurrentHashMap<Integer, Node> generateNodesMap(String serversFile) throws
            IOException, InvalidServerFileException {
        ConcurrentHashMap<Integer, Node> resultNodes = new ConcurrentHashMap<>();

        BufferedReader bufRead = new BufferedReader(new FileReader(serversFile));
        int id = 0;

        String line;
        while ( (line = bufRead.readLine()) != null)
        {
            String[] addressPair = line.split(":");

            if (addressPair.length != 2) {
                throw new InvalidServerFileException("Format of server nodes list is incorrect.");
            }

            InetAddress ip = InetAddress.getByName(addressPair[0]);
            int port = Integer.valueOf(addressPair[1]);

            Node node = new Node(id, ip, port);
            resultNodes.put(id, node);

            id++;
        }

        System.out.println("Generated node map of size: " + resultNodes.size());

        return resultNodes;
    }

    public static class Node {
        public int id;
        public InetAddress address;
        public int port;

        public Node(int id, InetAddress address, int port) {
            this.id = id;
            this.address = address;
            this.port = port;
        }
    }

    public static class InvalidServerFileException extends Exception {
        public InvalidServerFileException(String message) {
            super(message);
        }
    }
}
