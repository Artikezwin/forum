package ru.mirea.newsforum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.newsforum.entity.GroupEntity;
import ru.mirea.newsforum.repository.GroupRepository;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public GroupEntity save(GroupEntity group) {
        return groupRepository.save(group);
    }
}
