package CPEN431_8A;

import com.google.protobuf.ByteString;

import java.net.SocketException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class TestTypes {
    static final SecureRandom random = new SecureRandom();

    public static abstract class Test {
        Transport transport;
        ConcurrentHashMap<Integer, ServerNodes.Node> nodes;
        final int MAX_KEY_SIZE = 32;
        final int MAX_VALUE_SIZE = 10000;

        public int numOfThreads = 1;

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

        public abstract void execute();
    }

    // send a IS_ALIVE request to each node
    public static class IsAliveTest extends Test {
        public IsAliveTest(ConcurrentHashMap<Integer, ServerNodes.Node> nodes) {
            super(nodes);
            System.out.println(this.getClass().getSimpleName());
        }

        public void execute() {
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

        public void execute() {
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

        public void execute() {
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
        int frontendNodeId;

        public SingleFrontEndPutTest(ConcurrentHashMap<Integer, ServerNodes.Node> nodes,
                                     int numRuns,
                                     int frontendNodeId) {
            super(nodes);
            System.out.println(this.getClass().getSimpleName());
            this.numRuns = numRuns;
            this.frontendNodeId = frontendNodeId;
        }

        public void execute() {
            ServerNodes.Node node = nodes.get(frontendNodeId);

            HashMap<Integer, Integer> failResult = new HashMap<>();

            for (int i = 0; i < numRuns; ++i) {
                // put a random key-value pair
                Request putRequest = new Request();
                putRequest.command = Enums.CommandCode.PUT;

                int randKeyLength = ThreadLocalRandom.current().nextInt(1, MAX_KEY_SIZE + 1);
                byte[] randKeyBytes = new byte[randKeyLength];
                random.nextBytes(randKeyBytes);
                putRequest.key = ByteString.copyFrom(randKeyBytes);

                int randValueLength = ThreadLocalRandom.current().nextInt(1, MAX_VALUE_SIZE + 1);
                byte[] randValueBytes = new byte[randValueLength];
                random.nextBytes(randValueBytes);
                putRequest.value = ByteString.copyFrom(randValueBytes);

                Response putResponse = transport.sendRequest(node, putRequest, 3);

                int hashcode = Math.abs(putRequest.key.hashCode()) % nodes.size();

                if (putResponse == null) {
                    System.out.printf("Key hashed to node %d: timeout.\n",
                            hashcode);

                    updateFailResult(failResult, hashcode);
                } else {
                    if (putResponse.code != Enums.ResponseCode.SUCCESS)
                        updateFailResult(failResult, hashcode);

                    System.out.printf("Key hashed to node %d: %s.\n",
                            hashcode,
                            putResponse.code.toString());
                }
            }

            if (failResult.size() != 0) {
                System.out.println("\nFail Result:");

                for (HashMap.Entry<Integer, Integer> resEntry : failResult.entrySet()) {
                    System.out.println("NodeId " + resEntry.getKey() + ": " + resEntry.getValue() + " fails");
                }
            }
        }

        private void updateFailResult(HashMap<Integer, Integer> failResult, int failNodeId) {
            if (failResult.containsKey(failNodeId))
                failResult.put(failNodeId, failResult.get(failNodeId) + 1);
            else
                failResult.put(failNodeId, 1);
        }
    }
    
    // send a SHUTDOWN -> IS_ALIVE request to each node
    public static class ShutDownTest extends Test {
        public ShutDownTest(ConcurrentHashMap<Integer, ServerNodes.Node> nodes) {
            super(nodes);
            System.out.println(this.getClass().getSimpleName());
        }

        public void execute() {
            for (ServerNodes.Node node : nodes.values()) {
                Request ShutDownRequest = new Request();
                ShutDownRequest.command = Enums.CommandCode.SHUTDOWN;

                // send shut down
                Response response = transport.sendRequest(node, ShutDownRequest, 1);

                if (response == null) {
                    System.out.printf("%s (%d): did not respond (PASS).\n",
                            node.address.getHostName(),
                            node.id);
                } else {
                    System.out.printf("%s (%d): %s (FAIL) \n",
                            node.address.getHostName(),
                            node.id,
                            response.code.toString());
                }
                
                // verify it was shut down
                System.out.printf("Checking if %s (%d) isAlive \n", 
                		node.address.getHostAddress(),
                		node.id);
                
                Request isAliveRequest = new Request();
                isAliveRequest.command = Enums.CommandCode.IS_ALIVE;

                response = transport.sendRequest(node, isAliveRequest, 1);

                // only log the ones that failed to reduce noise
                if (response != null) {
                    System.out.printf("%s (%d): %s (FAIL) \n",
                            node.address.getHostName(),
                            node.id,
                            response.code.toString());
                }
            }
        }
    }

    // Max memory test on first node in nodelist
    public static class MaxMemoryTest extends Test {
        int valueSize;

        public MaxMemoryTest(ConcurrentHashMap<Integer, ServerNodes.Node> nodes, int valueSize) {
            super(nodes);
            this.valueSize = valueSize;
            System.out.println(this.getClass().getSimpleName());
        }

        public void execute() {
            ServerNodes.Node node = nodes.get(0);
            System.out.printf("Target: %s:%d\n", node.address.getHostName(), node.port);

            long numPuts = 0;

            Response response;

            do {
                ByteString key = RandomUtil.getRandomByteString(1, MAX_KEY_SIZE);
                ByteString value = RandomUtil.getRandomByteString(valueSize, valueSize);

                Request request = new Request();
                request.command = Enums.CommandCode.PUT;
                request.key = key;
                request.value = value;

                response = transport.sendRequest(node, request, 3);
                numPuts++;
            } while (response != null && response.code == Enums.ResponseCode.SUCCESS);

            String responseResult = response == null ? "Timeout" : response.code.toString();
            double memoryLimit = valueSize * numPuts;

            System.out.println("Memory Test Complete");
            System.out.println("Terminating Response: " + responseResult);
            System.out.println("Memory Limit: " + memoryLimit / 1000000 + "MB");
        }
    }

    public static class ResponseTimeTest extends Test {
        int numRuns;
        int selectTopNodes;

        public ResponseTimeTest(ConcurrentHashMap<Integer, ServerNodes.Node> nodes,
                                int numRuns,
                                int selectTopNodes) {
            super(nodes);
            System.out.println(this.getClass().getSimpleName());
            this.numRuns = numRuns;
            this.selectTopNodes = selectTopNodes;
        }

        public void execute() {
            HashMap<Integer, NodeResultData> result = initResultMap(nodes.size());

            for (int i = 0; i < numRuns; ++i) {
                for (ServerNodes.Node node : nodes.values()) {
                    long startTime = System.currentTimeMillis();

                    Request isAliveRequest = new Request();
                    isAliveRequest.command = Enums.CommandCode.IS_ALIVE;

                    Response response = transport.sendRequest(node, isAliveRequest, 1);

                    if (response != null && response.code == Enums.ResponseCode.SUCCESS) {
                        long finishTime = System.currentTimeMillis();
                        NodeResultData nodeResultData = result.get(node.id);

                        nodeResultData.numRuns++;
                        nodeResultData.totalResponseTime += (finishTime - startTime);
                    }
                }
            }

            // sort the result from best response to worst
            ArrayList<NodeResultData> resultList = new ArrayList<>(result.values());
            Collections.sort(resultList);

            // print results
            for (NodeResultData nodeData : resultList) {
                ServerNodes.Node node = nodes.get(nodeData.nodeId);
                System.out.printf("%s (%d): %.2fms in %d runs\n",
                        node.address.getHostName(),
                        node.id,
                        nodeData.numRuns == 0 ? 0.0 : (nodeData.totalResponseTime / nodeData.numRuns),
                        nodeData.numRuns);
            }

            // get the top nodes in servers.txt format
            for (NodeResultData nodeData : resultList.subList(0, selectTopNodes)) {
                ServerNodes.Node node = nodes.get(nodeData.nodeId);
                System.out.printf("%s:%d\n", node.address.getHostName(), node.port);
            }
        }

        private class NodeResultData implements Comparable<NodeResultData> {
            public int nodeId;
            public int numRuns;
            public double totalResponseTime;

            public NodeResultData(int nodeId) {
                this.nodeId = nodeId;
                numRuns = 0;
                totalResponseTime = 0.0;
            }

            @Override
            public int compareTo(NodeResultData data) {
                // no runs were successful
                if (numRuns == 0)
                    return 1;
                else if (data.numRuns == 0)
                    return -1;

                return (totalResponseTime / numRuns) > (data.totalResponseTime / data.numRuns) ?
                        1 : -1;
            }
        }

        private HashMap<Integer, NodeResultData> initResultMap(int numNodes) {
            HashMap<Integer, NodeResultData> result = new HashMap<>();
            for (int i = 0; i < numNodes; ++i) {
                result.put(i, new NodeResultData(i));
            }

            return result;
        }
    }
}