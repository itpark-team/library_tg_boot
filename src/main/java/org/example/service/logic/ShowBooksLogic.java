package org.example.service.logic;

import org.example.db.Book;
import org.example.db.BooksRepository;
import org.example.statemachine.State;
import org.example.statemachine.TransmittedData;
import org.example.util.buttons.InlineButtonsStorage;
import org.example.util.buttons.InlineKeyboardsStorage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;

public class ShowBooksLogic {
    private BooksRepository booksRepository;

    public ShowBooksLogic() {
        booksRepository = new BooksRepository();
    }

    public SendMessage processWaitingBookFirstShow(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.equals(InlineButtonsStorage.ShowNextBook.getCallBackData()) == false && textFromUser.equals(InlineButtonsStorage.FinishShowBook.getCallBackData()) == false) {
            messageToUser.setText("Ошибка. Нажмите на кнопку.");
            return messageToUser;
        }

        if (textFromUser.equals(InlineButtonsStorage.ShowNextBook.getCallBackData()) == true) {

            ArrayList<Book> books = (ArrayList<Book>) transmittedData.getDataStorage().get("books");

            int countBooks = (int) transmittedData.getDataStorage().get("countBooks");

            int currentBookNumber = (int) transmittedData.getDataStorage().get("currentBookNumber");

            currentBookNumber++;

            transmittedData.getDataStorage().addOrUpdate("currentBookNumber", currentBookNumber);

            Book currentBook = books.get(currentBookNumber - 1);

            messageToUser.setText(String.format("Книга %d из %d\nНазвание книги: %s\nГод создания: %d", currentBookNumber, countBooks, currentBook.getName(), currentBook.getCreatedYear()));


            if (currentBookNumber == countBooks) {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getBookLastShowKeyboard());

                transmittedData.setState(State.WaitingBookLastShow);
            } else {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getBookMiddleShowKeyboard());

                transmittedData.setState(State.WaitingBookMiddleShow);
            }

        } else if (textFromUser.equals(InlineButtonsStorage.FinishShowBook.getCallBackData()) == true) {
            transmittedData.getDataStorage().clear();

            messageToUser.setText("Просмотр закончен. Вернитесь в начало путём нажатия на /start");

            transmittedData.setState(State.WaitingStart);
        }


        return messageToUser;
    }

    public SendMessage processWaitingBookMiddleShow(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.equals(InlineButtonsStorage.ShowNextBook.getCallBackData()) == false && textFromUser.equals(InlineButtonsStorage.FinishShowBook.getCallBackData()) == false && textFromUser.equals(InlineButtonsStorage.ShowPrevBook.getCallBackData()) == false) {
            messageToUser.setText("Ошибка. Нажмите на кнопку.");
            return messageToUser;
        }

        if (textFromUser.equals(InlineButtonsStorage.ShowNextBook.getCallBackData()) == true) {

            ArrayList<Book> books = (ArrayList<Book>) transmittedData.getDataStorage().get("books");

            int countBooks = (int) transmittedData.getDataStorage().get("countBooks");

            int currentBookNumber = (int) transmittedData.getDataStorage().get("currentBookNumber");

            currentBookNumber++;

            transmittedData.getDataStorage().addOrUpdate("currentBookNumber", currentBookNumber);

            Book currentBook = books.get(currentBookNumber - 1);

            messageToUser.setText(String.format("Книга %d из %d\nНазвание книги: %s\nГод создания: %d", currentBookNumber, countBooks, currentBook.getName(), currentBook.getCreatedYear()));

            if (currentBookNumber == countBooks) {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getBookLastShowKeyboard());

                transmittedData.setState(State.WaitingBookLastShow);
            } else {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getBookMiddleShowKeyboard());

                transmittedData.setState(State.WaitingBookMiddleShow);
            }

        }
        if (textFromUser.equals(InlineButtonsStorage.ShowPrevBook.getCallBackData()) == true) {
            ArrayList<Book> books = (ArrayList<Book>) transmittedData.getDataStorage().get("books");

            int countBooks = (int) transmittedData.getDataStorage().get("countBooks");

            int currentBookNumber = (int) transmittedData.getDataStorage().get("currentBookNumber");

            currentBookNumber--;

            transmittedData.getDataStorage().addOrUpdate("currentBookNumber", currentBookNumber);

            Book currentBook = books.get(currentBookNumber - 1);

            messageToUser.setText(String.format("Книга %d из %d\nНазвание книги: %s\nГод создания: %d", currentBookNumber, countBooks, currentBook.getName(), currentBook.getCreatedYear()));

            if (currentBookNumber == 1) {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getBookFirstShowKeyboard());

                transmittedData.setState(State.WaitingBookFirstShow);
            } else {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getBookMiddleShowKeyboard());

                transmittedData.setState(State.WaitingBookMiddleShow);
            }
        } else if (textFromUser.equals(InlineButtonsStorage.FinishShowBook.getCallBackData()) == true) {
            transmittedData.getDataStorage().clear();

            messageToUser.setText("Просмотр закончен. Вернитесь в начало путём нажатия на /start");

            transmittedData.setState(State.WaitingStart);
        }


        return messageToUser;
    }

    public SendMessage processWaitingBookLastShow(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.equals(InlineButtonsStorage.ShowPrevBook.getCallBackData()) == false && textFromUser.equals(InlineButtonsStorage.FinishShowBook.getCallBackData()) == false) {
            messageToUser.setText("Ошибка. Нажмите на кнопку.");
            return messageToUser;
        }

        if (textFromUser.equals(InlineButtonsStorage.ShowPrevBook.getCallBackData()) == true) {

            ArrayList<Book> books = (ArrayList<Book>) transmittedData.getDataStorage().get("books");

            int countBooks = (int) transmittedData.getDataStorage().get("countBooks");

            int currentBookNumber = (int) transmittedData.getDataStorage().get("currentBookNumber");

            currentBookNumber--;

            transmittedData.getDataStorage().addOrUpdate("currentBookNumber", currentBookNumber);

            Book currentBook = books.get(currentBookNumber - 1);

            messageToUser.setText(String.format("Книга %d из %d\nНазвание книги: %s\nГод создания: %d", currentBookNumber, countBooks, currentBook.getName(), currentBook.getCreatedYear()));

            if (currentBookNumber == 1) {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getBookLastShowKeyboard());

                transmittedData.setState(State.WaitingBookFirstShow);
            } else {
                messageToUser.setReplyMarkup(InlineKeyboardsStorage.getBookMiddleShowKeyboard());

                transmittedData.setState(State.WaitingBookMiddleShow);
            }

        } else if (textFromUser.equals(InlineButtonsStorage.FinishShowBook.getCallBackData()) == true) {
            transmittedData.getDataStorage().clear();

            messageToUser.setText("Просмотр закончен. Вернитесь в начало путём нажатия на /start");

            transmittedData.setState(State.WaitingStart);
        }


        return messageToUser;
    }
}
