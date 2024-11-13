package br.com.edu.ufca.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.edu.ufca.Contact;

/**
 * Agenda DAO (Data Access Object)
 *
 * CRUD
 * C: Create - Armazena contatos na agenda do Banco de Dados ✔️
 * R: Read - Lê as entradas da agenda do Banco de Dados ✔️
 * U: Update - Atualiza os contatos salvos na agenda do Banco de Dados ✔️
 * D: Delete - Remove contatos da agenda no Banco de Dados ✔️
 */
public class AgendaDAO {
    public final String TABLE = "contacts";
    public final String ID = "id";
    public final String NAME = "name";
    public final String EMAIL = "email";
    public final String PHONE = "phone";
    public final String ADDRESS = "address";
    public final String dbName;

    public AgendaDAO(String dbName) {
        this.dbName = dbName;
    }

    public void save(Contact contact) {
        final String SQL = String.format(
                "INSERT INTO %s(%s, %s, %s, %s) VALUES (?, ?, ?, ?)",
                TABLE, NAME, EMAIL, PHONE, ADDRESS);
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            // Cria a conecção com o banco de dados.
            connection = ConnectionFactory.createMySQLConnection(this.dbName);
            // Declaração que executará a query.
            pstm = connection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            // Adiciona os valores que são esperados pela query.
            pstm.setString(1, contact.getName());
            pstm.setString(2, contact.getEmail());
            pstm.setString(3, contact.getPhone());
            pstm.setString(4, contact.address);

            // Executa a query
            // pstm.execute(); // Não recupera o id

            // Recupera o id
            pstm.executeUpdate();
            rset = pstm.getGeneratedKeys();

            if (rset.next()) // Usa `rset` para obter o id do item inserido.
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
            connection = ConnectionFactory.createMySQLConnection(this.dbName);
            pstm = connection.prepareStatement(SQL);
            // Executa a query, capturando o retorno.
            rset = pstm.executeQuery();

            while (rset.next()) {
                // Recupera as informações da coluna de dados da tabela.
                Contact contact = new Contact(
                        rset.getString(NAME),
                        rset.getString(EMAIL),
                        rset.getString(PHONE));
                contact.address = rset.getString(ADDRESS);
                contact.setId(rset.getInt(ID));

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
        Contact contact = null;

        try {
            connection = ConnectionFactory.createMySQLConnection(this.dbName);
            pstm = connection.prepareStatement(SQL);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();
            rset.next();

            // Recupera as informações do contato do id recuperado.
            contact = new Contact(
                    rset.getString(NAME),
                    rset.getString(EMAIL),
                    rset.getString(PHONE));
            contact.address = rset.getString(ADDRESS);
            contact.setId(id);

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
                TABLE, NAME, EMAIL, PHONE, ADDRESS, ID);
        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createMySQLConnection(this.dbName);
            pstm = connection.prepareStatement(SQL);

            // Adiciona os valores a serem atualizados
            pstm.setString(1, contact.getName());
            pstm.setString(2, contact.getEmail());
            pstm.setString(3, contact.getPhone());
            pstm.setString(4, contact.address);
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
            connection = ConnectionFactory.createMySQLConnection(this.dbName);
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
