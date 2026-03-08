package ma.formations.rest.presentation.rest;

import jakarta.validation.Valid;
import ma.formations.rest.dtos.customer.*;
import ma.formations.rest.service.ICustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
@CrossOrigin("http://localhost:3000/")
public class CustomerRestController {

    private final ICustomerService customerService;

    public CustomerRestController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    List<CustomerDto> customers() {
        return customerService.getAllCustomers();
    }


    @GetMapping("{id}")
    CustomerDto customerById(@PathVariable(value = "id") Long id) {
        return customerService.getCustomById(id);
    }

    @PostMapping("")
    public ResponseEntity<AddCustomerResponse> createCustomer(@RequestBody @Valid AddCustomerRequest dto) {
        return new ResponseEntity<>(customerService.createCustomer(dto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<UpdateCustomerResponse> updateCustomer(@PathVariable Long id, @RequestBody @Valid UpdateCustomerRequest dto) {
        return new ResponseEntity<>(customerService.updateCustomer(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(String.format("Customer with id=%s was removed with success", id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> getCustomersByIntervalles(@RequestParam Map<String, String> parameters) {
        Integer size = Integer.parseInt(parameters.get("size"));
        Integer page = Integer.parseInt(parameters.get("page"));
        List<CustomerDto> customers = customerService.findAll(page, size);
        Integer customerNumber = customerService.getAllCustomers().size();

        Map<String, Object> result = new HashMap<>();
        result.put("customers", customers);
        result.put("size", customerNumber);

        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
