package org.codeoshare.security.managedbeans;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.codeoshare.security.entidades.Grupo;
import org.codeoshare.security.entidades.Usuario;
import org.codeoshare.security.sessionbeans.GrupoRepositorio;
import org.codeoshare.security.sessionbeans.UsuarioRepositorio;

@ManagedBean
public class UsuarioMB {

	@EJB
	private UsuarioRepositorio usuarioRepositorio;

	@EJB
	private GrupoRepositorio grupoRepositorio;

	private Usuario usuario = new Usuario();

	private List<String> nomesDosGrupos;

	private List<Usuario> usuarios;

	private List<Grupo> grupos;

	public void adiciona() throws NoSuchAlgorithmException {
		//Associando os Grupos ao novo Usuário
		for (String nomeDoGrupo : this.nomesDosGrupos) {
			Grupo g = new Grupo();
			g.setNome(nomeDoGrupo);
			this.usuario.getGrupos().add(g);
		}
		//Criptografando a senha do Usuário
		MessageDigest md = MessageDigest.getInstance("MD5"); // or "SHA-1"
		md.update(this.usuario.getSenha().getBytes());
		BigInteger hash = new BigInteger(1, md.digest());
		String senhaCriptografada = hash.toString(16);
		while (senhaCriptografada.length() < 32) { // 40 for SHA-1
			senhaCriptografada = "0" + senhaCriptografada;
		}
		this.usuario.setSenha(senhaCriptografada);

		//Salvando o Usuário
		this.usuarioRepositorio.adiciona(this.usuario);
		this.usuario = new Usuario();
		this.usuarios = null;
	}

	public List<Grupo> getGrupos() {
		if (this.grupos == null) {
			this.grupos = this.grupoRepositorio.bustaTodos();
		}
		return this.grupos;
	}

	public List<Usuario> getUsuarios() {
		if (this.usuarios == null) {
			this.usuarios = this.usuarioRepositorio.buscaTodos();
		}
		return this.usuarios;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<String> getNomesDosGrupos() {
		return nomesDosGrupos;
	}
	public void setNomesDosGrupos(List<String> nomesDosGrupos) {
		this.nomesDosGrupos = nomesDosGrupos;
	}
}
