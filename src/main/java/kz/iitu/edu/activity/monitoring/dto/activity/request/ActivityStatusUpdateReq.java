package kz.iitu.edu.activity.monitoring.dto.activity.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ActivityStatusUpdateReq {
    private String status;
}
