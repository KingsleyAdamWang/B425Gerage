package Server;

public class Server {

    public static void main(String[] args) {
        try {
//            Logger.info("Try start server...");
        	System.out.println("TRY START SERVER.....");
            RMIHelper.init();
//            Logger.info("Server is now running!");
            System.out.println("SERVER IS RUNNING...");
        } catch (ServerInitException e) {
        	System.out.println("SERVER START FAIL!!!");
        	e.printStackTrace();
//            Logger.error("Server starts fail!");
//            Logger.error(e);
        }
    }
}
