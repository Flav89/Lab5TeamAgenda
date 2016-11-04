/**
 * Created by Flavius  on 01/11/16.
 */

public class Agenda {


    static String[] listName = new String[5];



    public static void main(String[] args) {

        int option;


        do {

            menu();

            option = SkeletonJava.readIntConsole("choose an option: ");

            switch (option) {

                case 1 :   list(listName);break; //print

                case 2 :   add(SkeletonJava.readStringConsole("Add contact name:" ));break; //add

                case 3 :   del(SkeletonJava.readStringConsole("Delete contact: "));break; //del

                case 4 :   modify(SkeletonJava.readStringConsole("Edit contact: "),
                           SkeletonJava.readStringConsole("edit: "));break; //modify

                case 0 :   System.out.println("Exit!");break; //Exit

                default:  System.out.println("invalid option!");break;
            }
        } while (option !=0);
    }





    public static void menu() {
        System.out.println("\n1 - LIST" +
                "\n2 - ADD" +
                "\n3 - DELETE" +
                "\n4 - MODIFY" +
                "\n0 - EXIT");
    }


    public static void list(String[] listName) {

        System.out.println("\nContacts list: ");

        for (int i = 0; i < listName.length; i++) {
            if (listName[i] != null) {
                System.out.println("\t" + listName[i]);
            }
        }
    }

    public static void adaugare(String name) {

            for (int i = 0; i < listName.length; i++) {
                if (listName[i] == null)  {
                    listName[i] = name;
                    break;
                } else if (i == listName.length - 1) {       //toate elementele sunt diferite de null
                    System.out.println("List is full!");
                    break;
                }
            }
        }



    public static void add(String name) {
        int i = search(name);
        if (i == -1) {
            adaugare(name);
        }
    }

    public static int search(String name) {
        int r = -1;
        for (int i = 0; i < listName.length; i++) {
            if (name.equals(listName[i])) {
                r = i;
                System.out.println("Nume deja introdus!");
                break;
            }
        }
        return r;

    }

    public static void sterge(int index, String name) {
        listName[index] = null;
        System.out.println("Contact " + name + " from index " + index  + " " + " has been deleted!");
    }


    public static void modifica(int index, String oldContact, String newContact) {
        listName[index] = newContact;
        System.out.println("Contact " + oldContact + " from index " + index + " " + "has been modified!");
    }



    public static void del(String name) {
        int indexContact = search(name);
        if (indexContact != -1) {
            sterge(indexContact, name);
        }
    }




    public static void modify(String oldContact, String newContact) {
        int indexContact = search(oldContact);

        if (indexContact != -1) {
            modifica(indexContact, oldContact, newContact);

        }
    }

}







