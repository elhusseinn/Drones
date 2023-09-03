package com.Egabi.drones.exceptions;

public class DroneNotAvailableException extends RuntimeException{
    public DroneNotAvailableException(Long id){
        super("Drone with Id: "+id+" is not available at the moment!");
    }
    public DroneNotAvailableException(Long id, int batteryLevel){
        super("Drone with Id: "+id+" is low on battery and cannot be loaded \n" +
                " Battery level: "+ batteryLevel);
    }
    public DroneNotAvailableException(Double weightLimit, Double weight){
        super("Drone weight limit is: "+weightLimit+" there is: "+(weight-weightLimit)+" overweight");
    }
}
