package constants.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import constants.repo.domain.AdSizeType;
import constants.repo.domain.Constant;
import constants.repo.domain.ConstantType;

public class Main {
  public static void main(String[] args) {
    ConstantsRepositories cr = new ConstantsRepositories();

    // AdSizeType constants
    List<Constant<AdSizeType>> constants = cr.getEntities(Locale.US,
        ConstantType.AD_SIZE);
    System.out.println(constants);
    constants.get(0).getAttributes();
    
    // By size
    AdSizeRepository asr = cr.getRepository(ConstantType.AD_SIZE);
    asr.bySize(Locale.US, 250, 250);

    // All entities from all repos
    List<Constant<?>> all = new ArrayList<>();
    for (ConstantType t : ConstantType.values()) {
      all.addAll(cr.getRepository(t).getEntities(Locale.US));
    }
  }
}