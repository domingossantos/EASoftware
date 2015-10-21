/**
 * 
 */
package br.ufpa.easw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * ContaDAO.java 
 * 
 * <p>A DAO to persist an account</p>
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
public class ContaDAO implements ContaRepositorio {

	private static Connection connection = null;
	
	/**
	 * @throws  
	 * @see br.ufpa.easw.ContaRepositorio#atualizarSaldo(br.ufpa.easw.Conta)
	 */
	@Override
	public void atualizarSaldo(Conta c){
		try {
			connection  = getConnection();
			String sql = "UPDATE conta set saldo = "+c.getSaldo();
			PreparedStatement p = connection.prepareStatement(sql);
			p.execute();
		} catch (SQLException e) {}
		
	}


	@Override
	public List<Conta> buscaPorSaldoMaiorQue(double saldo) {
		try {
			connection  = getConnection();
			String sql = "SELECT * FROM conta where saldo >= "+saldo;
			Statement s = connection.createStatement();
			ResultSet r =  s.executeQuery(sql);
			
			List<Conta> contas = new ArrayList<Conta>();
			while(r.next()){
				Conta c = new Conta(this, r.getDouble(1));
				contas.add(c);
			}
			
			return contas;
			
		} catch (SQLException e) { return null;}
	}
	
	
	private static Connection getConnection() {
		if(connection == null){

			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tap2", "postgres", "passwd");
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}		
			
			return connection;
		}else
			return connection;
	}

}
