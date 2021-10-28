package com.sudokubase.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class SendGridService {

    SendGrid sendGrid;

    public SendGridService(SendGrid sendGrid) {
        this.sendGrid = sendGrid;
    }

    public void sendEmailWithSendGrid(String message, String mailTo, String subject) {

        Email from = new Email("noreply@sudokubase.com");
       // String subject = "SudokuBase - Confirm your Account";
        Email to = new Email(mailTo);
        Content content = new Content("text/html", message);

        Mail mail = new Mail(from, subject, to, content);

        mail.setReplyTo(new Email("noreply@sudokubase.com"));

        Request request = new Request();
        Response response = null;

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            response = sendGrid.api(request);

            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
