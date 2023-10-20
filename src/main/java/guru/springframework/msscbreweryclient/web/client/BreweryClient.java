package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDTO;
import java.net.URI;
import java.util.UUID;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {
  public static final String BEER_PATH_V1 = "/api/v1/beer";
  private String apihost;

  private final RestTemplate restTemplate;

  public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public BeerDTO getBeerById(UUID uuid) {
    return restTemplate.getForObject(apihost + BEER_PATH_V1 + "/" + uuid, BeerDTO.class);
  }

  public URI saveNewBeer(BeerDTO beerDTO) {
    return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDTO);
  }

  public void updateBeer(UUID uuid, BeerDTO beerDTO) {
    restTemplate.put(apihost + BEER_PATH_V1 + "/" + uuid, beerDTO);
  }

  public void deleteBeer(UUID uuid) {
    restTemplate.delete(apihost + BEER_PATH_V1 + "/" + uuid);
  }

  public void setApihost(String apihost) {
    this.apihost = apihost;
  }
}
