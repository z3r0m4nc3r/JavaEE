package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Candidato;

@Service
public class CandidatosServiceImpl implements CandidatosService {
	@Autowired
	DataSource data;
	
	@Override
	public void altaCandidato(Candidato candidato) {
		try(Connection con=data.getConnection()){
			String sql="Insert into candidatos(nombre,edad,puesto,foto,email) values(?,?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, candidato.getNombre());
			st.setInt(2, candidato.getEdad());
			st.setString(3, candidato.getPuesto());
			st.setString(4, candidato.getFoto());
			st.setString(5, candidato.getEmail());
			st.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void eliminarCandidato(int idCandidato) {
		try(Connection con=data.getConnection()){
			String sql="delete from candidatos where idCandidato=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, idCandidato);
			st.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public List<Candidato> recuperarCandidatos(){
		List<Candidato> candidatos=new ArrayList<>();
		try(Connection con=data.getConnection()){
			String sql="select * from candidatos";
			PreparedStatement st=con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Candidato candidato=new Candidato(rs.getInt("idCandidato"), 
						rs.getString("nombre"), 
						rs.getInt("edad"), 
						rs.getString("puesto"), 
						rs.getString("foto"), 
						rs.getString("email"));
				candidatos.add(candidato);				
			}			
			return candidatos;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
