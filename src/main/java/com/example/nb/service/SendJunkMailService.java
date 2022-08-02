package com.example.nb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * 描述：发送用户邮件服务
 * @author Ay
 * @date   2022/11/19
 */
@Service
public class SendJunkMailService {

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;


    public boolean sendJunkMail(List<String> ayUserList) {

        try{
            if(ayUserList == null || ayUserList.size() <= 0 ) return Boolean.FALSE;
            for(String ayUser: ayUserList){
                MimeMessage mimeMessage = this.mailSender.createMimeMessage();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                //邮件发送方
                message.setFrom(from);
                //邮件主题
                message.setSubject("通知");
                //邮件接收方
                message.setTo("cwxflyz@163.com");
                //邮件内容
                message.setText("您已被评为亚洲杰出优秀律师！");
                //发送邮件
                this.mailSender.send(mimeMessage);
            }
        }catch(Exception ex){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
