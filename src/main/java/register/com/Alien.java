package register.com;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {
    private String name;
    private int point;
    private int Id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Alien{");
        sb.append("name='").append(name).append('\'');
        sb.append(", point=").append(point);
        sb.append(", Id=").append(Id);
        sb.append('}');
        return sb.toString();
    }
}
