package org.example.service.logic;

import org.example.db.Author;
import org.example.db.Book;
import org.example.db.BooksRepository;
import org.example.statemachine.State;
import org.example.statemachine.TransmittedData;
import org.example.util.NumberUtil;
import org.example.util.buttons.InlineButtonsStorage;
import org.example.util.buttons.InlineKeyboardsStorage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;

public class AddNewBookLogic {
    private BooksRepository booksRepository;

    public AddNewBookLogic() {
        booksRepository = new BooksRepository();
    }

    public SendMessage processWaitingInputBookName(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.length() > 30) {
            messageToUser.setText("Ошибка ввода имя автора. Длина имени должна быть от 1 до 30 символов. Повторите ввод названия имени");
            return messageToUser;
        }

        transmittedData.getDataStorage().addOrUpdate("bookName", textFromUser);

        messageToUser.setText("Название книги успешно записано. Теперь введите год создания книги");
        transmittedData.setState(State.WaitingInputBookCreatedYear);

        return messageToUser;
    }

    public SendMessage processWaitingInputBookCreatedYear(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (NumberUtil.isIntNumber(textFromUser) == false) {
            messageToUser.setText("Ошибка ввода года создания книги. Вы ввели не число");
            return messageToUser;
        }

        int createdYear = NumberUtil.stringToInt(textFromUser);

        if (NumberUtil.isNumberInRange(createdYear, 0, 2024) == false) {
            messageToUser.setText("Ошибка ввода года создания книги. Год создания книги должен быть от 0 до 2024");
            return messageToUser;
        }

        transmittedData.getDataStorage().addOrUpdate("createdYear", createdYear);

        String bookName = (String) transmittedData.getDataStorage().get("bookName");

        messageToUser.setText(String.format("Год создания книги успешно записан. Теперь проверьте корретность введённых данных и нажмите кнопку подтверждения или отмены.\nНазвание книги: %s\nГод создания: %d", bookName, createdYear));

        messageToUser.setReplyMarkup(InlineKeyboardsStorage.getApproveBookDataKeyboard());

        transmittedData.setState(State.WaitingApproveBookData);

        return messageToUser;
    }

    public SendMessage processWaitingApproveBookData(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.equals(InlineButtonsStorage.ApproveAddBook.getCallBackData()) == false && textFromUser.equals(InlineButtonsStorage.DisapproveAddBook.getCallBackData()) == false) {
            messageToUser.setText("Ошибка. Нажмите на кнопку.");
            return messageToUser;
        }

        if (textFromUser.equals(InlineButtonsStorage.ApproveAddBook.getCallBackData()) == true) {
            String bookName = (String) transmittedData.getDataStorage().get("bookName");
            int createdYear = (int) transmittedData.getDataStorage().get("createdYear");

            ArrayList<Author> authors = (ArrayList<Author>) transmittedData.getDataStorage().get("authors");

            int currentAuthorNumber = (int) transmittedData.getDataStorage().get("currentAuthorNumber");

            Author currentAuthor = authors.get(currentAuthorNumber - 1);

            Book book = new Book(0, bookName, createdYear, currentAuthor.getId());

            booksRepository.addNewBook(book);

            transmittedData.getDataStorage().clear();

            messageToUser.setText("Данные о книге успешно сохранены. Вернитесь в начало путём нажатия на /start");
        } else if (textFromUser.equals(InlineButtonsStorage.DisapproveAddBook.getCallBackData()) == true) {
            transmittedData.getDataStorage().clear();

            messageToUser.setText("Добавление успешно отменено. Вернитесь в начало путём нажатия на /start");
        }

        transmittedData.setState(State.WaitingStart);

        return messageToUser;
    }
}
