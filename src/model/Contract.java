package model;

import exception.InvalidNumberException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class Contract implements Serializable {

    private String id;
    private LocalDate startAt;
    private LocalDate endAt;
    private String status;
    private double deposit;

    public Contract() {
    }

    public Contract(String id, LocalDate startAt, LocalDate endAt, double deposit) {
        this.id = id;
        this.startAt = startAt;
        this.endAt = endAt;
        this.deposit = deposit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDate startAt) {
        this.startAt = startAt;
    }

    public LocalDate getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDate endAt) {
        this.endAt = endAt;
    }

    public String getStatus() {
        updateStatus();
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) throws InvalidNumberException {
        if (deposit <= 0) {
            throw new InvalidNumberException("Giá thuê phòng phải lớn hơn 0.");
        }
        this.deposit = deposit;
    }

    public final void updateStatus() {
        LocalDate today = LocalDate.now();
        long daysRemaining = ChronoUnit.DAYS.between(today, endAt);
        if (daysRemaining <= 0) {
            status = "Đã hết hạn";
        } else {
            status = "Còn " + daysRemaining + " ngày";
        }
    }

    @Override
    public String toString() {
        return "Contract{" + "id=" + id + ", startAt=" + startAt + ", endAt=" + endAt + ", deposit=" + status + '}';
    }
}
