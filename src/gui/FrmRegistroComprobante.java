package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import componentes.JComboBoxBD;
import entidad.Cliente;
import entidad.Comprobante;
import entidad.Pedido;
import entidad.Usuario;
import model.ComprobanteModel;
import util.Validaciones;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class FrmRegistroComprobante extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtFechaPago;
	private JTextField txtEstado;
	private JComboBoxBD cboPedido;
	private JComboBoxBD cboCliente;
	private JComboBoxBD cboUsuario;
	
	private ResourceBundle rb=ResourceBundle.getBundle("combo");
	private JButton Registrar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroComprobante frame = new FrmRegistroComprobante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRegistroComprobante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro Comprobante");
		lblNewLabel.setBounds(210, 11, 137, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblFechapago = new JLabel("FechaPago");
		lblFechapago.setBounds(10, 50, 93, 14);
		contentPane.add(lblFechapago);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 79, 93, 14);
		contentPane.add(lblEstado);
		
		JLabel lblPedido = new JLabel("Pedido");
		lblPedido.setBounds(287, 50, 60, 14);
		contentPane.add(lblPedido);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(287, 79, 60, 14);
		contentPane.add(lblCliente);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(287, 104, 60, 14);
		contentPane.add(lblUsuario);
		
		txtFechaPago = new JTextField();
		txtFechaPago.setColumns(10);
		txtFechaPago.setBounds(113, 47, 147, 20);
		contentPane.add(txtFechaPago);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(113, 76, 147, 20);
		contentPane.add(txtEstado);
		
		cboPedido = new JComboBoxBD(rb.getString("SQL_COMBO_PEDIDO"));
		cboPedido.setBounds(341, 50, 135, 20);
		contentPane.add(cboPedido);
		
		cboCliente = new JComboBoxBD(rb.getString("SQL_COMBO_CLIENTE"));
		cboCliente.setBounds(341, 75, 135, 20);
		contentPane.add(cboCliente);
		
		cboUsuario = new JComboBoxBD(rb.getString("SQL_COMBO_USUARIO"));
		cboUsuario.setBounds(341, 100, 135, 20);
		contentPane.add(cboUsuario);
		
		Registrar = new JButton("REGISTRAR");
		Registrar.addActionListener(this);
		Registrar.setBounds(208, 141, 108, 23);
		contentPane.add(Registrar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == Registrar) {
			actionPerformedRegistrarJButton(arg0);
		}
	}
	protected void actionPerformedRegistrarJButton(ActionEvent arg0)
	{
		String est=txtEstado.getText().trim();
		String fpa=txtFechaPago.getText().trim();
		String pedido=cboPedido.getSelectedItem().toString();
		String idpedido=pedido.split(":")[0];
		String cliente=cboCliente.getSelectedItem().toString();
		String idcliente=cliente.split(":")[0];
		String usuario=cboUsuario.getSelectedItem().toString();
		String idusuario=usuario.split(":")[0];
		
		if(fpa.matches(Validaciones.FECHA)==false) 
		{
			mensaje("La fecha debe ser yyyy-MM-dd");
		}
		else if(est.matches(Validaciones.TEXTO)==false) 
		{
			mensaje("Falta poner el estado");
		}
		else if(cboPedido.getSelectedIndex()==0) 
		{
			mensaje("Seleccione un pedido");
		}
		else if(cboCliente.getSelectedIndex()==0) 
		{
			mensaje("Seleccione un cliente");
		}
		else if(cboUsuario.getSelectedIndex()==0) 
		{
			mensaje("Seleccione un usuario");
		}
		else 
		{
			Pedido objPed=new Pedido();
			objPed.setIdpedido(Integer.parseInt(idpedido));
			Cliente objCli=new Cliente();
			objCli.setIdcliente(Integer.parseInt(idcliente));
			Usuario objUsu=new Usuario();
			objUsu.setIdusuario(Integer.parseInt(idusuario));
			
			Comprobante objCom=new Comprobante();
			objCom.setFechapago(fpa);
			objCom.setEstado(est);
			objCom.setPedido(objPed);
			objCom.setCliente(objCli);
			objCom.setUsuario(objUsu);
			
			ComprobanteModel model=new ComprobanteModel();
			int salida=model.insertaComprobante(objCom);
			
			if(salida>0) 
			{
				mensaje("Se registro correctamente");
				txtEstado.setText("");
				txtFechaPago.setText("");
				cboCliente.setSelectedIndex(0);
				cboPedido.setSelectedIndex(0);
				cboUsuario.setSelectedIndex(0);
			}
			else 
			{
				mensaje("Error en el registro");
			}
		}
	}
	
	void mensaje(String msg) 
	{
		JOptionPane.showMessageDialog(this, msg);
	}
}
