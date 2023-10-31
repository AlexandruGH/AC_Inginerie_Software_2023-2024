package repository.book;

import model.Book;
import model.builder.BookBuilder;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepositoryMySQL implements BookRepository{
    private final Connection connection;

    public BookRepositoryMySQL(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM book;";

        List<Book> books = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                books.add(getBookFromResultSet(resultSet));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }


        return books;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean save(Book book) {
        String sql = "INSERT INTO book VALUES(null, ?, ?, ?);";

        String newSql = "INSERT INTO book VALUES(null, \'" + book.getAuthor() +"\', \'"+ book.getTitle()+"\', null );";





        try{
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, book.getAuthor());
//            preparedStatement.setString(2, book.getTitle());
//            preparedStatement.setDate(3, book.getPublishedDate());
            Statement statement = connection.createStatement();
            statement.executeUpdate(newSql);
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void removeAll() {

    }


    private Book getBookFromResultSet(ResultSet resultSet) throws SQLException {
        return new BookBuilder()
                .setId(resultSet.getLong("id"))
                .setAuthor(resultSet.getString("author"))
                .setTitle(resultSet.getString("title"))
                .build();
    }
}
