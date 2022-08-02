package com.example.nb.quartz;

import com.example.nb.service.SendJunkMailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：定时器类
 * @author Ay
 * @date   2022/11/18
 */
@Component
@Configurable
@EnableScheduling
public class SendMailQuartz {

    //日志对象
    private static final Logger logger = LogManager.getLogger(SendMailQuartz.class);

   @Resource
    private SendJunkMailService sendJunkMailService;



    //每5秒执行一次
    @Scheduled(cron = "*/10 * *  * * * ")
    public void reportCurrentByCron(){
      List<String> user = new ArrayList<>();
user.add("jiayi");
       if (user == null || user.size() <= 0) return;
        //发送邮件
        sendJunkMailService.sendJunkMail(user);


    }

}
