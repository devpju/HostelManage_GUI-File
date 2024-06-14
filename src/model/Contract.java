package model;

import exception.InvalidNumberException;
import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

public class Contract implements Serializable {

    private String id;
    private Date startAt;
    private Date endAt;
    private String status;
    private double deposit;

    public Contract() {
    }

    public Contract(String id, Date startAt, Date endAt, double deposit) {
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

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public String getStatus() {
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
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startAt);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endAt);

        long milliseconds = endCalendar.getTimeInMillis() - startCalendar.getTimeInMillis();
        long daysRemaining = milliseconds / (1000 * 60 * 60 * 24);

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
