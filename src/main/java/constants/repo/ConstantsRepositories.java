package constants.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import constants.repo.domain.Constant;
import constants.repo.domain.EntityType;

public class ConstantsRepositories {
  Map<EntityType, ConstantRepository<?>> repositories = new HashMap<>();

  public ConstantsRepositories() {
    repositories.put(EntityType.AD_SIZE, new AdSizeRepository());
  }

  <T extends ConstantRepository<?>> T getRepository(
      EntityType entityType) {
    return (T) repositories.get(entityType);
  }

  <T> List<Constant<T>> getEntities(Locale locale, EntityType entityType) {
    ConstantRepository<T> repo = getRepository(entityType);
    return repo.getEntities(locale);
  }
}
