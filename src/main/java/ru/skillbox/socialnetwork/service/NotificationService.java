package ru.skillbox.socialnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.skillbox.socialnetwork.api.response.NotificationListApi;
import ru.skillbox.socialnetwork.api.response.ResponseApi;
import ru.skillbox.socialnetwork.dao.NotificationDAO;
import ru.skillbox.socialnetwork.dao.PersonDAO;
import ru.skillbox.socialnetwork.mapper.NotificationMapper;
import ru.skillbox.socialnetwork.model.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private NotificationListApi notificationListApi;

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private NotificationDAO notificationDAO;

    @Autowired
    private NotificationMapper notificationMapper;

    public ResponseApi getAllNotification(int offset, int itemPerPage) {
        List<Notification> notifications = notificationDAO.getNotificationByPersonId(getCurrentPersonId());
        ResponseApi responseApi = new ResponseApi();
        notificationListApi = new NotificationListApi();
        notificationListApi.setData(notifications.stream().map(notificationMapper::toApi)
                .collect(Collectors.toList()));
        notificationListApi.setTotal(notifications.size());
        notificationListApi.setOffset(offset);
        notificationListApi.setPerPage(itemPerPage);
        notificationListApi.setSuccess(true);
        return notificationListApi;
    }

    public ResponseApi readNotification(int id, boolean all) {
        List<Notification> notifications;
        if (all) {
            notifications = notificationDAO.getNotificationByPersonId(getCurrentPersonId());
        } else {
            notifications = new ArrayList<>();
            notifications.add(notificationDAO.getNotificationById(id));
        }

        notifications.forEach(n -> n.setReaded(true));
        notifications.forEach(n -> notificationDAO.updateNotification(n));

        ResponseApi responseApi = new ResponseApi();
        notificationListApi = new NotificationListApi();
        notificationListApi.setData(notifications.stream().map(notificationMapper::toApi)
                .collect(Collectors.toList()));
        notificationListApi.setTotal(notifications.size());
        notificationListApi.setSuccess(true);
        return notificationListApi;
    }

    private int getCurrentPersonId() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return personDAO.getPersonByEmail(email).getId();
    }
}
