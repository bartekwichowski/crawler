import java.util.*;

public class Link {

    private String url;

    private Set<Link> children = new HashSet<Link>();

    public Link(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Link> getChildren() {
        return children;
    }

    public void setChildren(Set<Link> children) {
        this.children = children;
    }

    public void addAll(Set<Link> links) {
        this.children.addAll(links);
    }

    @Override
    public String toString() {
        return "Link{" +
                "url='" + url + '\'' +
                ", children=" + children.size() +
                '}';
    }
}
