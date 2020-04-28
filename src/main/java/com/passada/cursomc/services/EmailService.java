package com.passada.cursomc.services;

import com.passada.cursomc.domain.Cliente;
import com.passada.cursomc.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);

    void sendOrderConfirmationHtmlEmail(Pedido obj);

    void sendNewPasswordEmail(Cliente cliente, String newPass);
}
