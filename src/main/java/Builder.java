import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class Builder {

    protected static Link crawl(String start, int depthLevel) {
        Link root = new Link(start);
        Set<Link> visited = new HashSet<Link>();
        Deque<Link> queueLinks = new ArrayDeque<Link>(Arrays.asList(root));
        int levelCount = 0;
        while (queueLinks.size() > 0 && levelCount < depthLevel) {
            Link l = queueLinks.pop();
            Set<Link> children = fetchLinks(l);
            l.addAll(children);

            for (Link child : children) {
                if (!visited.contains(child)) {
                    queueLinks.addAll(children);
                    visited.add(l);
                }
            }

            levelCount++;
        }
        return root;
    }

    private static Set<Link> fetchLinks(Link link) {
        Set<Link> links = new HashSet<Link>();
        try {
            Document doc = Jsoup.connect(link.getUrl())
                    .timeout(10 * 1000)
                    .get();
            Elements elements = doc.select("a");

            for (Element e : elements) {
                links.add(new Link( e.attr("abs:href")));
            }
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return links;
    }
}
