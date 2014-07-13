package constants.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import constants.repo.domain.Constant;
import constants.repo.domain.ConstantType;

public class ConstantsRepositories {
  Map<ConstantType, ConstantRepository<?>> repositories = new HashMap<>();

  public ConstantsRepositories() {
    repositories.put(ConstantType.AD_SIZE, new AdSizeRepository());
  }

  <T extends ConstantRepository<?>> T getRepository(
      ConstantType entityType) {
    return (T) repositories.get(entityType);
  }

  <T> List<Constant<T>> getEntities(Locale locale, ConstantType entityType) {
    ConstantRepository<T> repo = getRepository(entityType);
    return repo.getEntities(locale);
  }
}
