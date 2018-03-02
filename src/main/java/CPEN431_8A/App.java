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
        if (args.length != 1) {
            System.out.println("Need to pass in test type!");
            System.exit(1);
        }

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
                test = new TestTypes.SingleFrontEndPutTest(nodes, 500);
                break;
            default:
                System.out.println("Invalid test type. Use: IS_ALIVE, WIPEOUT, MEMBERSHIP_COUNT, SFE_PUT");
                System.exit(1);
        }

        Thread testThread = new Thread(test);

        testThread.start();
    }
}
