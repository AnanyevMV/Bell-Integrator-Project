package ru.bellintegrator.service.office;

import ru.bellintegrator.dto.OfficeDTO;
import ru.bellintegrator.dto.OrganizationDTO;

import java.util.List;

/**
 * Интерфейс сервиса для CRUD-операций, связанных с офисами
 */
public interface OfficeService {

    /**
     * Метод позволяет получить список офисов
     *
     * @return список OfficeDTO
     */
    public List<OfficeDTO> getOffices();

    /**
     * Метод позволяет получить список офисов согласно фильтру
     *
     * @param filter фильтр
     * @return список OfficeDTO
     */
    public List<OfficeDTO> getOffices(OfficeDTO filter);

    /**
     * Метод позволяет получить информацию об офисе по его идентификатору
     *
     * @param id идентификатор
     * @return объект OfficeDTO
     */
    public OfficeDTO getOffice(Long id);

    /**
     * Метод позволяет обновить информацию об офисе
     *
     * @param officeDTO объект OfficeDTO
     */
    public void updateOffice(OfficeDTO officeDTO);

    /**
     * Метод позволяет сохранить офис
     *
     * @param officeDTO объект OfficeDTO
     */
    public void saveOffice(OfficeDTO officeDTO);

}
