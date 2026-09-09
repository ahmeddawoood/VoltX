package com.voltx.station.domain;

import java.util.ArrayList;
import java.util.List;

public class ChargingPoint {

    private final Long id;
    private final List<Connector> connectors;


    public ChargingPoint(Long id){
        if(id == null){
            throw  new IllegalArgumentException("ChargingPoint id can not be null");
        }
        this.id = id;

        this.connectors = new ArrayList<>();
    }

    public void addConnector(Connector connector) {
        if (connector == null) {
            throw new IllegalArgumentException("Connector cannot be null");
        }

        boolean alreadyExists = connectors.stream()
                .anyMatch(existing -> existing.getId().equals(connector.getId()));

        if (alreadyExists) {
            throw new IllegalArgumentException(
                    "Connector with id " + connector.getId() + " already exists"
            );
        }

        connectors.add(connector);
    }

    public List<Connector> getConnectors() {
        return List.copyOf(connectors);
    }

    public Long getId() {
        return id;
    }
}
