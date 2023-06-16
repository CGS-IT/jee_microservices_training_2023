package at.cgsit.jeemicro.resource.json.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDate;
import java.util.Date;

@XmlRootElement
@JsonRootName(value = "TestDTO")
@JsonPropertyOrder({ "id","name", "vorname" })
public class TestDTO {

    @JsonProperty(value = "id", required = true, access = JsonProperty.Access.READ_WRITE, defaultValue = "-1")
    private Long id;

    @JsonProperty(value = "name", required = true, access = JsonProperty.Access.READ_WRITE, defaultValue = "nameDefault")
    String name;

    @JsonProperty(value = "vorname", required = false, access = JsonProperty.Access.READ_WRITE, defaultValue = "vornameDefault")
    String vorname;

    @JsonProperty(value = "isOk", required = false, access = JsonProperty.Access.READ_WRITE, defaultValue = "true")
    Boolean isOk;

    @JsonProperty(value = "enumTest", required = false, access = JsonProperty.Access.READ_WRITE, defaultValue = "ENUM1")
    EnumTest enumTest;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date eventDate;

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

    public Boolean getOk() {
        return isOk;
    }

    public void setOk(Boolean ok) {
        isOk = ok;
    }

    public EnumTest getEnumTest() {
        return enumTest;
    }

    public void setEnumTest(EnumTest enumTest) {
        this.enumTest = enumTest;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "TestDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", isOk=" + isOk +
                ", enumTest=" + enumTest +
                ", eventDate=" + eventDate +
                '}';
    }
}

