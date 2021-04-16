package ru.bellintegrator.service.office;

import ru.bellintegrator.dto.OfficeDTO;
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
