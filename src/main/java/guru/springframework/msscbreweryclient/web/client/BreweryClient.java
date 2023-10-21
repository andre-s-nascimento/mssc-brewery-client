package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDTO;
import guru.springframework.msscbreweryclient.web.model.CustomerDTO;
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
  public static final String CUSTOMER_PATH_V1 = "/api/v1/customer";
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

  public CustomerDTO getCustomerById(UUID uuid){
    return restTemplate.getForObject(apihost+CUSTOMER_PATH_V1+"/"+uuid, CustomerDTO.class);
  }

  public URI saveNewCustomer(CustomerDTO customerDTO){
    return restTemplate.postForLocation(apihost+CUSTOMER_PATH_V1, customerDTO);
  }

  public void updateCustomer(UUID uuid, CustomerDTO customerDTO){
    restTemplate.put(apihost+CUSTOMER_PATH_V1+"/"+uuid, customerDTO);
  }

  public void deleteCustomer(UUID uuid){
    restTemplate.delete(apihost+CUSTOMER_PATH_V1+"/"+uuid);
  }


  public void setApihost(String apihost) {
    this.apihost = apihost;
  }
}
