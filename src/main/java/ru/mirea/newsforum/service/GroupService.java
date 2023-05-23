package ru.mirea.newsforum.service;


import ru.mirea.newsforum.dto.GroupDTO;
import ru.mirea.newsforum.entity.GroupEntity;

public interface GroupService {
    GroupEntity save(GroupEntity group);
    int parseCourse(String group);
}
