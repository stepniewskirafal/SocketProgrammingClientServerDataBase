package pl.rstepniewski.sockets.io.db;

/**
 * Created by rafal on 19.04.2023
 *
 * @author : rafal
 * @date : 19.04.2023
 * @project : SocketProgrammingClientServer
 */

import java.io.IOException;
import java.util.List;

public interface Repository {
    <T> List<T> importTableFromDb() throws IOException;

    <T> void exportDataToTableInDb() throws IOException;
    void deleteDataFromTableInDb() throws IOException;

}
