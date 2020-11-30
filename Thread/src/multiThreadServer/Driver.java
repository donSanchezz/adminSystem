package multiThreadServer;

public class Driver {

	public static void main(String[] args) {

		//To run, use the SocketServer first, then the client
		SocketServer ss = new SocketServer();
		ss.runServer();
		
		//Now you need to tie in together the student and such classes,
		//where it makes the request and the server returns the info needed.
	}

}
