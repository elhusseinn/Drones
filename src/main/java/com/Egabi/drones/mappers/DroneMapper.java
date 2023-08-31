package com.Egabi.drones.mappers;

import com.Egabi.drones.models.Drone;
import com.Egabi.drones.pojos.DronePOJO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DroneMapper {

    DroneMapper DRONE_MAPPER = Mappers.getMapper(DroneMapper.class);
    DronePOJO toDronePOJO(Drone drone);
    Drone toDrone(DronePOJO dronePOJO);
}
