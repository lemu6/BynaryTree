package ArvoreBST;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

public class BinaryTree {
	private Node root;
	private int tamanho;

	private String resultadoTravessia;

	public BinaryTree() {
		root = null;
		tamanho = 0;
		resultadoTravessia = "";
	}

	public void addElemento(String nome) {
		tamanho++;
		root = addRecursivo(root, nome);
	}

	private Node addRecursivo(Node nodeAtual, String nome) {
		if(nodeAtual == null) {
			Node node = new Node(nome);
			return node;
		}

		if(nome.compareTo(nodeAtual.getNome()) < 0) {
			nodeAtual.left = addRecursivo(nodeAtual.left, nome);
		}
		else if(nome.compareTo(nodeAtual.getNome()) > 0) {
			nodeAtual.right = addRecursivo(nodeAtual.right, nome);
		}
		else {
			return nodeAtual;
		}

		return nodeAtual;
	}

	public void travessiaEmOrdem(Node node) {
		if(node != null) {
			travessiaEmOrdem(node.left);
			JOptionPane.showMessageDialog(null, " " + node.nome);
			resultadoTravessia += " " + node.nome;
			travessiaEmOrdem(node.right);
		}
	}

	public void travessiaPreOrdem(Node node) {
		if(node != null) {
			JOptionPane.showMessageDialog(null, " " + node.nome);
			resultadoTravessia += " " + node.nome;
			travessiaPreOrdem(node.left);
			travessiaPreOrdem(node.right);
		}
	}

	public void travessiaPosOrdem(Node node) {
		if(node != null) {
			travessiaPosOrdem(node.left);
			travessiaPosOrdem(node.right);
			JOptionPane.showMessageDialog(null, " " + node.nome);
			resultadoTravessia += " " + node.nome;
		}
	}

	public void travessiaLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			Node node = queue.poll();
			JOptionPane.showMessageDialog(null, " " + node.nome);
			resultadoTravessia += " " + node.nome;
			
			if (node.left != null)
				queue.add(node.left);
			
			if (node.right != null)
				queue.add(node.right);

		}

	}

	public int calculaAltura(Node node) {
		int alturaEsquerda = 0;
		int alturaDireita = 0;

		if(root == null)
			return 0;

		if(node.left != null)
			alturaEsquerda = calculaAltura(node.left) + 1;

		if(node.right != null)
			alturaDireita = calculaAltura(node.right) + 1;

		if(alturaEsquerda > alturaDireita)
			return alturaEsquerda;

		return alturaDireita;
	}

	public String menorElemento(Node node) {
		if(root == null)
			return null;

		Node nodeAux = node;

		while(nodeAux.left != null) {
			nodeAux = nodeAux.left;
		}

		return nodeAux.nome;
	}

	public String maiorElemento(Node node) {
		if(root == null)
			return null;

		Node nodeAux = node;

		while(nodeAux.right != null) {
			nodeAux = nodeAux.right;
		}

		return nodeAux.nome;
	}

	public int getTamanho() {
		return tamanho;
	}

	public Node getRoot() {
		return root;
	}

	public String getResultadoTravessia() {
		return resultadoTravessia;
	}

	public void setResultadoTravessia(String s) {
		resultadoTravessia = s;
	}

	private class Node {
		private String nome;
		private Node left;
		private Node right;

		private Node(String nome) {
			this.nome = nome;
			right = null;
			left = null;
		}

		private String getNome() { return this.nome; }
	}
}
