package ma.formations.rest.service;

import ma.formations.rest.dtos.customer.*;

import java.util.List;

public interface ICustomerService {
    List<CustomerDto> getAllCustomers();

    AddCustomerResponse createCustomer(AddCustomerRequest addCustomerRequest);

    UpdateCustomerResponse updateCustomer(Long id, UpdateCustomerRequest updateCustomerRequest);

    CustomerDto getCustomByIdentity(String identity);

    String deleteCustomerByIdentityRef(String identityRef);

    CustomerDto getCustomById(Long id);

    String deleteCustomerById(Long id);

    List<CustomerDto> findAll(Integer page, Integer size);
}
