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

        Enums.TestType testType;

        try {
            testType = Enums.TestType.valueOf(args[0]);
        } catch (Exception e) {
            System.out.println("Only the following commands are valid:");
            System.out.println(java.util.Arrays.asList(Enums.TestType.values()));
            return;
        }

        switch (testType) {
            case IS_ALIVE:
                test = new TestTypes.IsAliveTest(nodes);
                break;
            case WIPEOUT:
                test = new TestTypes.WipeoutTest(nodes);
                break;
            case MEMBERSHIP_COUNT:
                test = new TestTypes.GetMembershipCountTest(nodes);
                break;
            case SFE_PUT:
                int frontendNodeId = Integer.parseInt(args[1]);
                int numRuns = Integer.parseInt(args[2]);
                test = new TestTypes.SingleFrontEndPutTest(nodes, numRuns, frontendNodeId);
                break;
            case SHUTDOWN:
            	test = new TestTypes.ShutDownTest(nodes);
            	break;
            case MEMORY:
                int valueSize = Integer.parseInt(args[1]);
                test = new TestTypes.MaxMemoryTest(nodes, valueSize);
                break;
            case RESPONSE_TIME:
                int numRuns2 = Integer.parseInt(args[1]);
                int selectTopNodes = args.length == 3 ? Integer.parseInt(args[2]) : 0;
                test = new TestTypes.ResponseTimeTest(nodes, numRuns2, selectTopNodes);
                break;
            default:
                System.out.println("Invalid test type.");
                System.exit(1);
        }

        test.execute();
    }
}
