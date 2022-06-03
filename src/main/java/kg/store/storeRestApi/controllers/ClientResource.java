package kg.store.storeRestApi.controllers;

import kg.store.storeRestApi.models.RestResponse;
import kg.store.storeRestApi.models.dto.ClientDto;
import kg.store.storeRestApi.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientResource {
    private final ClientService clientService;

    @PostMapping("/create")
    public RestResponse createClient(@RequestBody ClientDto clientDto) {
        return new RestResponse(200, "Клиент создано!", clientService.save(clientDto));
    }

    @PostMapping("/update")
    public RestResponse updateClient(@RequestBody ClientDto clientDto) {
        return new RestResponse(200, "Данные клиента изменены!", clientService.update(clientDto));
    }

    @GetMapping("/findById/{id}")
    public RestResponse findClientById(@PathVariable Long id) {
        return new RestResponse(200, "Найдено!", clientService.findById(id));
    }

    @GetMapping("/findAll")
    public RestResponse findAllClients() {
        return new RestResponse(200, "ВСе клиенты", clientService.findAll());
    }
}
