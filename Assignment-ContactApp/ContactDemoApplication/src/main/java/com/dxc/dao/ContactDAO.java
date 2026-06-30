package com.dxc.dao;

import com.dxc.entity.Contact;
import com.dxc.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
public List<Contact> getAllContacts() {
    List<Contact> contacts = new ArrayList<>();

    String sql = "SELECT * FROM Contacts";
    try (

            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            Contact c = new Contact();
            c.setId(rs.getInt("contact_id"));
            c.setName(rs.getString("name"));
            c.setPhone(rs.getString("phone"));
            c.setEmail(rs.getString("email"));
            contacts.add(c);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return contacts;
}
    public Contact getContactById(int id)
    {
        String sql ="SELECT * FROM Contacts WHERE contact_id=?";
        try ( Connection con=DBConnection.getConnection();
              PreparedStatement ps=con.prepareStatement(sql))
        {
            ps.setInt(1 ,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Contact(rs.getInt("contact_id") ,
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email")
                );
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addContact(Contact contact){
        String sql ="INSERT INTO Contacts(name,phone,email) VALUES(?,?,?)";
        try ( Connection con=DBConnection.getConnection();
              PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getPhone());
            ps.setString(3, contact.getEmail());
            ps.executeUpdate();
            System.out.println("Contact Added");
        } catch (Exception e) {
            e.printStackTrace();
        }
       }
    public void updateContact(Contact contact){
        String sql ="UPDATE Contacts SET name=?,phone=?,email=? WHERE contact_id=?";
        try ( Connection con=DBConnection.getConnection();
              PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getPhone());
            ps.setString(3, contact.getEmail());
            ps.setInt(4,contact.getId());
            ps.executeUpdate();
            System.out.println("Contact Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void deleteContact(int id)
    {
        String sql ="DELETE FROM Contacts WHERE contact_id=?";
        try ( Connection con=DBConnection.getConnection();
              PreparedStatement ps=con.prepareStatement(sql))
        {
            ps.setInt(1 ,id);
            ps.executeUpdate();
            System.out.println("Contact Deleted");

            }
        catch(Exception e) {
            e.printStackTrace();
        }

    }


    }



