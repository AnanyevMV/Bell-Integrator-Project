package ru.bellintegrator.controller.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.dto.OfficeDTO;
import ru.bellintegrator.service.office.OfficeService;

import java.util.List;

/**
 * REST-контроллер, отвечающий за REST-запросы, связанные с офисами.
 */
@RestController
@RequestMapping("/api")
public class OfficeRestController {

    /**
     * У контроллера имеется зависимость officeService - сервис, предоставляющий методы для<br>
     * получения, сохранения и обновления офисов.
     */
    private final OfficeService officeService;

    /**
     * Конструктор класса OfficeRestController. Используется внедрение зависимости OfficeService<br>
     * через конструктор
     *
     * @param officeService - сервис для получения, сохранения, обновления офисов
     */
    @Autowired
    public OfficeRestController(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * Метод обрабатывает GET-запрос для получения списка всех офисов.
     *
     * @return список OfficeDTO
     */
    @GetMapping("/office/list")
    public List<OfficeDTO> getOffices() {
        return officeService.getOffices();
    }

    /**
     * Метод обрабатывает GET-запрос для получения офиса по его идентификатору
     *
     * @param id идентификатор офиса
     * @return OfficeDTO
     */
    @GetMapping("/office/{id}")
    public OfficeDTO getOffice(@PathVariable("id") Long id) {
        return officeService.getOffice(id);
    }

    /**
     * Метод обрабатывает PUT-запрос для обновленния офиса
     *
     * @param officeDTO DTO-объект, полученный из тела HTTP-запроса
     */
    @PutMapping("/office/update")
    public void updateOffice(@RequestBody OfficeDTO officeDTO) {
        officeService.updateOffice(officeDTO);
    }

    /**
     * Метод обрабатывает POST-запрос для сохранения офиса
     *
     * @param officeDto DTO-объект, полученный из тела HTTP-запроса
     */
    @PostMapping("/office/save")
    public void saveOffice(@RequestBody OfficeDTO officeDto) {
        officeService.saveOffice(officeDto);
    }
}
