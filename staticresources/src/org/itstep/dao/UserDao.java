package org.itstep.dao;

import org.itstep.domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class UserDao extends GenericDao<User> {

	private static final String INSERT = "INSERT INTO users.users(login, password) VALUES(?, ?)";
	private static final String SELECT = "SELECT id, login, password from users.users";
	private static final String DELETE = "DELETE FROM users.users WHERE login = ?";
    private static final String UPDATE = "UPDATE users.users SET login = ?, password = ? WHERE login = ?";

	public UserDao(String connectionString, String user, String password) throws SQLException {
		super(connectionString, user, password);
	}

	@Override
	public void save(User data) {
		try {
			startTransaction();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, data.getLogin());
			preparedStatement.setString(2, data.getPassword());
			preparedStatement.execute();
			commit();
		} catch (SQLException e) {
			try {
				rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<User> findAll() {
		List<User> all = new ArrayList<>();
		int i = 0;
		try {
			startTransaction();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery(SELECT);
			while (resultSet.next()) {
				all.add(new User(i++, resultSet.getString("login"), resultSet.getString("password")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return all;
	}

	@Override
	public void update(User data) {
		try {
			startTransaction();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
			preparedStatement.setString(1, data.getLogin());
			preparedStatement.setString(2, data.getPassword());
			preparedStatement.setString(3, data.getLogin());
			preparedStatement.execute();
			commit();
		} catch (SQLException e) {
			try {
				rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User data) {
		try {
			startTransaction();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
			preparedStatement.setString(1, data.getLogin());
			preparedStatement.execute();
			commit();
		} catch (SQLException e) {
			try {
				rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}