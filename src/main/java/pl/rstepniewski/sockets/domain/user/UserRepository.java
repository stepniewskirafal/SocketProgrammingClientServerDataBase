package pl.rstepniewski.sockets.domain.user;

import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;
import static org.jooq.impl.DSL.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by rafal on 15.05.2023
 *
 * @author : rafal
 * @date : 15.05.2023
 * @project : SocketProgrammingClientServerDataBase
 */
public class UserRepository{
    private Connection connection;
    private DSLContext dslContext;

    public UserRepository() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SocketProgrammingClientServer?serverTimezone=UTC",
                "root",
                "admin");
        dslContext = DSL.using(connection, SQLDialect.MYSQL);
    }

    public Result<Record> getUserByName(String userName) {
        SelectConditionStep<Record> userRecord = dslContext.select()
                                                           .from(table("user"))
                                                           .where(field("username").eq(userName));

        return userRecord.fetch();
    }

    public Result<Record> getUserList() {
        SelectConditionStep<Record> usersRecord = dslContext.select()
                                                            .from(table("user"))
                                                            .where(field("role").eq(UserRole.USER.getRoleName()));
        return usersRecord.fetch();
    }

    public Result<Record> getAdminList() {
        SelectConditionStep<Record> adminsRecord = dslContext.select()
                                                             .from(table("user"))
                                                             .where(field("role").eq(UserRole.ADMIN.getRoleName()));
        return adminsRecord.fetch();
    }

    public Result<Record> getUserAndAdminList() {
        SelectJoinStep<Record> usersAdminsRecord = dslContext.select()
                                                             .from(table("user"));
        return usersAdminsRecord.fetch();
    }

    public boolean addNewUser(User user) {
        boolean responce = true;
        try {
            dslContext.insertInto(table("user"))
                    .set(field("userName"), user.getUsername())
                    .set(field("password"), user.getPassword())
                    .set(field("role"), user.getRole().getRoleName())
                    .execute();
        }catch (Exception e){
            responce = false;
        }
        return responce;
    }

    public boolean removeUser(String userName) {
        boolean responce = true;
        try {
            dslContext.delete(table("user"))
                    .where(field("username").eq(userName))
                    .execute();
        }catch (Exception e){
            responce = false;
        }
        return responce;
    }
}
