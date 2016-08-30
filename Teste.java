package br.com.fiap.testes;
import javax.swing.JOptionPane;

import br.com.fiap.beans.Funcionarios;
import br.com.fiap.excecoes.Excecao;
public class Teste{
	public static String texto(String mensagem){
		return JOptionPane.showInputDialog(mensagem);
	}
	public static short numero(String mensagem){
		return Short.parseShort(JOptionPane.showInputDialog(mensagem));
	}
	public static double real(String mensagem){
		return Double.parseDouble(JOptionPane.showInputDialog(mensagem));
	}
	public static int pergunta(String mensagem, String titulo){
		return JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
	public static int totalFuncionarios(Funcionarios[] vetor){
		int j=0;
		for(int i=0; i<vetor.length; i++){
			if(vetor[i] != null){
				j++;
			}
		}
		return j;
	}
	public static double mediaSalario(Funcionarios[] vetor){
		double soma = 0;
		int i = 0;
		while(i <= vetor.length-1){
			if (vetor[i] != null){
				soma = soma + vetor[i].getSalario();
				i++;
			}
		}
		return soma/i;
	}
	public static double totalSalario(Funcionarios[] vetor){
		double soma = 0;
		int i = 0;
		while(i <= vetor.length-1){
			if (vetor[i] != null){
				soma = soma + vetor[i].getSalario();
				i++;
			}
		}
		return soma;
	}
	public static void nomes(Funcionarios[] vetor){
		String msg = new String();
		msg = "";
		for(int i = 0; i< vetor.length; i++){
			if (vetor[i] != null){
				msg = msg + "\nNome:" + vetor[i].getNome();
			}
		}
		JOptionPane.showMessageDialog(null, msg);
	}
	public static void salarios(Funcionarios[] vetor){
		String msg = new String();
		msg = "";
		Funcionarios aux = new Funcionarios();
		int i = 0;
		for(i=0; i<vetor.length;i++){
			for(int k = 0; k<i;k++){
				if (vetor[k].getSalario() > vetor[i].getSalario()){
						aux = vetor[k];
						vetor[k] = vetor[i];
						vetor[i] = aux;
				}
			}	
		}
			
			
		
		for(i = 0; i<=(vetor.length-1); i++){
			msg = msg + "\nNome: " + vetor[i].getNome() + "\nSalário: " + vetor[i].getSalario();
		}
		
		JOptionPane.showMessageDialog(null, msg);
	}
	public static void cargos(Funcionarios[] vetor){
		String msg = new String();
		msg = "";
		Funcionarios aux = new Funcionarios();
		int i, j;
		for(i=0;i<vetor.length;i++){
			for(j=0; j<i;j++){
				if(vetor[i].getCargos().toLowerCase().charAt(0) == 'e' && vetor[j].getCargos().toLowerCase().charAt(0) == 'p'){
						aux = vetor[j];
						vetor[j] = vetor[i];
						vetor[i] = aux;
				}
			}
		}
		for(i=0; i< vetor.length; i++){
			msg = msg + "\nNome: " + vetor[i].getNome() + "\nCargo: " + vetor[i].getCargos();
		}
		JOptionPane.showMessageDialog(null, msg);
	}
	public static void deletar(Funcionarios[] vetor){
		String msg = new String();
		int i=0, j;
		for(i=0; i<vetor.length; i++){
			if(vetor[i]!= null){
				if(vetor[i].getSalario() > 6000){
					j=i;
					for(int k=i+1; k<vetor.length;k++){
						vetor[j] = vetor[k];
						j++;
					}
					vetor[vetor.length-1] = null;
				}
			}
		}
		for(i=0; i< vetor.length; i++){
			if(vetor[i]!= null){
				msg = msg + "\nPosição: " + i + "\nNome: " + vetor[i].getNome() + "\nSalário: " + vetor[i].getSalario();
			}	
		}
		JOptionPane.showMessageDialog(null, msg);
		
	}
	public static void main(String[] args) throws Excecao{
		try{
			short iVetor = numero("Qual o tamanho do vetor?");
			Funcionarios[] vetorFuncionario = new Funcionarios[iVetor];
			int i = 0;
			while(i< iVetor && pergunta("Deseja cadastrar um funcionário?", "Cadastrar") == 0){
				Funcionarios funcionario = new Funcionarios(texto("Nome:"), real("Salário:"), numero("Faltas: "), texto("Cargo: "));
				vetorFuncionario[i] = funcionario;
				i++;
			}
			JOptionPane.showMessageDialog(null, "Total de funcionários cadastrados: " + totalFuncionarios(vetorFuncionario));
			JOptionPane.showMessageDialog(null,	"Média de salarios cadastrados: R$" + mediaSalario(vetorFuncionario));
			JOptionPane.showMessageDialog(null,	"Total de salarios cadastrados: R$" + totalSalario(vetorFuncionario));
			nomes(vetorFuncionario);
			salarios(vetorFuncionario);
			cargos(vetorFuncionario);
			deletar(vetorFuncionario);
		}catch(Exception e){
			throw new Excecao("Alguma coisa deu errado!\n", e);
		}
	}
}
