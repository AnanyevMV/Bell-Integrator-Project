package ru.bellintegrator.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.dto.OrganizationDTO;
import ru.bellintegrator.entity.Organization;
import ru.bellintegrator.service.organization.OrganizationService;

import java.util.List;

/**
 * REST-контроллер, отвечающий за REST-запросы, связанные с организациями.
 */
@RestController
@RequestMapping("/api")
public class OrganizationRestController {

    /**
     * У контроллера имеется зависимость organizationService - сервис, предоставляющий методы для<br>
     * получения, сохранения и обновления организаций.
     */
    private final OrganizationService organizationService;

    /**
     * Конструктор класса OrganizationRestController. Используется внедрение зависимости organizationService<br>
     * через конструктор
     *
     * @param organizationService - сервис для получения, сохранения, обновления организаций
     */
    @Autowired
    public OrganizationRestController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * Метод обрабатывает GET-запрос для получения списка всех организаций.
     *
     * @return список OrganizationDTO
     */
    @GetMapping("/organization/list")
    public List<OrganizationDTO> getOrganizations() {
        return organizationService.getOrganizations();
    }

    /**
     * Метод обрабатывает POST-запрос для получения списка организаций по фильтру
     * @param filter фильтр
     * @return список OrganizationDTO
     */
    @PostMapping("/organization/list")
    public List<OrganizationDTO> getOrganizations(@RequestBody OrganizationDTO filter) {
        return organizationService.getOrganizations(filter);
    }

    /**
     * Метод обрабатывает GET-запрос для получения организации по её идентификатору
     *
     * @param id идентификатор организации
     * @return OrganizationDTO
     */
    @GetMapping("/organization/{id}")
    public OrganizationDTO getOrganization(@PathVariable("id") Long id) {
        return organizationService.getOrganization(id);
    }

    /**
     * Метод обрабатывает POST-запрос для сохранения организации
     *
     * @param organizationDTO DTO-объект, полученный из тела HTTP-запроса
     */
    @PostMapping("/organization/save")
    public void saveOrganization(@RequestBody OrganizationDTO organizationDTO) {
        organizationService.saveOrganization(organizationDTO);
    }

    /**
     * Метод обрабатывает PUT-запрос для обновления организации
     *
     * @param organizationDTO DTO-объект, полученный из тела HTTP-запроса
     */
    @PutMapping("/organization/update")
    public void updateOrganization(@RequestBody OrganizationDTO organizationDTO) {
        organizationService.updateOrganization(organizationDTO);
    }

}
