package ru.bellintegrator.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.dto.OrganizationDTO;
import ru.bellintegrator.service.organization.OrganizationService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrganizationRestController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationRestController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organization/list")
    public List<OrganizationDTO> getOrganizations() {
        return organizationService.getOrganizations();
    }

    @GetMapping("/organization/{id}")
    public OrganizationDTO getOrganization(@PathVariable("id") Long id) {
        return organizationService.getOrganization(id);
    }

    @PostMapping("/organization/save")
    public void saveOrganization(@RequestBody OrganizationDTO organizationDTO) {
        organizationService.saveOrganization(organizationDTO);
    }

    @PutMapping("/organization/update")
    public void updateOrganization(@RequestBody OrganizationDTO organizationDTO) {
        System.out.println(organizationDTO);
        organizationService.updateOrganization(organizationDTO);
    }

}
