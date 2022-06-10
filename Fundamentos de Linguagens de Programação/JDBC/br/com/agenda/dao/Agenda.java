package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contact;

/**
 * Agenda DAO (Data Access Object)
 * 
 * CRUD
 * C: Create - Armazena contatos na agenda do Banco de Dados ✔️
 * R: Read   - Lê as entradas da agenda do Banco de Dados ✔️
 * U: Update - Atualiza os contatos salvos na agenda do Banco de Dados ✔️
 * D: Delete - Remove contatos da agenda no Banco de Dados ✔️
 */
public class Agenda {
    static final String TABLE = "contacts";
    static final String ID = "id";
    static final String NAME = "name";
    static final String AGE = "age";
    static final String SIGNIN = "signDate";
    static final String LOGIN = "logDate";

    public void save(Contact contact) {
        final String SQL = String.format(
                "INSERT INTO %s(%s, %s, %s, %s) VALUES (?, ?, ?, ?)",
                TABLE, NAME, AGE, SIGNIN, LOGIN);
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            // Cria a conecção com o banco de dados.
            connection = ConnectionFactory.createMySQLConnection();
            // Declaração que executará a query.
            pstm = connection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            Date date = new Date(contact.getLogDate().getTime());
            // Adiciona os valores que são esperados pela query.
            pstm.setString(1, contact.getName());
            pstm.setInt(2, contact.getAge());
            pstm.setDate(3, date);
            pstm.setDate(4, date);

            // Executa a query
            // pstm.execute(); // Não recupera o id
            pstm.executeUpdate();
            // Recupera o id
            rset = pstm.getGeneratedKeys();
            if (rset.next()) // Usa `rset` para obter o id do ítem inserido.
                contact.setId(rset.getInt(1));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Fecha as conexões
            try {
                if (pstm != null)
                    pstm.close();
                if (connection != null)
                    connection.close();
                if (rset != null)
                    rset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public List<Contact> getContacts() {
        String SQL = String.format("SELECT * FROM %s", TABLE);
        Connection connection = null;
        PreparedStatement pstm = null;
        List<Contact> contacts = new ArrayList<Contact>(); // Retorno
        // Classe que irá recuperar os dados do banco. "SELECT"
        ResultSet rset = null;

        try {
            connection = ConnectionFactory.createMySQLConnection();
            pstm = connection.prepareStatement(SQL);
            // Executa a query, capturando o retorno.
            rset = pstm.executeQuery();

            while (rset.next()) {
                Contact contact = new Contact();
                // Recupera as informações da coluna de dados da tabela.
                contact.setId(rset.getInt(ID));
                contact.setName(rset.getString(NAME));
                contact.setAge(rset.getInt(AGE));
                contact.setSignDate(rset.getDate(SIGNIN));
                contact.setLogDate(rset.getDate(LOGIN));
                ((ArrayList<Contact>) contacts).add(contact);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null)
                    rset.close();
                if (pstm != null)
                    pstm.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return contacts;
    }

    public Contact getContact(int id) {
        String SQL = String.format("SELECT * from %s WHERE %s = ?", TABLE, ID);
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Contact contact = new Contact();
        
        try {
            connection = ConnectionFactory.createMySQLConnection();
            pstm = connection.prepareStatement(SQL);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();
            rset.next();
            // Recupera as informações do contato do id recuperado.
            contact.setId(id);
            contact.setName(rset.getString(NAME));
            contact.setAge(rset.getInt(AGE));
            contact.setLogDate(rset.getDate(LOGIN));
            contact.setSignDate(rset.getDate(SIGNIN));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null)
                    rset.close();
                if (pstm != null)
                    pstm.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return contact;
    }

    public void update(Contact contact) {
        String SQL = String.format(
                "UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?",
                TABLE, NAME, AGE, SIGNIN, LOGIN, ID);
        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createMySQLConnection();
            pstm = connection.prepareStatement(SQL);
            // Adiciona os valores a serem atualizados
            pstm.setString(1, contact.getName());
            pstm.setInt(2, contact.getAge());
            pstm.setDate(3, new Date(contact.getSignDate().getTime()));
            pstm.setDate(4, new Date(contact.getLogDate().getTime()));
            pstm.setInt(5, contact.getId());
            pstm.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null)
                   pstm.close();
                   if (connection != null)
                   connection.close();
                } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteByID(int id) {
        String SQL = String.format("DELETE FROM %s WHERE %s = ?", TABLE, ID);
        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createMySQLConnection();
            pstm = connection.prepareStatement(SQL);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null)
                    pstm.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
