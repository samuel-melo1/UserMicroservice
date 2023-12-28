package com.ms.usermicrosrevice.producers;

import com.ms.usermicrosrevice.models.EmailDto;
import com.ms.usermicrosrevice.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel){
        var emailDto = new EmailDto();
        emailDto.setUserId(userModel.getId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Cadastro realizado com Sucesso!");
        emailDto.setText(userModel.getName() + ", seja bem-vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma! ");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);



    }
}
