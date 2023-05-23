package ru.mirea.newsforum.dto;

import lombok.Data;
import ru.mirea.newsforum.entity.GroupEntity;

import java.io.File;
import java.util.List;

@Data
public class PostDTO {
    private String text;
    private List<GroupEntity> groups;
    private File photo;
}
