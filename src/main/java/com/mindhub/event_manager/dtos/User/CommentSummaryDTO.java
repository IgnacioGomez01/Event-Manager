package com.mindhub.event_manager.dtos.User;

import com.mindhub.event_manager.models.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class CommentSummaryDTO {

    private UUID id;
    private String comment;

    public CommentSummaryDTO(Comment comment){
        this.id=comment.getId();
        this.comment = comment.getComment();
    }
}
