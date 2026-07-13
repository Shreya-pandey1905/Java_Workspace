package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ride {

    private long id;


    private long customerId;
    private long driverId;
    private String pickupLocation;
    private String dropLocation;
    private BigDecimal fare;
    private RideStatus status;
    private LocalDateTime requestedAt;
    private LocalDateTime updatedAt;

    public Ride(long id, long customerId, long driverId, String pickupLocation, String dropLocation, BigDecimal fare, RideStatus status, LocalDateTime requestedAt, LocalDateTime updatedAt) {
        this.id = id;
        this.customerId = customerId;
        this.driverId = driverId;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.fare = fare;
        this.status = status;
        this.requestedAt = requestedAt;
        this.updatedAt = updatedAt;
    }
        public long getCustomerId() {
            return customerId;
        }

        public long getId() {
            return id;
        }

        public long getDriverId() {
            return driverId;
        }

        public String getPickupLocation() {
            return pickupLocation;
        }

        public String getDropLocation() {
            return dropLocation;
        }

        public BigDecimal getFare() {
            return fare;
        }

        public RideStatus getStatus() {
            return status;
        }

        public LocalDateTime getRequestedAt() {
            return requestedAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }



}
