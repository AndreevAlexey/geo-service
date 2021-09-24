package ru.netology.sender;

import org.junit.jupiter.api.*;
import ru.netology.geo.*;
import ru.netology.i18n.*;
import java.util.*;
import static org.mockito.Mockito.*;

class MessageSenderMock {
    private LocalizationService localService;
    private GeoService geoService;
    private MessageSender messageSender;
    @BeforeEach
    public void init() {
        localService = spy(LocalizationServiceImpl.class);
        geoService = spy(GeoServiceImpl.class);
        messageSender = new MessageSenderImpl(geoService, localService);
    }
    @Test
    void send_RU_ONLY() {
        // given
        String ipRUS = GeoServiceImpl.MOSCOW_IP;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ipRUS);
        // when
        String result = messageSender.send(headers);
        // then
        Assertions.assertEquals("Добро пожаловать", result);
    }
    @Test
    void send_ENG_ONLY() {
        // given
        String ipUSA = GeoServiceImpl.NEW_YORK_IP;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ipUSA);
        // when
        String result = messageSender.send(headers);
        // then
        Assertions.assertEquals("Welcome", result);
    }

}