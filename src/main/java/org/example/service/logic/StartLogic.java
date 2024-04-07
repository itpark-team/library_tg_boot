package org.example.service.logic;

import org.example.db.Author;
import org.example.db.AuthorsRepository;
import org.example.statemachine.State;
import org.example.statemachine.TransmittedData;
import org.example.util.buttons.InlineButtonsStorage;
import org.example.util.buttons.InlineKeyboardsStorage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;

public class StartLogic {

    private AuthorsRepository authorsRepository;

    public StartLogic() {
        authorsRepository = new AuthorsRepository();
    }

    public SendMessage processWaitingCommandStart(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.equals("/start") == false) {
            messageToUser.setText("Ошибка запуска бота. Для старта пожалуйста введите /start");
            return messageToUser;
        }

        messageToUser.setText("Выберите действие");
        messageToUser.setReplyMarkup(InlineKeyboardsStorage.getShowOrAddAuthorsKeyboard());

        transmittedData.setState(State.WaitingShowOrAddAuthors);

        return messageToUser;
    }

    public SendMessage processWaitingShowOrAddAuthors(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.equals(InlineButtonsStorage.ShowAuthors.getCallBackData()) == false && textFromUser.equals(InlineButtonsStorage.AddNewAuthor.getCallBackData()) == false) {
            messageToUser.setText("Ошибка. Нажмите на кнопку.");
            return messageToUser;
        }

        if (textFromUser.equals(InlineButtonsStorage.ShowAuthors.getCallBackData()) == true) {
            ArrayList<Author> authors = authorsRepository.getAllAuthors();

            int countAuthors = authors.size();
            int currentAuthorNumber = 1;

            transmittedData.getDataStorage().addOrUpdate("authors", authors);

            transmittedData.getDataStorage().addOrUpdate("countAuthors", countAuthors);

            transmittedData.getDataStorage().addOrUpdate("currentAuthorNumber", currentAuthorNumber);

            if (countAuthors == 0) {
                messageToUser.setText("В системе нет ни одного автора");

                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getNothingAuthorsKeyboard());

            } else {
                Author currentAuthor = authors.get(currentAuthorNumber - 1);

                messageToUser.setText(String.format("Автор %d из %d\nИмя: %s\nСтрана: %s", currentAuthorNumber, countAuthors, currentAuthor.getName(), currentAuthor.getCountry()));

                if (countAuthors > 1) {
                    messageToUser.setReplyMarkup(InlineKeyboardsStorage.getAuthorFirstShowKeyboard());
                } else if (countAuthors == 1) {
                    messageToUser.setReplyMarkup(InlineKeyboardsStorage.getCloseAuthorsKeyboard());
                }
            }

            transmittedData.setState(State.WaitingAuthorFirstShow);

        } else if (textFromUser.equals(InlineButtonsStorage.AddNewAuthor.getCallBackData()) == true) {
            messageToUser.setText("Начало добавления автора. Пожалуйста введите имя автора от 1 до 30 символов");

            transmittedData.setState(State.WaitingInputAuthorName);
        }

        return messageToUser;
    }


}
