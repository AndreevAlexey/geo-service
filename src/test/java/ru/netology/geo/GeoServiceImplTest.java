package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

class GeoServiceImplTest {
    private GeoServiceImpl geoService;

    @BeforeEach
    public void init() {
        geoService = new GeoServiceImpl();
    }
    @Test
    void byIp_test_Moscow_local() {
        // given
        String ip = "172.11.12.13";
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);
        // when
        Location result  = geoService.byIp(ip);
        // then
        Assertions.assertEquals(expected, result);
    }
}