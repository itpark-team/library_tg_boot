package org.example.service.logic;

import org.example.db.Author;
import org.example.db.AuthorsRepository;
import org.example.db.BooksRepository;
import org.example.statemachine.State;
import org.example.statemachine.TransmittedData;
import org.example.util.buttons.InlineButtonsStorage;
import org.example.util.buttons.InlineKeyboardsStorage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;


public class ShowAuthorsLogic {
    private AuthorsRepository authorsRepository;
    private BooksRepository booksRepository;

    public ShowAuthorsLogic() {
        authorsRepository = new AuthorsRepository();
        booksRepository = new BooksRepository();
    }

    public SendMessage processWaitingAuthorFirstShow(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.equals(InlineButtonsStorage.ShowNextAuthor.getCallBackData()) == false && textFromUser.equals(InlineButtonsStorage.FinishShowAuthor.getCallBackData()) == false) {
            messageToUser.setText("Ошибка. Нажмите на кнопку.");
            return messageToUser;
        }

        if (textFromUser.equals(InlineButtonsStorage.ShowNextAuthor.getCallBackData()) == true) {

            ArrayList<Author> authors = (ArrayList<Author>) transmittedData.getDataStorage().get("authors");

            int countAuthors = (int) transmittedData.getDataStorage().get("countAuthors");

            int currentAuthorNumber = (int) transmittedData.getDataStorage().get("currentAuthorNumber");

            currentAuthorNumber++;

            transmittedData.getDataStorage().addOrUpdate("currentAuthorNumber", currentAuthorNumber);

            Author currentAuthor = authors.get(currentAuthorNumber - 1);

            messageToUser.setText(String.format("Автор %d из %d\nИмя: %s\nСтрана: %s", currentAuthorNumber, countAuthors, currentAuthor.getName(), currentAuthor.getCountry()));

            if (currentAuthorNumber == countAuthors) {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getAuthorLastShowKeyboard());

                transmittedData.setState(State.WaitingAuthorLastShow);
            } else {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getAuthorMiddleShowKeyboard());

                transmittedData.setState(State.WaitingAuthorMiddleShow);
            }

        } else if (textFromUser.equals(InlineButtonsStorage.FinishShowAuthor.getCallBackData()) == true) {
            transmittedData.getDataStorage().clear();

            messageToUser.setText("Просмотр закончен. Вернитесь в начало путём нажатия на /start");

            transmittedData.setState(State.WaitingStart);
        }


        return messageToUser;
    }

    public SendMessage processWaitingAuthorMiddleShow(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.equals(InlineButtonsStorage.ShowNextAuthor.getCallBackData()) == false && textFromUser.equals(InlineButtonsStorage.FinishShowAuthor.getCallBackData()) == false && textFromUser.equals(InlineButtonsStorage.ShowPrevAuthor.getCallBackData()) == false) {
            messageToUser.setText("Ошибка. Нажмите на кнопку.");
            return messageToUser;
        }

        if (textFromUser.equals(InlineButtonsStorage.ShowNextAuthor.getCallBackData()) == true) {

            ArrayList<Author> authors = (ArrayList<Author>) transmittedData.getDataStorage().get("authors");

            int countAuthors = (int) transmittedData.getDataStorage().get("countAuthors");

            int currentAuthorNumber = (int) transmittedData.getDataStorage().get("currentAuthorNumber");

            currentAuthorNumber++;

            transmittedData.getDataStorage().addOrUpdate("currentAuthorNumber", currentAuthorNumber);

            Author currentAuthor = authors.get(currentAuthorNumber - 1);

            messageToUser.setText(String.format("Автор %d из %d\nИмя: %s\nСтрана: %s", currentAuthorNumber, countAuthors, currentAuthor.getName(), currentAuthor.getCountry()));

            if (currentAuthorNumber == countAuthors) {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getAuthorLastShowKeyboard());

                transmittedData.setState(State.WaitingAuthorLastShow);
            } else {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getAuthorMiddleShowKeyboard());

                transmittedData.setState(State.WaitingAuthorMiddleShow);
            }

        }
        if (textFromUser.equals(InlineButtonsStorage.ShowPrevBook.getCallBackData()) == true) {
            ArrayList<Author> authors = (ArrayList<Author>) transmittedData.getDataStorage().get("authors");

            int countAuthors = (int) transmittedData.getDataStorage().get("countAuthors");

            int currentAuthorNumber = (int) transmittedData.getDataStorage().get("currentAuthorNumber");

            currentAuthorNumber--;

            transmittedData.getDataStorage().addOrUpdate("currentAuthorNumber", currentAuthorNumber);

            Author currentAuthor = authors.get(currentAuthorNumber - 1);

            messageToUser.setText(String.format("Автор %d из %d\nИмя: %s\nСтрана: %s", currentAuthorNumber, countAuthors, currentAuthor.getName(), currentAuthor.getCountry()));

            if (currentAuthorNumber == 1) {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getAuthorLastShowKeyboard());

                transmittedData.setState(State.WaitingAuthorFirstShow);
            } else {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getAuthorMiddleShowKeyboard());

                transmittedData.setState(State.WaitingAuthorMiddleShow);
            }
        } else if (textFromUser.equals(InlineButtonsStorage.FinishShowAuthor.getCallBackData()) == true) {
            transmittedData.getDataStorage().clear();

            messageToUser.setText("Просмотр закончен. Вернитесь в начало путём нажатия на /start");

            transmittedData.setState(State.WaitingStart);
        }


        return messageToUser;
    }

    public SendMessage processWaitingAuthorLastShow(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.equals(InlineButtonsStorage.ShowPrevAuthor.getCallBackData()) == false && textFromUser.equals(InlineButtonsStorage.FinishShowAuthor.getCallBackData()) == false) {
            messageToUser.setText("Ошибка. Нажмите на кнопку.");
            return messageToUser;
        }

        if (textFromUser.equals(InlineButtonsStorage.ShowPrevAuthor.getCallBackData()) == true) {

            ArrayList<Author> authors = (ArrayList<Author>) transmittedData.getDataStorage().get("authors");

            int countAuthors = (int) transmittedData.getDataStorage().get("countAuthors");

            int currentAuthorNumber = (int) transmittedData.getDataStorage().get("currentAuthorNumber");

            currentAuthorNumber--;

            transmittedData.getDataStorage().addOrUpdate("currentAuthorNumber", currentAuthorNumber);

            Author currentAuthor = authors.get(currentAuthorNumber - 1);

            messageToUser.setText(String.format("Автор %d из %d\nИмя: %s\nСтрана: %s", currentAuthorNumber, countAuthors, currentAuthor.getName(), currentAuthor.getCountry()));

            if (currentAuthorNumber == 1) {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getAuthorLastShowKeyboard());

                transmittedData.setState(State.WaitingAuthorFirstShow);
            } else {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getAuthorMiddleShowKeyboard());

                transmittedData.setState(State.WaitingAuthorMiddleShow);
            }

        } else if (textFromUser.equals(InlineButtonsStorage.FinishShowAuthor.getCallBackData()) == true) {
            transmittedData.getDataStorage().clear();

            messageToUser.setText("Просмотр закончен. Вернитесь в начало путём нажатия на /start");

            transmittedData.setState(State.WaitingStart);
        }


        return messageToUser;
    }

}
