/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojainformatica.dao;

import com.mycompany.lojainformatica.model.Computador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexs
 */
public class ComputadoresDAO {

    public static boolean salvar(Computador obj) {

        boolean retorno = false;
        Connection conexao = null;
        try {
            // passo 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/lojainformatica";

            conexao = DriverManager.getConnection(url, "root", "");
            //PASSO 3  prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO computador " + "(marca,Processador,HD)VALUES (?,?,?)");

            comandoSQL.setString(1, Computador.getMarcaPadrao());

            comandoSQL.setString(2, obj.getPrecessador());

            comandoSQL.setString(3, obj.getHD());

            //passo 4 excutar
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {

                retorno = true;

            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver !!");
        } catch (SQLException ex) {
            System.out.println("Erro ao abrir a conexão !!");
        }

        return retorno;

    }

    /**
     * define um método que cria e retorna uma lista de objetos do tipo
     * "Computador". A lista é criada vazia e preenchida com objetos do tipo
     * "Computador"
     */
    public static ArrayList<Computador> listar() {

        ArrayList<Computador> listaRetorno = new ArrayList<>();
        Connection conexao = null;// conexao representa uma conexão ativa com um banco de dados.
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 
            String url = "jdbc:mysql://localhost:3306/lojainformatica";
            conexao = DriverManager.getConnection(url, "root", ""); //estabelecendo a conexao para os receber resultados.
            // passo 3 preparar o comando SQL
            /* cria um objeto "PreparedStatement" que contém uma consulta SQL para buscar todos os registros da tabela "computador" */
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM computador");

            //passo 4 executar o comando SQL 
            ResultSet amazenarConsulta = comandoSQL.executeQuery();
            if (amazenarConsulta != null) {
                //percorro o resultset e passo os valores a um objeto 

                while (amazenarConsulta.next()) {
                    Computador objcomputadorDAO = new Computador();

                    objcomputadorDAO.setNumeroDoComputador(amazenarConsulta.getInt("numeroDoComputador"));
                    objcomputadorDAO.setMarca(amazenarConsulta.getString("marca"));
                    objcomputadorDAO.setPrecessador(amazenarConsulta.getString("Processador"));
                    objcomputadorDAO.setHD(amazenarConsulta.getString("HD"));
                    listaRetorno.add(objcomputadorDAO);
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("erro ao carrregar o drive !!");
        } catch (SQLException ex) {
            System.out.println(" Erro ao abrir conexão !!");

        }
        return listaRetorno;

    }

    public static boolean excluir(int id) {

        boolean retorno = false;
        Connection conexao = null;
        try {
            // passo 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/lojainformatica";

            conexao = DriverManager.getConnection(url, "root", "");
            //PASSO 3  prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM computador WHERE numerodocomputador =?");

            comandoSQL.setInt(1, id);

            //passo 4 excutar
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver !!");
        } catch (SQLException ex) {
            System.out.println("Erro ao abrir a conexão !!");
        }
        return retorno;

    }

    public static boolean alterar(Computador obj) {

        boolean retorno = false;
        Connection conexao = null;

        try {
            //Passo 1 - Carregaro o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/lojainformatica";

            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "");

            //Passo 3 - Prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE computador SET Processador = ?, HD = ? WHERE numeroDoComputador= ?");

            comandoSQL.setString(1, obj.getPrecessador());
            comandoSQL.setString(2, obj.getHD());
            comandoSQL.setInt(3, obj.getNumeroDoComputador());
            //Passo 4 - Executar comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro ao abrir a conexao");
        }

        return retorno;
    }

    public static ArrayList<Computador/*o tipo de objeto que o ArrayList irá armazenar*/> filtro(Computador obj) {

        ArrayList<Computador> listaRetorno = new ArrayList<>();
        Connection conexao = null;// conexao representa uma conexão ativa com um banco de dados.
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 
            String url = "jdbc:mysql://localhost:3306/lojainformatica";
            conexao = DriverManager.getConnection(url, "root", ""); //estabelecendo a conexao para os receber resultados.
            // passo 3 preparar o comando SQL
            /* cria um objeto "PreparedStatement" que contém uma consulta SQL para buscar todos os registros da tabela "computador" */
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM computador where processador = ?");
            comandoSQL.setString(1, obj.getPrecessador());

            //passo 4 executar o comando SQL 
            ResultSet amazenarConsulta = comandoSQL.executeQuery();
            if (amazenarConsulta != null) {
                //percorro o resultset e passo os valores a um objeto 

                while (amazenarConsulta.next()) {
                    Computador objcomputadorDAO = new Computador();

                    objcomputadorDAO.setNumeroDoComputador(amazenarConsulta.getInt("numeroDoComputador"));
                    objcomputadorDAO.setMarca(amazenarConsulta.getString("marca"));
                    objcomputadorDAO.setPrecessador(amazenarConsulta.getString("Processador"));
                    objcomputadorDAO.setHD(amazenarConsulta.getString("HD"));
                    listaRetorno.add(objcomputadorDAO);
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("erro ao carrregar o drive !!");
        } catch (SQLException ex) {
            System.out.println(" Erro ao abrir conexão !!");

        }
        return listaRetorno;

    }

}
