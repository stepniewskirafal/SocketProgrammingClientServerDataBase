package pl.rstepniewski.sockets.domain.message;

/**
 * Created by rafal on 19.04.2023
 *
 * @author : rafal
 * @date : 19.04.2023
 * @project : SocketProgrammingClientServer
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import pl.rstepniewski.sockets.domain.user.User;
import pl.rstepniewski.sockets.domain.user.UserRole;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class MessageService {
    MessageRepository messageRepository = new MessageRepository();

    private Connection connection;
    private DSLContext dslContext;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private ObjectNode objectNode = objectMapper.createObjectNode();

    public MessageService() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SocketProgrammingClientServer?serverTimezone=UTC",
                "root",
                "admin");
        dslContext = DSL.using(connection, SQLDialect.MYSQL);
    }

    public String getUserMessages(final User user) throws IOException {
        Result<Record> resultByUsername = messageRepository.findByUserName(dslContext, user.getUsername());

        return objectMapper.writeValueAsString(resultByUsername);
    }

    public boolean sendMessage(final List<Message> messageList ) throws IOException {
        boolean isMessageSent = true;

        try{
            messageRepository.addNewMessage(dslContext, messageList);
        }catch (Exception e ){
            isMessageSent = false;
        }

        return isMessageSent;
    }
}
