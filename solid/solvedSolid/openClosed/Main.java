package openClosed;

import openClosed.bad.AnotherBadClient;
import openClosed.bad.BadClient;
import openClosed.bad.BadServer;
import openClosed.good.AnotherGoodClient;
import openClosed.good.Client_I;
import openClosed.good.GoodClient;
import openClosed.good.GoodServer;

public class Main {
    public static void main(String[] args) {
        testBadO();
        testGoodO();
    }

    private static void testBadO() {
        BadClient client = new BadClient();
        BadServer server = new BadServer();
        server.reactToClient(client);

        AnotherBadClient anotherBadClient = new AnotherBadClient();
//        server.reactToClient(anotherBadClient);


    }

    private static void testGoodO() {
        Client_I client = new GoodClient();
        GoodServer server = new GoodServer();
        server.reactToClient(client);

        Client_I anotherGoodClient = new AnotherGoodClient();
        server.reactToClient(anotherGoodClient);
    }
}
