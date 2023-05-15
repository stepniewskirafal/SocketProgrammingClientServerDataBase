package pl.rstepniewski.sockets.domain.message;

import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;
import static org.jooq.impl.DSL.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 * Created by rafal on 14.05.2023
 *
 * @author : rafal
 * @date : 14.05.2023
 * @project : SocketProgrammingClientServerDataBase
 */
public class MessageRepository {
    private Connection connection;
    private DSLContext dslContext;
    public MessageRepository() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SocketProgrammingClientServer?serverTimezone=UTC",
                "root",
                "admin");
        dslContext = DSL.using(connection, SQLDialect.MYSQL);
    }

    public Result<Record> findByUserName(String userName ) {
        SelectConditionStep<Record> selectStatement = dslContext.select()
                                                            .from(table("message"))
                                                            .where(field("sender").eq(userName));
        return selectStatement.fetch();
    }

    public Record1<Integer> countAllByUserName(String userName ) {
        SelectConditionStep<Record1<Integer>> countStatement = dslContext.selectCount()
                                                                .from(table("message"))
                                                                .where(field("sender").eq(userName));
        return countStatement.fetchOne();
    }

    public void addNewMessage(Message message ) {
        dslContext.insertInto(table("message"))
                .set(field("topic"), message.getTopic())
                .set(field("content"), message.getContent())
                .set(field("recipient"), message.getRecipient())
                .set(field("sender"), message.getSender())
                .execute();

    }


}
