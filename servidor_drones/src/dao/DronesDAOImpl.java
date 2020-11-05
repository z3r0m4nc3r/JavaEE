package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Registro;

public class DronesDAOImpl implements DronesDAO {
	@Override
	public void saveRegistro(Registro registro) {
		try(Connection con=Datos.getConnection()){
			String sql="Insert into registro(dron,longitud,latitud,momento) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, registro.getDron());
			ps.setDouble(2, registro.getLongitud());
			ps.setDouble(3, registro.getLatitud());
			ps.setTimestamp(4, Timestamp.valueOf(registro.getMomento()));
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<Registro> findRegistros() {
		List<Registro> registros=new ArrayList<>();
		try(Connection cn=Datos.getConnection();){				
			String sql="select * from registros";
			PreparedStatement ps=cn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				registros.add(new Registro(rs.getInt("idRegistro"),
						rs.getString("dron"),
						rs.getDouble("longitud"),
						rs.getDouble("latitud"),
						rs.getTimestamp("momento").toLocalDateTime()));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();	
		}
		return registros;
	}
	

	@Override
	public List<Registro> findRegistrosByDron(String dron) {
		List<Registro> registros=new ArrayList<>();
		try(Connection cn=Datos.getConnection();){				
			String sql="select * from registros where dron=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, dron);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				registros.add(new Registro(rs.getInt("idRegistro"),
						rs.getString("dron"),
						rs.getDouble("longitud"),
						rs.getDouble("latitud"),
						rs.getTimestamp("momento").toLocalDateTime()));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();	
		}
		return registros;
	}

}
