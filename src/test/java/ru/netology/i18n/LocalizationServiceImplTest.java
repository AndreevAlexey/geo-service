package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {
    private LocalizationServiceImpl localizationService;

    @BeforeEach
    public void init() {
        localizationService = new LocalizationServiceImpl();
    }

    @Test
    void locale_test_foreign() {
        // given
        String expected = "Welcome";
        // when
        String result = localizationService.locale(Country.BRAZIL);
        // then
        Assertions.assertEquals(expected, result);
    }
}