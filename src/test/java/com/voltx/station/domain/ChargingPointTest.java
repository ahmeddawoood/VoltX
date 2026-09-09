package com.voltx.station.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChargingPointTest {
    @Test
    void shouldAddConnector() {
        ChargingPoint chargingPoint = new ChargingPoint(1L);
        Connector connector = new Connector(1L, ConnectorType.CCS);

        chargingPoint.addConnector(connector);

        assertEquals(1, chargingPoint.getConnectors().size());
        assertEquals(connector, chargingPoint.getConnectors().getFirst());
    }

    @Test
    void shouldAddMultipleConnectors() {
        ChargingPoint chargingPoint = new ChargingPoint(1L);

        Connector connector1 = new Connector(1L, ConnectorType.CCS);
        Connector connector2 = new Connector(2L, ConnectorType.TYPE_2);

        chargingPoint.addConnector(connector1);
        chargingPoint.addConnector(connector2);

        assertEquals(2, chargingPoint.getConnectors().size());
    }

    @Test
    void shouldRejectNullConnector() {
        ChargingPoint chargingPoint = new ChargingPoint(1L);

        assertThrows(
                IllegalArgumentException.class,
                () -> chargingPoint.addConnector(null)
        );
    }

    @Test
    void shouldRejectNullId() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ChargingPoint(null)
        );
    }

    @Test
    void shouldNotExposeInternalConnectorList() {
        ChargingPoint chargingPoint = new ChargingPoint(1L);
        Connector connector = new Connector(1L, ConnectorType.CCS);

        chargingPoint.addConnector(connector);

        var connectors = chargingPoint.getConnectors();

        assertThrows(
                UnsupportedOperationException.class,
                connectors::clear
        );

        assertEquals(1, chargingPoint.getConnectors().size());
    }

    @Test
    void shouldRejectDuplicateConnectorId() {
        ChargingPoint chargingPoint = new ChargingPoint(1L);

        Connector connector1 = new Connector(1L, ConnectorType.CCS);
        Connector connector2 = new Connector(1L, ConnectorType.TYPE_2);

        chargingPoint.addConnector(connector1);

        assertThrows(
                IllegalArgumentException.class,
                () -> chargingPoint.addConnector(connector2)
        );
    }
}
