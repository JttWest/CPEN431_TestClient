package CPEN431_8A;

import java.io.IOException;
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

        TestTypes.Test test = null;

        switch (args[0]) {
            case "IS_ALIVE":
                test = new TestTypes.IsAliveTest(nodes);
                break;
            case "WIPEOUT":
                test = new TestTypes.WipeoutTest(nodes);
                break;
            case "MEMBERSHIP_COUNT":
                test = new TestTypes.GetMembershipCountTest(nodes);
                break;
            case "SFE_PUT":
                int frontendNodeId = Integer.parseInt(args[1]);
                int numRuns = Integer.parseInt(args[2]);
                test = new TestTypes.SingleFrontEndPutTest(nodes, numRuns, frontendNodeId);
                break;
            case "SHUTDOWN":
            	test = new TestTypes.ShutDownTest(nodes);
            	break;
            case "MEMORY":
                int valueSize = Integer.parseInt(args[1]);
                test = new TestTypes.MaxMemoryTest(nodes, valueSize);
                break;
            default:
                System.out.println("Invalid test type. Use: IS_ALIVE, WIPEOUT, MEMBERSHIP_COUNT, SFE_PUT");
                System.exit(1);
        }

        test.execute();
    }
}
