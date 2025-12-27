public ComplianceLog(
        SensorReading sensorReading,
        ComplianceThreshold threshold,
        String status,
        String remarks,
        LocalDateTime evaluatedAt
) {
    this.sensorReading = sensorReading;
    this.threshold = threshold;
    this.status = status;
    this.remarks = remarks;
    this.evaluatedAt = evaluatedAt;
}
