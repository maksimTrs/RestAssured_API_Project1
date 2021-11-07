package apimethods.post;

import java.lang.reflect.Array;
import java.util.*;

public class PostPetCreation {

    private int id;
    private Map<String, String> category = new HashMap<String, String>();
    private String name;
    private String[] photoUrls = new  String[3];
    private Object tags;
    private String status;

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

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
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

    @Override
    public String toString() {
        return "PostPetCreation{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + Arrays.toString(photoUrls) +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
