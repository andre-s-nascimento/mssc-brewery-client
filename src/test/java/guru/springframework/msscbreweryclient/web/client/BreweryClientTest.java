package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.*;

import guru.springframework.msscbreweryclient.web.model.BeerDTO;
import guru.springframework.msscbreweryclient.web.model.CustomerDTO;
import java.net.URI;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BreweryClientTest {
  @Autowired BreweryClient client;
  @Test
  void testGetBeerById() {
    BeerDTO dto = client.getBeerById(UUID.randomUUID());
    assertNotNull(dto);
  }

  @Test
  void testSaveNewBeer() {
    BeerDTO beerDTO = BeerDTO.builder().beerName("New Beer").build();

    URI uri = client.saveNewBeer(beerDTO);

    assertNotNull(uri);
    System.out.println(uri);
  }

  @Test
  void testUpdateBeer() {
    BeerDTO beerDTO = BeerDTO.builder().beerName("New Beer").build();
    client.updateBeer(UUID.randomUUID(), beerDTO);
  }

  @Test
  void testDeleteBeer() {
    client.deleteBeer(UUID.randomUUID());
  }

  @Test
  void testGetCustomerById() {
    CustomerDTO dto = client.getCustomerById(UUID.randomUUID());
    assertNotNull(dto);
  }

  @Test
  void testSaveNewCustomer() {
    CustomerDTO customerDTO = CustomerDTO.builder().name("Patrick Mahomes").build();

    URI uri = client.saveNewCustomer(customerDTO);
    assertNotNull(uri);
    System.out.println(uri);
  }

  @Test
  void testUpdateCustomer() {
    CustomerDTO customerDTO = CustomerDTO.builder().name("Patrick Mahomes").build();
    client.updateCustomer(UUID.randomUUID(), customerDTO);

  }

  @Test
  void testDeleteCustomer() {
    client.deleteCustomer(UUID.randomUUID());
  }
}
