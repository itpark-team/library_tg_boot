package org.example.service.logic;

import org.example.db.Author;
import org.example.db.AuthorsRepository;
import org.example.statemachine.State;
import org.example.statemachine.TransmittedData;
import org.example.util.NumberUtil;
import org.example.util.buttons.InlineButtonsStorage;
import org.example.util.buttons.InlineKeyboardsStorage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class AddNewAuthorLogic {
    private AuthorsRepository authorsRepository;

    public AddNewAuthorLogic() {
        authorsRepository = new AuthorsRepository();
    }

    public SendMessage processWaitingInputAuthorName(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.length() > 30) {
            messageToUser.setText("Ошибка ввода имя автора. Длина имени должна быть от 1 до 30 символов. Повторите ввод названия имени");
            return messageToUser;
        }

        transmittedData.getDataStorage().addOrUpdate("authorName", textFromUser);

        messageToUser.setText("Имя автора успешно записано. Теперь введите страну автора");
        transmittedData.setState(State.WaitingInputAuthorCountry);

        return messageToUser;
    }

    public SendMessage processWaitingInputAuthorCountry(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.length() > 30) {
            messageToUser.setText("Ошибка ввода страны автора. Длина старны должна быть от 1 до 30 символов. Повторите ввод названия страны автора");
            return messageToUser;
        }

        transmittedData.getDataStorage().addOrUpdate("authorCountry", textFromUser);

        String authorName = (String) transmittedData.getDataStorage().get("authorName");
        String authorCountry = (String) transmittedData.getDataStorage().get("authorCountry");

        messageToUser.setText(String.format("Страна автора успешно записана. Теперь проверьте корретность введённых данных и нажмите кнопку подтверждения или отмены.\nИмя автора: %s\nСтрана автора: %s", authorName, authorCountry));

        messageToUser.setReplyMarkup(InlineKeyboardsStorage.getApproveAuthorDataKeyboard());

        transmittedData.setState(State.WaitingApproveAuthorData);

        return messageToUser;
    }

    public SendMessage processWaitingApproveAuthorData(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.equals(InlineButtonsStorage.ApproveAddAuthor.getCallBackData()) == false && textFromUser.equals(InlineButtonsStorage.DisapproveAddAuthor.getCallBackData()) == false) {
            messageToUser.setText("Ошибка. Нажмите на кнопку.");
            return messageToUser;
        }

        if (textFromUser.equals(InlineButtonsStorage.ApproveAddAuthor.getCallBackData()) == true) {
            String authorName = (String) transmittedData.getDataStorage().get("authorName");
            String authorCountry = (String) transmittedData.getDataStorage().get("authorCountry");

            Author author = new Author(0, authorName, authorCountry);

            authorsRepository.addNewAuthor(author);

            transmittedData.getDataStorage().clear();

            messageToUser.setText("Данные об авторе успещно сохранены. Вернитесь в начало путём нажатия на /start");
        } else if (textFromUser.equals(InlineButtonsStorage.DisapproveAddAuthor.getCallBackData()) == true) {
            transmittedData.getDataStorage().clear();

            messageToUser.setText("Добавление успешно отменено. Вернитесь в начало путём нажатия на /start");
        }

        transmittedData.setState(State.WaitingStart);

        return messageToUser;
    }
}