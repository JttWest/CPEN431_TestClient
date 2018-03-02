package CPEN431_8A;

import com.google.protobuf.ByteString;

import java.net.SocketException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class TestTypes {
    public static abstract class Test implements Runnable {
        Transport transport;
        ConcurrentHashMap<Integer, ServerNodes.Node> nodes;
        final int MAX_KEY_SIZE = 32;
        final int MAX_VALUE_SIZE = 10000;

        static final SecureRandom random = new SecureRandom();

        public Test(ConcurrentHashMap<Integer, ServerNodes.Node> nodes) {
            this.nodes = nodes;

            try {
                transport = new Transport();
            } catch (SocketException e) {
                System.out.println("Failed to set up Transport");
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    // send a IS_ALIVE request to each node
    public static class IsAliveTest extends Test {
        public IsAliveTest(ConcurrentHashMap<Integer, ServerNodes.Node> nodes) {
            super(nodes);
            System.out.println(this.getClass().getSimpleName());
        }

        @Override
        public void run() {
            for (ServerNodes.Node node : nodes.values()) {
                Request isAliveRequest = new Request();
                isAliveRequest.command = Enums.CommandCode.IS_ALIVE;

                Response response = transport.sendRequest(node, isAliveRequest, 1);

                if (response == null) {
                    System.out.printf("%s (%d): no valid response.\n",
                            node.address.getHostName(),
                            node.id);
                } else {
                    System.out.printf("%s (%d): %s \n",
                            node.address.getHostName(),
                            node.id,
                            response.code.toString());
                }
            }
        }
    }

    // send a WIPEOUT request to each node
    public static class WipeoutTest extends Test {
        public WipeoutTest(ConcurrentHashMap<Integer, ServerNodes.Node> nodes) {
            super(nodes);
            System.out.println(this.getClass().getSimpleName());
        }

        @Override
        public void run() {
            for (ServerNodes.Node node : nodes.values()) {
                Request isAliveRequest = new Request();
                isAliveRequest.command = Enums.CommandCode.WIPEOUT;

                Response response = transport.sendRequest(node, isAliveRequest, 1);

                if (response == null) {
                    System.out.printf("%s (%d): no valid response.\n",
                            node.address.getHostName(),
                            node.id);
                } else {
                    System.out.printf("%s (%d): %s \n",
                            node.address.getHostName(),
                            node.id,
                            response.code.toString());
                }
            }
        }
    }

    public static class GetMembershipCountTest extends Test {
        public GetMembershipCountTest(ConcurrentHashMap<Integer, ServerNodes.Node> nodes) {
            super(nodes);
            System.out.println(this.getClass().getSimpleName());
        }

        @Override
        public void run() {
            for (ServerNodes.Node node : nodes.values()) {
                Request getMembershipCountRequest = new Request();
                getMembershipCountRequest.command = Enums.CommandCode.GET_MEMBERSHIP_COUNT;

                Response response = transport.sendRequest(node, getMembershipCountRequest, 1);

                if (response == null) {
                    System.out.printf("%s (%d): no valid response.\n",
                            node.address.getHostName(),
                            node.id);
                } else {
                    System.out.printf("%s (%d): %s %d\n",
                            node.address.getHostName(),
                            node.id,
                            response.code.toString(),
                            response.membershipCount);
                }
            }
        }
    }

    public static class SingleFrontEndPutTest extends Test {
        int numRuns;

        public SingleFrontEndPutTest(ConcurrentHashMap<Integer, ServerNodes.Node> nodes, int numRuns) {
            super(nodes);
            System.out.println(this.getClass().getSimpleName());
            this.numRuns = numRuns;
        }

        @Override
        public void run() {
            ServerNodes.Node node = nodes.get(0);

            HashMap<Integer, Integer> timeoutResult = new HashMap<>();

            for (int i = 0; i < numRuns; ++i) {
                // put a random key-value pair
                Request putRequest = new Request();
                putRequest.command = Enums.CommandCode.PUT;

                int randKeyLength = ThreadLocalRandom.current().nextInt(0, MAX_KEY_SIZE + 1);
                byte[] randKeyBytes = new byte[randKeyLength];
                random.nextBytes(randKeyBytes);
                putRequest.key = ByteString.copyFrom(randKeyBytes);

                int randValueLength = ThreadLocalRandom.current().nextInt(0, MAX_VALUE_SIZE + 1);
                byte[] randValueBytes = new byte[randValueLength];
                random.nextBytes(randValueBytes);
                putRequest.value = ByteString.copyFrom(randValueBytes);

                Response putResponse = transport.sendRequest(node, putRequest, 3);

                int hashcode = Math.abs(putRequest.key.hashCode()) % nodes.size();

                if (putResponse == null) {
                    System.out.printf("Key hashed to node %d: timeout.\n",
                            hashcode);

                    if (timeoutResult.containsKey(hashcode))
                        timeoutResult.put(hashcode, timeoutResult.get(hashcode) + 1);
                    else
                        timeoutResult.put(hashcode, 1);
                } else {
                    System.out.printf("Key hashed to node %d: %s.\n",
                            hashcode,
                            putResponse.code.toString());
                }
            }

            for (HashMap.Entry<Integer, Integer> resEntry : timeoutResult.entrySet()) {
                System.out.println(resEntry.getKey() + ": " + resEntry.getValue() + " timeouts");
            }
        }
    }
}