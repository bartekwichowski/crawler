import com.google.gson.Gson;
import com.sun.corba.se.impl.orbutil.ObjectWriter;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    private final static String START_POINT = "http://wiprodigital.com ";

    Set<String> visitedLinks = new HashSet<String>();

    public static void main(String[] args) throws IOException {
        Link root = Builder.crawl(START_POINT, 10);

        Gson gson = new Gson();
        File file = new File("WIPRO");
        gson.toJson(root, new FileWriter(file));

//        System.out.print(jsonInString);

//        Graph graph = new SingleGraph("Wipro");
//        graph.setStrict(false);
//        graph.setAutoCreate(true);
//        graph.addNode(root.getUrl());
//
//        Deque<Link> queueLinks = new ArrayDeque<Link>(Arrays.asList(root));
//        while (queueLinks.size() > 0) {
//            Link l = queueLinks.pop();
//            Set<Link> children = l.getChildren();
//            queueLinks.addAll(children);
//            for (Link child : children) {
//                graph.addNode(child.getUrl()).addAttribute(child.getUrl());
//                graph.addEdge( UUID.randomUUID().toString(), l.getUrl(), child.getUrl());
//            }
//        }
//
//        graph.display();
    }


}
