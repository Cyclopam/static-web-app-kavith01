package com.dxc;


import com.dxc.dao.ContactDAO;
import com.dxc.entity.Contact;

import java.util.List;
import java.util.Scanner;

public class ContactApplication {
    public static void main(String[] args) {

        /*System.out.printf("Hello and welcome!");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }*/

        Scanner sc = new Scanner(System.in);
        ContactDAO  dao = new ContactDAO();
        while (true)
        {
            System.out.printf("\n=======Contact Application=========");
            System.out.printf("1. Show All Contacts");
            System.out.printf("2. View Contact");
            System.out.printf("3. Add Contact");
            System.out.printf("4. Update Contact");
            System.out.printf("5. Delete Contact");
            System.out.printf("6. Exit");
            System.out.printf("Enter Choice  :");

            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    List<Contact> contacts=dao.getAllContacts();
                    for(Contact c:contacts)
                    {
                        System.out.println(c.getId()+" "+c.getName()+" "+c.getPhone()+" "+c.getEmail());
                    }
                    break;
                case 2:
                    System.out.println("enter Id: ");
                    int id=sc.nextInt();
                    Contact contact = dao.getContactById(id);
                    if(contact!=null)
                    {
                        System.out.println(contact.getId()+" "+contact.getName()+" "+contact.getPhone()+" "+contact.getEmail());
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Name:  ");
                    String name=sc.nextLine();

                    System.out.print("Phone:  ");
                    String phone=sc.nextLine();

                    System.out.print("Email:  ");
                    String email=sc.nextLine();

                    dao.addContact(new Contact(0,name,phone,email));
                    break;

                case 4:
                    System.out.print("Id: ");
                    int updateId=sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name:  ");
                    String newName = sc.nextLine();

                    System.out.print("Phone:  ");
                    String newPhone=sc.nextLine();

                    System.out.print("Email:  ");
                    String newEmail=sc.nextLine();

                    dao.updateContact(new Contact(updateId,newName,newPhone,newEmail));
                    break;

                case 5:

                    System.out.print("Id: ");
                    int deleteId =sc.nextInt();
                    dao.deleteContact(deleteId);
                    break;
                case 6:
                    System.out.println("Application Closed");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }

        }

}



