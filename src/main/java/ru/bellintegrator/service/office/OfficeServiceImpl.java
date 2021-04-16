package ru.bellintegrator.service.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.dao.office.OfficeDAO;
import ru.bellintegrator.dto.OfficeDTO;
import ru.bellintegrator.dto.mapper.Mapper;
import ru.bellintegrator.dto.mapper.OfficeMapper;
import ru.bellintegrator.entity.Office;

import java.util.List;

/**
 * Реализация интерфейса OfficeService<br>
 * Сервис для CRUD-операций, связанных с офисами
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDAO officeDAO;

    private final OfficeMapper officeMapper;

    /**
     * Конструктор класса OfficeServiceImpl
     *
     * @param officeDAO DAO объект для офисов
     * @param officeMapper объект для маппинга между Office и OfficeDTO
     */
    @Autowired
    public OfficeServiceImpl(OfficeDAO officeDAO, OfficeMapper officeMapper) {
        this.officeDAO = officeDAO;
        this.officeMapper = officeMapper;
    }

    /**
     * Метод позволяет получить список офисов
     *
     * @return список OfficeDTO
     */
    @Override
    public List<OfficeDTO> getOffices() {
        return null;
    }

    /**
     * Метод позволяет получить информацию об офисе по его идентификатору
     *
     * @param id идентификатор
     * @return объект OfficeDTO
     */
    @Override
    @Transactional
    public OfficeDTO getOffice(Long id) {
        Office office = officeDAO.getOffice(id);
        return officeMapper.toDTO(office);
    }

    /**
     * Метод позволяет обновить информацию об офисе
     *
     * @param officeDTO объект OfficeDTO
     */
    @Override
    @Transactional
    public void updateOffice(OfficeDTO officeDTO) {
        // ModelMapper использует прокси и таким образом перехватывает exception и нужное сообщение и возвращает свой
        // exception. Поэтому вручную вызываем метод проверки
        Mapper.throwExceptionIfNotTrueOrFalse(officeDTO.getIsActive());
        Office office = officeMapper.toEntity(officeDTO);
        officeDAO.updateOffice(office, officeDTO.getOrgId());
    }

    /**
     * Метод позволяет сохранить офис
     *
     * @param officeDTO объект OfficeDTO
     */
    @Override
    @Transactional
    public void saveOffice(OfficeDTO officeDTO) {
        // ModelMapper использует прокси и таким образом перехватывает exception и нужное сообщение и возвращает свой
        // exception. Поэтому вручную вызываем метод проверки
        Mapper.throwExceptionIfNotTrueOrFalse(officeDTO.getIsActive());
        officeDTO.setId(null);
        Office office = officeMapper.toEntity(officeDTO);
        officeDAO.saveOffice(office, officeDTO.getOrgId());
    }
}
