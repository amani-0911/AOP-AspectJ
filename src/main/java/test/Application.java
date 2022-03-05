package test;

import metier.Compte;
import metier.IMetier;
import metier.IMetierImpl;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
      new Application().start();
    }

    private void start() {
        System.out.println("Démarrage de l'application....");
        Scanner scanner=new Scanner(System.in);
        System.out.print("code: ");
        Long code=scanner.nextLong();
        System.out.print("Solde: ");
        double solde=scanner.nextDouble();

        IMetier metier=new IMetierImpl();

        metier.addCompte(new Compte(code,solde));

        while (true){
           try {
               System.out.println("--------------------");
               System.out.println(metier.getCompte(code).toString());
               System.out.print("type Operation: ");
               String operation = scanner.next();
               if (operation.toLowerCase().equals("q")) break;
               else {
                   System.out.print("Montant: ");
                   double mt = scanner.nextDouble();
                   if (operation.toLowerCase().equals("v")) metier.verser(code, mt);
                   else if (operation.toLowerCase().equals("r")) metier.retirer(code, mt);
               }
           }catch(Exception e){
               System.out.println(e.getMessage());
           }


        }
        System.out.println("Fin d'application");
    }
}
