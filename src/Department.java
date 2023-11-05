import java.util.List;

public class Department {

    private Long Id;
    private String name;
    private List<String> address;

    public Department(Long id, String name, List<String> address) {
        Id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
}
