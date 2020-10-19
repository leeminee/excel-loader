package com.wendy.excelloader.model;

public class CallLog {

    private String date;
    private int totalTryCount;
    private int successCount;
    private int failCount;
    private int successRate;
    private int failRate;

    public CallLog(String date, int totalTryCount, int successCount, int failCount, int successRate, int failRate) {
        this.date = date;
        this.totalTryCount = totalTryCount;
        this.successCount = successCount;
        this.failCount = failCount;
        this.successRate = successRate;
        this.failRate = failRate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalTryCount() {
        return totalTryCount;
    }

    public void setTotalTryCount(int totalTryCount) {
        this.totalTryCount = totalTryCount;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getFailCount() {
        return failCount;
    }

    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    public int getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(int successRate) {
        this.successRate = successRate;
    }

    public int getFailRate() {
        return failRate;
    }

    public void setFailRate(int failRate) {
        this.failRate = failRate;
    }
}
