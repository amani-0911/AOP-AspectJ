package metier;

import java.util.HashMap;
import java.util.Map;

public class IMetierImpl implements IMetier {

  private Map<Long,Compte> comptes=new HashMap<>();

    @Override
    public void addCompte(Compte cp) {
         Compte existe=comptes.get(cp.getCode());
        if(existe!=null){
            return;
        }else{
            comptes.put(cp.getCode(),cp);
        }
    }

    @Override
    public void verser(Long code, double mt) {
        Compte compte=comptes.get(code);
        double newSolde=0;
        newSolde=compte.getSolde()+mt;
        compte.setSolde(newSolde);
        comptes.put(code,compte);

    }

    @Override
    public void retirer(Long code, double mt) {
        Compte compte=comptes.get(code);
        double newSolde=0;
        newSolde=compte.getSolde()-mt;
        compte.setSolde(newSolde);
        comptes.put(code,compte);
    }

    @Override
    public Compte getCompte(Long code) {
        return comptes.get(code);
    }
}
