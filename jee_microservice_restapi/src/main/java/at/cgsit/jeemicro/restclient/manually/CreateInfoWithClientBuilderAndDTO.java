package at.cgsit.jeemicro.restclient.manually;


import at.cgsit.jeemicro.restclient.proxy.SimpleDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.json.JsonObject;
import jakarta.json.JsonString;
import jakarta.ws.rs.client.ClientBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * use jakarta ws ClientBuilder to create a client and call a rest service
 * <br/>
 *
 * shows how to deserialize the json result to a dto
 */
@RequestScoped
public class CreateInfoWithClientBuilderAndDTO {

    @ConfigProperty(name = "at.cgsit.jeemicro.manually.ciwithcb.url", defaultValue = "http://localhost:9000/createinfo/ext")
    String destinationUrl;

    public String createNumber() {

        SimpleDTO result = ClientBuilder.newClient()
                .target(destinationUrl)
                .request()
                .get(SimpleDTO.class);

        return result.getValueA();
    }

}
