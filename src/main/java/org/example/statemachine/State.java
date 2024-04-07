package org.example.statemachine;

public class State {
    public final static String WaitingStart = "WaitingStart";

    public final static String WaitingShowOrAddAuthors = "WaitingShowOrAddAuthors";

    public final static String WaitingShowOrAddBooks = "WaitingShowOrAddBooks";

    //add author
    public final static String WaitingInputAuthorName = "WaitingInputAuthorName";

    public final static String WaitingInputAuthorCountry = "WaitingInputAuthorCountry";

    public final static String WaitingApproveAuthorData = "WaitingApproveAuthorData";


    //show authors

    public final static String WaitingAuthorFirstShow = "WaitingAuthorFirstShow";

    public final static String WaitingAuthorMiddleShow = "WaitingAuthorMiddleShow";

    public final static String WaitingAuthorLastShow = "WaitingAuthorLastShow";


    //add book
    public final static String WaitingInputBookName = "WaitingInputBookName";

    public final static String WaitingInputBookCreatedYear = "WaitingInputBookCreatedYear";

    public final static String WaitingApproveBookData = "WaitingApproveBookData";

    //show books

    public final static String WaitingBookFirstShow = "WaitingBookFirstShow";

    public final static String WaitingBookMiddleShow = "WaitingBookMiddleShow";

    public final static String WaitingBookLastShow = "WaitingBookLastShow";

}
