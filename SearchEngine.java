import java.io.IOException;
import java.net.URI;

class SearchEngine implements URLHandler {
    ArrayList<String> str = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                str.append(parameters[1]);
                return parameters[1];
            }
        }
        else if(url.getPath().contains("/search")){
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                str.search(parameters[1]);
                return String.format("Searched for %s", parameters[1]);
        }
        return "404 Not Found!";
    }
}
}

class NumberServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
