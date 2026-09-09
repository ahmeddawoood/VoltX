package com.voltx.station.domain;

public class Connector {

    private final Long id;
    private final ConnectorType type;
    private ConnectorStatus status;


    public Connector(Long id, ConnectorType type){

        if(id == null){
            throw new IllegalArgumentException("Connector id can not be null");
        }

        if(type == null){
            throw new IllegalArgumentException("connector type can not be null");
        }

        this.id = id;
        this.type = type;
        this.status = ConnectorStatus.AVAILABLE;
    }

    public Long getId() {
        return id;
    }

    public ConnectorType getType() {
        return type;
    }

    public ConnectorStatus getStatus() {
        return status;
    }

    public void markAsOccupied() {
        if (this.status != ConnectorStatus.AVAILABLE) {
            throw new IllegalStateException(
                    "Connector must be AVAILABLE to become OCCUPIED"
            );
        }

        this.status = ConnectorStatus.OCCUPIED;
    }
}
