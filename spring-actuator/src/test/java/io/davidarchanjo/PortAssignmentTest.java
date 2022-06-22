package io.davidarchanjo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.autoconfigure.web.server.LocalManagementPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PortAssignmentTest {

    @LocalServerPort
    private Integer localServerPort;
 
    @LocalManagementPort
    private Integer localManagementPort;

    @Test
    void testGetForObject() {
        assertNotNull(localServerPort);
        assertNotNull(localManagementPort);
    }

}