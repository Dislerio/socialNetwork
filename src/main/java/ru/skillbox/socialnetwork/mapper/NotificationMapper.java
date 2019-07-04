package ru.skillbox.socialnetwork.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.skillbox.socialnetwork.api.response.MessageApi;
import ru.skillbox.socialnetwork.api.response.NotificationApi;
import ru.skillbox.socialnetwork.dao.NotificationDAO;
import ru.skillbox.socialnetwork.dao.PersonDAO;
import ru.skillbox.socialnetwork.model.Message;
import ru.skillbox.socialnetwork.model.Notification;

import javax.annotation.PostConstruct;

@Component
public class NotificationMapper extends Mapper<Notification, NotificationApi> {

    private final ModelMapper modelMapper;

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private NotificationDAO notificationDAO;

    @Autowired
    public NotificationMapper(ModelMapper modelMapper) {
        super(Notification.class, NotificationApi.class);
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void setupMapper() {
        modelMapper.createTypeMap(Notification.class, NotificationApi.class)
                .addMappings(m -> m.skip(NotificationApi::setType_id))
                .addMappings(m -> m.skip(NotificationApi::setPerson_id))
                .setPostConverter(toApiConverter());
        modelMapper.createTypeMap(NotificationApi.class, Notification.class)
                .addMappings(m -> m.skip(Notification::setNotificationType))
                .addMappings(m -> m.skip(Notification::setPerson))
                .setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFieldsEA(Notification source, NotificationApi destination) {
        destination.setType_id(source.getNotificationType().getId());
        destination.setPerson_id(source.getPerson().getId());
    }

    @Override
    void mapSpecificFieldsAE(NotificationApi source, Notification destination) {
        destination.setNotificationType(notificationDAO.getNotificationTypeById(source.getType_id()));
        destination.setPerson(personDAO.getPersonById(source.getPerson_id()));
    }
}
