package com.zhoubw;

import com.zhoubw.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.jms.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@SpringBootTest
@Slf4j
class MytestApplicationTests {


}
