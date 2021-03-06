package org.malopes.ssp;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private Node pai;
	private List<Node> filhos;
	private TipoOfNode tipo;
	private Token token;

	public Node(int maxFilhos, TipoOfNode tipo) {
		if (maxFilhos > 0) {
			filhos = new ArrayList<Node>(maxFilhos);
		}
		this.tipo = tipo;
	}

	public Node(Token token) {
		this.tipo = TipoOfNode.Token;
		this.token = token;
	}

	public List<Node> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<Node> filhos) {
		this.filhos = filhos;
	}

	public Node getPai() {
		return pai;
	}

	public void setPai(Node pai) {
		this.pai = pai;
	}

	public TipoOfNode getTipo() {
		return tipo;
	}

	public void setTipo(TipoOfNode tipo) {
		this.tipo = tipo;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public void addFilho(Node node) {
		if (node != null) {
			node.setPai(this);
		}
		filhos.add(node);
	}

	public Node getFilho(int index) {
		return filhos.get(index);
	}

	@Override
	public String toString() {
		return "Node [tipo=" + tipo + ", token=" + token + "]";
	}

	/*
	 * public abstract Object analisar();
	 * 
	 * public abstract Object interpretar();
	 */
	

}
