package org.malopes.ssp;

import java.util.ArrayList;
import java.util.List;

public class TabelaSimbolos {

	private static List<Simbolo> tabela = new ArrayList<Simbolo>();

	public static void addSimbolo(Simbolo simbolo) {
		if (!tabela.contains(simbolo)) {
			tabela.add(simbolo);
		}
		simbolo.getToken().setIndiceTabSimb(tabela.indexOf(simbolo));
	}

	public static void listaTabela() {
		System.out.println("\n");
		for (Simbolo simbolo : tabela) {
			simbolo.debug();
		}
	}

	public static List<Simbolo> getSimbolosByEscopo(String escopo) {

		List<Simbolo> simbolosByEscopo = new ArrayList<Simbolo>();
		for (Simbolo simb : tabela) {
			if (simb.getEscopo().equals(escopo)) {
				simbolosByEscopo.add(simb);
			}
		}
		return simbolosByEscopo;
	}

	public static String getTipoSimbolo(Token token) {

		Simbolo simboloAchado = tabela.get(token.getIndiceTabSimb());
		if (simboloAchado != null) {
			return simboloAchado.getTipo();
		}

		return null;
	}

	public static String getTipoCompativel(Classe classe) {
		switch (classe) {
		case ConstanteLiteralInteira:
			return "Int";
		case ConstanteLiteralString:
			return "Str";
		case ConstanteLiteralReal:
			return "Real";
		default:
			return null;
		}
	}

	public static void setTipoSimbolo(Token token, String tipo) {
		/*
		 * for (int i = 0; i< tabela.size(); i++) { Simbolo simbolo =
		 * tabela.get(i); if
		 * (simbolo.getToken().getImagem().equals(token.getImagem())) {
		 * simbolo.setTipo(tipo); return true; } }
		 */
		Simbolo simboloLocal = tabela.get(token.getIndiceTabSimb());
		simboloLocal.setTipo(tipo);
	}

	public static Object getValor(Token token) {
		Simbolo simboloAchado = tabela.get(token.getIndiceTabSimb());
		if (simboloAchado != null) {
			return simboloAchado.getValor();
		}
		return null;
	}

	public static boolean setValor(Token token, Object valor) {
		/*
		 * for (Simbolo simbolo : tabela) { if
		 * (simbolo.getToken().getImagem().equals(token.getImagem())){
		 * simbolo.setValor(value); return true; } }
		 */
		Simbolo simboloLocal = tabela.get(token.getIndiceTabSimb());
		if (simboloLocal.getTipo() != null) {
			simboloLocal.setValor(valor);
		}
		return false;
	}

	public static String getTipoDefSimbolo(Token defId) {
		for(Simbolo simbolo : tabela) {
			if(simbolo.getToken().equals(defId) && simbolo.getEscopo().equals(defId.getImagem())) {
				//System.out.println("Simbolo id def encontrado: " + simbolo);
				return simbolo.getTipo();
			}
		}

		return null;
	}

}
