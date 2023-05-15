package pl.rstepniewski.sockets.domain.user;

/**
 * Created by rafal on 19.04.2023
 *
 * @author : rafal
 * @date : 19.04.2023
 * @project : SocketProgrammingClientServer
 */

import org.jooq.Record;
import org.jooq.Result;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserService{
    private List<User> userList = new ArrayList<>();

    private UserRepository userRepository = new UserRepository();

    public UserService() throws SQLException {
    }

    public Optional<User> getUserByName(final String userName) {
        Result<Record> userByName = userRepository.getUserByName(userName);
        User userFound = new User();

        if(userByName.isNotEmpty()) {
            userFound = new User(userByName.get(0).getValue("username", String.class)
                    , userByName.get(0).getValue("password", String.class)
                    , userByName.get(0).getValue("role", UserRole.class));
        }

        return Optional.ofNullable(userFound);
    }

    public List<User> getUserList() {
        User userFound;
        Result<Record> userRecordList = userRepository.getUserList();

        if(userRecordList.isNotEmpty()) {
            for(Record record : userRecordList){
                userFound = new User(record.getValue("username", String.class)
                        , record.getValue("password", String.class)
                        , record.getValue("role", UserRole.class));
                userList.add(userFound);
            }
        }
        return userList;
    }

    public List<User> getAdminList() {
        User userFound;
        Result<Record> adminRecordList = userRepository.getAdminList();

        if(adminRecordList.isNotEmpty()) {
            for(Record record : adminRecordList){
                userFound = new User(record.getValue("username", String.class)
                        , record.getValue("password", String.class)
                        , record.getValue("role", UserRole.class));
                userList.add(userFound);
            }
        }
        return userList;
    }

    public List<User> getUserAndAdminList() {
        User userFound;
        Result<Record> userAndAdminRecordList = userRepository.getUserAndAdminList();

        if(userAndAdminRecordList.isNotEmpty()) {
            for(Record record : userAndAdminRecordList){
                userFound = new User(record.getValue("username", String.class)
                        , record.getValue("password", String.class)
                        , record.getValue("role", UserRole.class));
                userList.add(userFound);
            }
        }
        return userList;
    }

    public boolean addNewUser(final User user) {
        return userRepository.addNewUser(user);
    }

    public boolean removeUser(final String userName) {
        return userRepository.removeUser(userName);
    }
}
