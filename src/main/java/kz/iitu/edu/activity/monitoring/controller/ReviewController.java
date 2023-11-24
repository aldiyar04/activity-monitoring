package kz.iitu.edu.activity.monitoring.controller;

import kz.iitu.edu.activity.monitoring.dto.review.response.ReviewDto;
import kz.iitu.edu.activity.monitoring.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/chiefEditor/{chiefEditorId}")
    @PreAuthorize(value = "hasAnyRole('TRANSLATOR', 'CHIEF_EDITOR','PROJECT_MANAGER')")
    public List<ReviewDto> getReviewsByChiefEditorId(@PathVariable String chiefEditorId, Pageable pageable) {
        return reviewService.getReviewsByChiefEditorId(chiefEditorId, pageable);
    }

    @GetMapping("/activity/{activityId}")
    @PreAuthorize(value = "hasAnyRole('TRANSLATOR', 'CHIEF_EDITOR','PROJECT_MANAGER')")
    public List<ReviewDto> getReviewsByActivityId(@PathVariable Long activityId, Pageable pageable) {
        return reviewService.getReviewsByActivityId(activityId, pageable);
    }
}