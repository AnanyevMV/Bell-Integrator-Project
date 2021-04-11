/**
 * Пакет содержит классы Data Transfer Object'ов (DTO), а именно:<br>
 * CountryDTO - для стран<br>
 * DocumentTypeDTO - для типов документов<br>
 * OfficeDTO - для офисов<br>
 * OrganizationDTO - для организаций<br>
 * UserDTO - для пользователей<br><br>
 *
 * SuccessDTO - DTO для возврата, если REST-запрос save/update отработал успешно<br>
 * ErrorDTO - DTO для возврата сообщения об ошибке<br>
 * DataDTO - DTO для обёртки ответа в data { *Ответ* }<br><br>
 *
 * Пакет так же содержит в себе подпакет mapper, который отвечает за маппинг между entity и dto<br>
 * Для маппинга используется библиотека org.modelmapper
 */
package ru.bellintegrator.dto;