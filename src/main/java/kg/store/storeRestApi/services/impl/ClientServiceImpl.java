package kg.store.storeRestApi.services.impl;

import kg.store.storeRestApi.dao.ClientRepo;
import kg.store.storeRestApi.exceptions.ClientExceptions;
import kg.store.storeRestApi.mappers.ClientMapper;
import kg.store.storeRestApi.models.dto.ClientDto;
import kg.store.storeRestApi.services.ClientService;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;
    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }
    private final ClientMapper clientMapper = ClientMapper.INSTANCE;
    private final Logger logger = Logger.getLogger(ClientServiceImpl.class);

    @Override
    public ClientDto save(ClientDto clientDto) {
        return clientMapper.toDto(clientRepo.save(clientMapper.toEntity(clientDto)));
    }

    @Override
    public ClientDto update(ClientDto clientDto) {
        if (!clientRepo.existsById(clientDto.getId())) {
            throw new ClientExceptions("Клиент не найден!");
        }
        logger.info("Клиент clientDto {} изменена ");
        return clientMapper.toDto(clientRepo.save(clientMapper.toEntity(clientDto)));
    }

    @Override
    public ClientDto findById(Long id) {
        return clientMapper.toDto(clientRepo.findById(id)
                .orElseThrow(()-> new ClientExceptions("Не найден клиент с такой id {}")));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientMapper.toDtos(clientRepo.findAll());
    }
}
