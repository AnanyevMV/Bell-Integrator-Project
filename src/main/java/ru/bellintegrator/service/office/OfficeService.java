package ru.bellintegrator.service.office;

import ru.bellintegrator.dto.OfficeDTO;
import java.util.List;

public interface OfficeService {

    public List<OfficeDTO> getOffices();

    public OfficeDTO getOffice(Long id);

    public void updateOffice(OfficeDTO officeDTO);

    public void saveOffice(OfficeDTO officeDTO);
}
