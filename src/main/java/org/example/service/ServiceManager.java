package org.example.service;

import org.example.service.logic.*;
import org.example.statemachine.State;
import org.example.statemachine.TransmittedData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.HashMap;
import java.util.Map;

public class ServiceManager {
    private Map<String, Service> methods;

    private StartLogic startLogic;
    private AddNewAuthorLogic addNewAuthorLogic;
    private ShowAuthorsLogic showAuthorsLogic;
    private AddNewBookLogic addNewBookLogic;
    private ShowBooksLogic showBooksLogic;


    public ServiceManager() {

        methods = new HashMap<>();

        startLogic = new StartLogic();

        addNewAuthorLogic = new AddNewAuthorLogic();

        showAuthorsLogic = new ShowAuthorsLogic();

        addNewBookLogic = new AddNewBookLogic();

        showBooksLogic = new ShowBooksLogic();

        methods.put(State.WaitingStart, startLogic::processWaitingCommandStart);
        methods.put(State.WaitingShowOrAddAuthors, startLogic::processWaitingShowOrAddAuthors);

        methods.put(State.WaitingInputAuthorName, addNewAuthorLogic::processWaitingInputAuthorName);
        methods.put(State.WaitingInputAuthorCountry, addNewAuthorLogic::processWaitingInputAuthorCountry);
        methods.put(State.WaitingApproveAuthorData, addNewAuthorLogic::processWaitingApproveAuthorData);

        methods.put(State.WaitingAuthorFirstShow, showAuthorsLogic::processWaitingAuthorFirstShow);
        methods.put(State.WaitingAuthorMiddleShow, showAuthorsLogic::processWaitingAuthorMiddleShow);
        methods.put(State.WaitingAuthorLastShow, showAuthorsLogic::processWaitingAuthorLastShow);

        methods.put(State.WaitingInputBookName, addNewBookLogic::processWaitingInputBookName);
        methods.put(State.WaitingInputBookCreatedYear, addNewBookLogic::processWaitingInputBookCreatedYear);
        methods.put(State.WaitingApproveBookData, addNewBookLogic::processWaitingApproveBookData);

        methods.put(State.WaitingBookFirstShow, showBooksLogic::processWaitingBookFirstShow);
        methods.put(State.WaitingBookMiddleShow, showBooksLogic::processWaitingBookMiddleShow);
        methods.put(State.WaitingBookLastShow, showBooksLogic::processWaitingBookLastShow);

    }

    public SendMessage callLogicMethod(String textFromUser, TransmittedData transmittedData) throws Exception {
        String state = transmittedData.getState();
        return methods.get(state).process(textFromUser, transmittedData);
    }

}
