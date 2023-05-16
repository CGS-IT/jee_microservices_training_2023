package at.cgsit.jeemicro.resource.json.dto;


import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestDTO {

    private Long id;
    String name;
    String vorname;

    // ocalDateTime datum = LocalDateTime.now();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }


    @Override
    public String toString() {
        return "TestDTO{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                '}';
    }
}

