package kz.iitu.edu.activity.monitoring.dto.activity.response;

import kz.iitu.edu.activity.monitoring.dto.common.response.UserDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ActivityDto {
    private final Long id;
    private final Long projectId;
    private final String projectName;
    private final String title;
    private final String language;
    private final String targetLanguage;
    private final UserDto translator;
    private final String status;
    private final String targetTitle;
    private final String createdAt;
    private final String updatedAt;
}