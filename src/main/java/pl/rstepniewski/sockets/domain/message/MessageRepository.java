package pl.rstepniewski.sockets.domain.message;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectConditionStep;

import java.util.List;

import static org.jooq.impl.DSL.*;

/**
 * Created by rafal on 14.05.2023
 *
 * @author : rafal
 * @date : 14.05.2023
 * @project : SocketProgrammingClientServerDataBase
 */
public class MessageRepository {

    public Result<Record> findByUserName(DSLContext create, String userName ) {

        SelectConditionStep<Record> selectStatement = create.select()
                                                            .from(table("message"))
                                                            .where(field("sender").eq(userName));

        return selectStatement.fetch();
    }

    public void addNewMessage(DSLContext create, List<Message> messageList ) {

        for(Message message : messageList) {
            create.insertInto(table("message"))
                    .set(field("topic"), message.getTopic())
                    .set(field("content"), message.getContent())
                    .set(field("recipient"), message.getRecipient())
                    .set(field("sender"), message.getSender())
                    .execute();
        }
    }


}
