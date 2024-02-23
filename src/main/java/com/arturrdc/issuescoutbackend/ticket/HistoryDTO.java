package com.arturrdc.issuescoutbackend.ticket;

public class HistoryDTO {
    private String updatedAt;
    private String propertyChanged;
    private String oldValue;
    private String newValue;

    public HistoryDTO(String updatedAt, String propertyChanged, String oldValue, String newValue) {
        this.updatedAt = updatedAt;
        this.propertyChanged = propertyChanged;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPropertyChanged() {
        return propertyChanged;
    }

    public void setPropertyChanged(String propertyChanged) {
        this.propertyChanged = propertyChanged;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
}
