package es.santander.justicia.minisJusticia.dto;

public class TimeLineDetailDTO {
    private String date;
    private int order;
    private String status;
    private String statusName;
    private String userName;

    public TimeLineDetailDTO() {
    }

    public TimeLineDetailDTO(String statusName2, String status2, String date2, String userName2, int order2) {
        this.statusName = statusName2;
        this.status = status2;
        this.date = date2;
        this.userName = userName2;
        this.order = order2;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public void setStatusName(String statusName2) {
        this.statusName = statusName2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date2) {
        this.date = date2;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName2) {
        this.userName = userName2;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order2) {
        this.order = order2;
    }
}
