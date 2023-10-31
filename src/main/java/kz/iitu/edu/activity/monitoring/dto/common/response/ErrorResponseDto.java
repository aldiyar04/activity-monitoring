package kz.iitu.edu.activity.monitoring.dto.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class ErrorResponseDto {
    Integer status;
    String message;
}
