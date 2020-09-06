module java.maill {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires activation;
    requires java.mail;

    opens barosanu;
    opens barosanu.view;
    opens barosanu.controller;
    opens barosanu.model;
}