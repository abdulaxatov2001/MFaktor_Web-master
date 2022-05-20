package com.example.botservice.bot;

public interface State {
    String START = "start";
    String MENU = "menu";
    String ORDER = "order";
    String ENTER_COMPANY_NAME = "enter_companyname";
    String ENTER_FULLNAME = "enter_fullname";
    String SELECT_CATEGORY = "select_category";
    String SELECT_EVENT = "select_event";

    String ENTER_POSITION="enter_position";
    String ENTER_REGISTER="enter_register";
}
