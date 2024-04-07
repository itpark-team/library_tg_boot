package org.example.util.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineKeyboardsStorage {
    public static InlineKeyboardMarkup getShowOrAddAuthorsKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = null;
        InlineKeyboardButton button = null;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ShowAuthors.getTitle());
        button.setCallbackData(InlineButtonsStorage.ShowAuthors.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.AddNewAuthor.getTitle());
        button.setCallbackData(InlineButtonsStorage.AddNewAuthor.getCallBackData());
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getApproveAuthorDataKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = null;
        InlineKeyboardButton button = null;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ApproveAddAuthor.getTitle());
        button.setCallbackData(InlineButtonsStorage.ApproveAddAuthor.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.DisapproveAddAuthor.getTitle());
        button.setCallbackData(InlineButtonsStorage.DisapproveAddAuthor.getCallBackData());
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getApproveBookDataKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = null;
        InlineKeyboardButton button = null;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ApproveAddBook.getTitle());
        button.setCallbackData(InlineButtonsStorage.ApproveAddBook.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.DisapproveAddBook.getTitle());
        button.setCallbackData(InlineButtonsStorage.DisapproveAddBook.getCallBackData());
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getNothingAuthorsKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = null;
        InlineKeyboardButton button = null;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.FinishShowAuthor.getTitle());
        button.setCallbackData(InlineButtonsStorage.FinishShowAuthor.getCallBackData());
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getCloseAuthorsKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = null;
        InlineKeyboardButton button = null;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ShowBooks.getTitle());
        button.setCallbackData(InlineButtonsStorage.ShowBooks.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.AddNewBook.getTitle());
        button.setCallbackData(InlineButtonsStorage.AddNewBook.getCallBackData());
        row.add(button);
        keyboard.add(row);


        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.FinishShowAuthor.getTitle());
        button.setCallbackData(InlineButtonsStorage.FinishShowAuthor.getCallBackData());
        row.add(button);
        keyboard.add(row);



        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getAuthorFirstShowKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = null;
        InlineKeyboardButton button = null;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ShowBooks.getTitle());
        button.setCallbackData(InlineButtonsStorage.ShowBooks.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.AddNewBook.getTitle());
        button.setCallbackData(InlineButtonsStorage.AddNewBook.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ShowNextAuthor
                .getTitle());
        button.setCallbackData(InlineButtonsStorage.ShowNextAuthor.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.FinishShowAuthor.getTitle());
        button.setCallbackData(InlineButtonsStorage.FinishShowAuthor.getCallBackData());
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getAuthorMiddleShowKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = null;
        InlineKeyboardButton button = null;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ShowBooks.getTitle());
        button.setCallbackData(InlineButtonsStorage.ShowBooks.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.AddNewBook.getTitle());
        button.setCallbackData(InlineButtonsStorage.AddNewBook.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ShowNextAuthor.getTitle());
        button.setCallbackData(InlineButtonsStorage.ShowNextAuthor.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ShowPrevAuthor.getTitle());
        button.setCallbackData(InlineButtonsStorage.ShowPrevAuthor.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.FinishShowAuthor.getTitle());
        button.setCallbackData(InlineButtonsStorage.FinishShowAuthor.getCallBackData());
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getAuthorLastShowKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = null;
        InlineKeyboardButton button = null;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ShowBooks.getTitle());
        button.setCallbackData(InlineButtonsStorage.ShowBooks.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.AddNewBook.getTitle());
        button.setCallbackData(InlineButtonsStorage.AddNewBook.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ShowPrevAuthor.getTitle());
        button.setCallbackData(InlineButtonsStorage.ShowPrevAuthor.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.FinishShowAuthor.getTitle());
        button.setCallbackData(InlineButtonsStorage.FinishShowAuthor.getCallBackData());
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getNothingBooksKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = null;
        InlineKeyboardButton button = null;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.FinishShowBook.getTitle());
        button.setCallbackData(InlineButtonsStorage.FinishShowBook.getCallBackData());
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getCloseBooksKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = null;
        InlineKeyboardButton button = null;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.FinishShowBook.getTitle());
        button.setCallbackData(InlineButtonsStorage.FinishShowBook.getCallBackData());
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getBookFirstShowKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = null;
        InlineKeyboardButton button = null;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ShowNextBook
                .getTitle());
        button.setCallbackData(InlineButtonsStorage.ShowNextBook.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.FinishShowBook.getTitle());
        button.setCallbackData(InlineButtonsStorage.FinishShowBook.getCallBackData());
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getBookMiddleShowKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = null;
        InlineKeyboardButton button = null;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ShowNextBook.getTitle());
        button.setCallbackData(InlineButtonsStorage.ShowNextBook.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ShowPrevBook.getTitle());
        button.setCallbackData(InlineButtonsStorage.ShowPrevBook.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.FinishShowBook.getTitle());
        button.setCallbackData(InlineButtonsStorage.FinishShowBook.getCallBackData());
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getBookLastShowKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = null;
        InlineKeyboardButton button = null;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.ShowPrevBook.getTitle());
        button.setCallbackData(InlineButtonsStorage.ShowPrevBook.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(InlineButtonsStorage.FinishShowBook.getTitle());
        button.setCallbackData(InlineButtonsStorage.FinishShowBook.getCallBackData());
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }
}
