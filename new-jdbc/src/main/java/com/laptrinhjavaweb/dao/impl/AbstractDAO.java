package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.IGenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

public class AbstractDAO<T> implements IGenericDAO<T>{
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/newservlet";
			String user="root";
			String password="200219";
			return DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
		return null;
			
		} catch (SQLException e) {
			
		return null;
		}
	
		
		
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results=new ArrayList<>();
		Connection conn=null;
		PreparedStatement statement=null;
		ResultSet resultSet =null;
		try {
			conn=getConnection();
			statement=conn.prepareStatement(sql);
			//set parameter
			setParameter(statement, parameters);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				results.add(rowMapper.rowMap(resultSet));
				
			}
			return results;
		} catch (SQLException e) {
			return null;	
		}finally {
			
			
			try {
				if(conn!=null) {
				conn.close();
				}
				if(statement!=null) {
					statement.close();
					}
				if(resultSet!=null) {
					resultSet.close();
					}
			} catch (SQLException e) {
				
				return null;
			}
		
		
	}



	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
		for (int i = 0; i < parameters.length; i++) {
			Object parameter=parameters[i];
			int index=i+1;
			if(parameter instanceof Long) {
				
					statement.setLong(index, (long) parameter);
				
				
			}else if(parameter instanceof Integer) {
				
				statement.setInt(index, (Integer) parameter);
			
			
		}else if(parameter instanceof String) {
			
			statement.setString(index, (String) parameter);
		
		
	}else if(parameter instanceof Timestamp) {
		
		statement.setTimestamp(index, (Timestamp) parameter);
	
	
}else if(parameter == null) {
	
	statement.setNull(index,Types.NULL);


}
		}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection conn=null;
		//ResultSet results=null;
		PreparedStatement statement=null;
		try {
			conn=getConnection();
			conn.setAutoCommit(false);
			statement=conn.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			conn.commit();
		} catch (Exception e) {
		try {
			conn.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}finally {
			
			
			try {
				if(conn!=null) {
				conn.close();
				}
				if(statement!=null) {
					statement.close();
					}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
				
			}
			}
		
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection conn=null;
		ResultSet results=null;
		PreparedStatement statement=null;
		try {
			Long id=null;
			conn=getConnection();
			conn.setAutoCommit(false);
			statement=conn.prepareStatement(sql,statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			results=statement.getGeneratedKeys();
			if(results.next()) {
				id= results.getLong(1);
			}
			conn.commit();
			return id;
		} catch (Exception e) {
		try {
			conn.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}finally {
			
			
			try {
				if(conn!=null) {
				conn.close();
				}
				if(statement!=null) {
					statement.close();
					}
				if(results!=null) {
					results.close();
					}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
				
			}
			}
		return null;
	}

	@Override
	public int count(String sql, Object... parameters) {
		
		Connection conn=null;
		PreparedStatement statement=null;
		ResultSet resultSet =null;
		try {
			int count=1;
			conn=getConnection();
			statement=conn.prepareStatement(sql);
			
			setParameter(statement, parameters);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				count=resultSet.getInt(1);
				
			}
			return count;
		} catch (SQLException e) {
			return 0;	
		}finally {
			
			
			try {
				if(conn!=null) {
				conn.close();
				}
				if(statement!=null) {
					statement.close();
					}
				if(resultSet!=null) {
					resultSet.close();
					}
			} catch (SQLException e) {
				return 0;
				
			}
		
		
	}
		
	}


	
}
