package ru.bellintegrator.controller.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.dto.OfficeDTO;
import ru.bellintegrator.service.office.OfficeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OfficeRestController {

    private final OfficeService officeService;

    @Autowired
    public OfficeRestController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/office/list")
    public List<OfficeDTO> getOffices() {
        return officeService.getOffices();
    }

    @GetMapping("/office/{id}")
    public OfficeDTO getOffice(@PathVariable("id") Long id) {
        return officeService.getOffice(id);
    }

    @PutMapping("/office/update")
    public void updateOffice(@RequestBody OfficeDTO officeDTO) {
        officeService.updateOffice(officeDTO);
    }

    @PostMapping("/office/save")
    public void saveOffice(@RequestBody OfficeDTO officeDto) {
        officeService.saveOffice(officeDto);
    }
}
