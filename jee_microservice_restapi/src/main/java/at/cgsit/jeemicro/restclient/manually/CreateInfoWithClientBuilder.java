package at.cgsit.jeemicro.restclient.manually;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.json.JsonObject;
import jakarta.json.JsonString;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * use jakarta ws ClientBuilder to create a client and call a rest service
 * <br/>
 * shows how to use the jakarta.json api to access the json result
 * */
@RequestScoped
public class CreateInfoWithClientBuilder {

    @ConfigProperty(name = "at.cgsit.jeemicro.manually.ciwithcb.url", defaultValue = "http://localhost:9000/createinfo/ext")
    String destinationUrl;

    public String createNumber() {

        JsonObject result = ClientBuilder.newClient()
                .target(destinationUrl)
                .request()
                .get(JsonObject.class);

        // JsonObject helper methods to access json values
        // if the object would be structured with sub oject like parent->child->value
        // you can use         result.getJsonObject("parent").getJsonObject("child").getString("value");
        String valueA = result.getString("valueA");
        JsonString valueB = result.getJsonString("valueB");

        return valueA;
    }

}
