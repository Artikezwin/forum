package ru.mirea.newsforum.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.newsforum.dto.GroupDTO;
import ru.mirea.newsforum.entity.GroupEntity;
import ru.mirea.newsforum.service.GroupService;

import java.time.LocalDate;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
@Slf4j
public class GroupController {
    private final GroupService groupService;

    @PostMapping("/save")
    public ResponseEntity<GroupEntity> save(@RequestBody GroupDTO groupDTO) {
        int year = LocalDate.now().getYear();
        int course = year - Integer.parseInt(
                Integer.toString(year).substring(0, 2)
                        + groupDTO.getGroup().substring(groupDTO.getGroup().length() - 2)
        );
        log.info("Course: " + course);

        GroupEntity group = new GroupEntity();
        group.setGroup(groupDTO.getGroup());
        group.setCourse(course);

        return ResponseEntity.ok(groupService.save(group));
    }
}
