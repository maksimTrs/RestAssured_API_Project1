package apimethods.post;

import java.util.HashMap;
import java.util.Map;

public class PostPetCreation {

    private int id;
    private Map<String, String> category = new HashMap<String, String>();
    private String name;
    private Object photoUrls;
    // private List<String> photoUrls = new ArrayList<>();
    private Object tags;
    private String status;

    @Override
    public String toString() {
        return "PostPetCreation{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, String> getCategory() {
        return category;
    }

    public void setCategory(Map<String, String> category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(Object photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Object getTags() {
        return tags;
    }

    public void setTags(Object tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
