package com.voltx.station.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ConnectorTest {

    @Test
    void shouldCreateConnectorWithValidData(){
        Connector connector = new Connector(1L,ConnectorType.CCS);

        assertEquals(1L,connector.getId());
        assertEquals(ConnectorType.CCS,connector.getType());
    }

    @Test
    void shouldRejectNullId(){
        assertThrows(IllegalArgumentException.class,()->new Connector(null,ConnectorType.CCS));
    }

    @Test
    void shouldRejectNullType(){
        assertThrows(IllegalArgumentException.class,()->new Connector(1l,null));
    }

    @Test
    void shouldMarkConnectorAsOccupied() {
        Connector connector = new Connector(1L, ConnectorType.CCS);

        connector.markAsOccupied();

        assertEquals(ConnectorStatus.OCCUPIED, connector.getStatus());
    }

    @Test
    void shouldRejectMarkingAlreadyOccupiedConnectorAsOccupied() {
        Connector connector = new Connector(1L, ConnectorType.CCS);

        connector.markAsOccupied();

        assertThrows(
                IllegalStateException.class,
                connector::markAsOccupied
        );
    }

}
