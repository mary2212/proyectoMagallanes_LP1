package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidad.Comprobante;
import util.MySqlDBConexion;

public class ComprobanteModel
{
	public int insertaComprobante(Comprobante c) 
	{
		int salida=-1;
		Connection con=null;
		PreparedStatement pstm=null;
		
		try 
		{
			con=MySqlDBConexion.getConexion();
			String sql="insert into comprobante values(null,curtime(),?,?,?,?,?)";
			pstm=con.prepareStatement(sql);
			pstm.setString(1, c.getFechapago());
			pstm.setString(2, c.getEstado());
			pstm.setInt(3, c.getPedido().getIdpedido());
			pstm.setInt(4, c.getCliente().getIdcliente());
			pstm.setInt(5, c.getUsuario().getIdusuario());			
			salida=pstm.executeUpdate();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(pstm!=null)pstm.close();
				if(con!=null)con.close();
			}
			catch(Exception e2)
			{
				
			}
		}
		return salida;
	}
}
